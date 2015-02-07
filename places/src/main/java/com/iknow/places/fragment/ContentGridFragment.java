/*******************************************************************************
 * Copyright 2011-2014 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.iknow.places.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.iknow.places.R;
import com.iknow.places.domain.content.Content;
import com.iknow.places.domain.enumeration.Category;
import com.iknow.places.net.ContentClient;
import com.iknow.places.net.PhotoLinkBuilder;
import com.jakewharton.disklrucache.DiskLruCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ContentGridFragment extends AbsListViewBaseFragment {

    public static final String TAG = ContentGridFragment.class.getSimpleName();

    public static final int INDEX = 1;
    public static final int pageSize = 12;

    public ArrayList<Content> contents = new ArrayList<>();
    public int threshold = 6;
    public int absoluteCount = 0;
    public boolean isLoading = false;
    public boolean isEnd = false;
    public ImageAdapter adapter;
    public DisplayImageOptions options;
    public DiskLruCache cache;
    public PhotoLinkBuilder photoLinkBuilder;

    public ProgressBar loadMoreBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            cache = DiskLruCache.open(new File(getActivity().getExternalCacheDir(), "jsonCache"), 1, 1, 30 * 1024 * 1024);
        } catch (IOException e) {
            Log.e(TAG, "Error opening cache");
            Log.w(TAG, e);
        }
        photoLinkBuilder = new PhotoLinkBuilder();
        photoLinkBuilder.setFormat(PhotoLinkBuilder.Format.jpg)
                .setType(PhotoLinkBuilder.Type.crop)
                .setHeight(dipToPixels(getActivity(), 400))
                .setWidth(dipToPixels(getActivity(), 400));
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.stub)
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.stub)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(500))
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fr_image_grid, container, false);
        listView = (GridView) rootView.findViewById(R.id.grid);
        adapter = new ImageAdapter();
        ((GridView) listView).setAdapter(adapter);
        loadMoreBar = (ProgressBar) rootView.findViewById(R.id.loader_view);
        onScrollListener = new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    if (listView.getLastVisiblePosition() >= listView.getCount() - 1 - threshold) {
                        loadElements(pageSize);
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        };
        loadElements(pageSize + threshold);
        return rootView;
    }

    public void startLoading() {
        if (loadMoreBar!= null) {
            loadMoreBar.setVisibility(View.VISIBLE);
        }
    }

    public void stopLoading() {
        if (loadMoreBar != null) {
            loadMoreBar.setVisibility(View.INVISIBLE);
        }
    }

    private void loadElements(int count) {
        if (isLoading || isEnd) {
            return;
        }
        int index = getArguments().getInt(ARG_SECTION_NUMBER);
        isLoading = true;
        startLoading();
        new ContentParseTask().execute(new ContentTaskParams(Category.byIndex(index), "Russia_Moscow", absoluteCount, count));
        absoluteCount += count;
    }

    public class ImageAdapter extends BaseAdapter {

        private LayoutInflater inflater;

        ImageAdapter() {
            inflater = LayoutInflater.from(getActivity());
        }

        @Override
        public int getCount() {
            return contents.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            View view = convertView;
            Content content = contents.get(position);
            if (view == null) {
                view = inflater.inflate(R.layout.item_grid_image, parent, false);
                ((CardView)view).setPreventCornerOverlap(false);
                holder = new ViewHolder();
                assert view != null;
                holder.imageView = (ImageView) view.findViewById(R.id.image);
                holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);
                holder.place = (TextView) view.findViewById(R.id.place);
                holder.type = (TextView) view.findViewById(R.id.content_type);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            ViewHolder holder = (ViewHolder) v.getTag();
                            startImagePagerActivity(holder.position, photoLinkBuilder.buildLinks(contents));
                        } catch (URISyntaxException e) {
                            Log.e(TAG, "Link builder error");
                            Log.w(TAG, e);
                        }
                    }
                });
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.position = position;
            holder.place.setText(content.getTitle());
            holder.type.setText(content.getCategories().get(0).getName());
            String fileName = contents.get(position).getAddressCover1x().getFilename();

            String photoLink = "";
            try {
                photoLink = photoLinkBuilder.buildLink(fileName);
            } catch (URISyntaxException e) {
                Log.e(TAG, "Link builder error");
                Log.w(TAG, e);
            }

            if (holder.imageView.getTag() == null ||
                    !holder.imageView.getTag().equals(photoLink)) {

                //we only load image if prev. URL and current URL do not match, or tag is null

                ImageLoader.getInstance()
                        .displayImage(photoLink, holder.imageView, options, new SimpleImageLoadingListener() {
                            @Override
                            public void onLoadingStarted(String imageUri, View view) {
                              //  holder.progressBar.setProgress(0);
                              //  holder.progressBar.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                                holder.progressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                holder.progressBar.setVisibility(View.GONE);
                            }
                        }, new ImageLoadingProgressListener() {
                            @Override
                            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                               // holder.progressBar.setProgress(Math.round(100.0f * current / total));
                            }
                        });
                holder.imageView.setTag(photoLink);
            }


            return view;
        }
    }

    private class ContentParseTask extends AsyncTask<ContentTaskParams, Void, List<Content>> {

        String resultJson = "";

        @Override
        protected List<Content> doInBackground(ContentTaskParams... params) {
            boolean connection = hasActiveInternetConnection(getActivity());

            ContentClient parser = new ContentClient();
            ContentTaskParams param = params[0];
            String key = ("key-" + param.category.name() + "-" + param.region + "-" + param.skip + "-" + param.limit).toLowerCase();
            DiskLruCache.Editor edit = null;
            try {
                if (connection) {
                    resultJson = parser.jsonRequest(param.category, param.region, param.skip, param.limit);
                    edit = cache.edit(key);
                    edit.set(0, resultJson);
                    edit.commit();
                } else {
                    edit = cache.edit(key);
                    resultJson = edit.getString(0);
                    edit.abortUnlessCommitted();
                }
            } catch (Exception e) {
                Log.e(TAG, "Unknown exception");
                Log.w(TAG, e);
                if (edit != null) {
                    edit.abortUnlessCommitted();
                }
            }
            return parser.getElements(resultJson);
        }

        @Override
        protected void onPostExecute(List<Content> contentsToAdd) {
            int needCount = 0;
            if (contentsToAdd == null) {
                contentsToAdd = new ArrayList<>();
            }
            super.onPostExecute(contentsToAdd);
            if(contentsToAdd.size() == 0) {
                isEnd = true;
                isLoading = false;
                stopLoading();
                adapter.notifyDataSetChanged();
                return;
            }
            for (Content content : contentsToAdd) {
                if (content.getType().equals("address")) {
                    contents.add(content);
                } else {
                    needCount++;
                }
            }
            if (needCount > 0) {
                isLoading = false;
                loadElements(needCount);
            } else {
                isLoading = false;
                stopLoading();
                adapter.notifyDataSetChanged();
            }
        }

    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public static boolean hasActiveInternetConnection(Context context) {
        if (isNetworkAvailable(context)) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://api.iknow.travel/").openConnection());
                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 200);
            } catch (IOException e) {
                Log.e(TAG, "Error checking internet connection", e);
            }
        } else {
            Log.d(TAG, "No network available!");
        }
        return false;
    }

    private static boolean isNetworkAvailable(Context context) {
        if(context == null) {
            return true;
        }
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    static class ViewHolder {
        Integer position;
        ImageView imageView;
        ProgressBar progressBar;
        TextView place;
        TextView type;
    }

    static class ContentTaskParams {
        Category category;
        String region;
        Integer skip;
        Integer limit;

        public ContentTaskParams(Category category, String region, Integer skip, Integer limit) {
            this.category = category;
            this.region = region;
            this.skip = skip;
            this.limit = limit;
        }
    }
}