package com.iknow.places.net;

import com.iknow.places.domain.content.Content;
import org.apache.http.client.utils.URIUtils;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Rufim on 05.02.2015.
 */
public class PhotoLinkBuilder {
    Type type =Type.gallery;
    Integer width = 400;
    Integer height = 400;
    Format format = Format.jpg;

    public enum Type {
        crop, gallery, cover
    }

    public enum Format {
        jpg, webp
    }

    public PhotoLinkBuilder() {
    }

    public PhotoLinkBuilder(String fileName, Type type, Integer width, Integer height, Format format) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.format = format;
    }

    public List<String> buildLinks(Collection<Content> contents) throws URISyntaxException {
        ArrayList<String> links = new ArrayList<>(contents.size());
        for(Content content : contents) {
            links.add(buildLink(content.getAddressCover1x().getFilename()));
        }
        return links;
    }

    public String buildLink(String fileName) throws URISyntaxException {
        return URIUtils.createURI(JsonClient.SCHEME, JsonClient.HOST, -1, "photo/" + type.name() + "/" + fileName + "_" + width + "x" + height + "." + format.name(), null, null).toString();
    }

    public PhotoLinkBuilder setType(Type type) {
        this.type = type;
        return this;
    }

    public PhotoLinkBuilder setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public PhotoLinkBuilder setWidth(Float width) {
        this.width = width.intValue();
        return this;
    }


    public PhotoLinkBuilder setHeight(Float height) {
        this.height = height.intValue();
        return this;
    }

    public PhotoLinkBuilder setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public PhotoLinkBuilder setFormat(Format format) {
        this.format = format;
        return this;
    }
}
