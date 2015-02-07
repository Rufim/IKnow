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

import android.content.Intent;
import android.widget.AbsListView;
import com.iknow.places.Constants;
import com.iknow.places.activity.SimpleImageActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

import java.util.List;


/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public abstract class AbsListViewBaseFragment extends PlaceholderFragment {


	protected AbsListView listView;

	protected boolean pauseOnScroll = false;
	protected boolean pauseOnFling = true;
    protected AbsListView.OnScrollListener onScrollListener = null;

	@Override
	public void onResume() {
		super.onResume();
		applyScrollListener();
	}


	protected void startImagePagerActivity(int position, List<String> links) {
		Intent intent = new Intent(getActivity(), SimpleImageActivity.class);
		intent.putExtra(Constants.Extra.FRAGMENT_INDEX, ImagePagerFragment.INDEX);
		intent.putExtra(Constants.Extra.IMAGE_POSITION, position);
        intent.putExtra(Constants.Extra.IMAGE_LINKS, links.toArray(new String[links.size()]));
		startActivity(intent);
	}

	private void applyScrollListener() {
		listView.setOnScrollListener(new PauseOnScrollListener(ImageLoader.getInstance(), pauseOnScroll, pauseOnFling, onScrollListener));
	}
}
