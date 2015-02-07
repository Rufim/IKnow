package com.iknow.places.domain.enumeration;

/**
* Created by Rufim on 06.02.2015.
*/
public enum Category {
    all, food, art, shopping, health, nightlife, nature, urban, history, family, activity, view, accomodation, transport;

    public static Category byIndex(int index) {
        return Category.values()[index];
    }
}
