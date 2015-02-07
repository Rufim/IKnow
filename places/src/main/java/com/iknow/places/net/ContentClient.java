package com.iknow.places.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iknow.places.domain.content.Content;
import com.iknow.places.domain.enumeration.Category;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Rufim on 05.02.2015.
 */
public class ContentClient extends JsonClient<Content> {

    public String jsonRequest(Category category, String region, Integer skip, Integer limit) throws IOException, URISyntaxException {
        List<NameValuePair> params = new ArrayList<>(4);
        params.add(new BasicNameValuePair("category", category.name()));
        params.add(new BasicNameValuePair("region", region));
        params.add(new BasicNameValuePair("limit", limit.toString()));
        params.add(new BasicNameValuePair("skip", skip.toString()));
        return super.jsonRequest("contents", params);
    }

    public List<Content> getElements(String jsonString) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Content>>() {
        }.getType();
        List<Content> enums = gson.fromJson(jsonString, collectionType);
        return enums;
    }

}
