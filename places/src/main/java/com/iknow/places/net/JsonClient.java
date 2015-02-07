package com.iknow.places.net;

import android.support.v4.util.LruCache;
import android.util.Log;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Rufim on 05.02.2015.
 */
public abstract class JsonClient<T> {

    private static final String TAG = JsonClient.class.getSimpleName();

    public static final String ACCEPT_VALUE = "application/json";
    public static final String X_USER_AGENT_VALUE = "citrus/154";
    public static final String X_API_VERSION_VALUE = "4";
    public static final String HOST = "api.iknow.travel";
    public static final String SCHEME = "http";

    private static LruCache<String, String> parserCache = new LruCache<>(200);

    protected String jsonRequest(String path, List<NameValuePair> params) throws IOException, URISyntaxException {
        URI uri = URIUtils.createURI(SCHEME, HOST, -1, path, URLEncodedUtils.format(params, "UTF-8"), null);
        if(parserCache.get(uri.toString()) != null) {
            return parserCache.get(uri.toString());
        }

        HttpGet jsonRequest = new HttpGet(uri);
        HttpClient httpClient = new DefaultHttpClient();
        jsonRequest.addHeader("X-Api-Version", X_API_VERSION_VALUE);
        jsonRequest.addHeader("Accept", ACCEPT_VALUE);
        jsonRequest.addHeader("X-User-Agent", X_USER_AGENT_VALUE);

        InputStream inputStream = httpClient.execute(jsonRequest).getEntity().getContent();
        StringBuffer buffer = new StringBuffer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        parserCache.put(uri.toString(), buffer.toString());
        Log.e(TAG, "Request using url: " + uri.toString());
        return buffer.toString();
    }

    public abstract List<T> getElements(String jsonString);

    public static void dropCache(String url) {
        parserCache.remove(url);
    }

    private static class JsonCache {
        public String json = null;
        public String url = null;

        public JsonCache(String json, String url) {
            this.json = json;
            this.url = url;
        }

    }

}
