
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class City {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("booking_id")
    @Expose
    private String bookingId;
    @Expose
    private Country country;
    @Expose
    private String created;
    @SerializedName("geo_id")
    @Expose
    private Integer geoId;
    @SerializedName("google_id")
    @Expose
    private String googleId;
    @Expose
    private String iata;
    @Expose
    private Location location;
    @SerializedName("map_url")
    @Expose
    private String mapUrl;
    @Expose
    private Double rating;
    @Expose
    private String type;
    @Expose
    private String updated;
    @SerializedName("_searchable")
    @Expose
    private Searchable Searchable;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @Expose
    private Morpher morpher;
    @Expose
    private String name;
    @SerializedName("area_name")
    @Expose
    private String areaName;
    @Expose
    private String locale;

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The V
     */
    public Integer getV() {
        return V;
    }

    /**
     * 
     * @param V
     *     The __v
     */
    public void setV(Integer V) {
        this.V = V;
    }

    /**
     * 
     * @return
     *     The bookingId
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * 
     * @param bookingId
     *     The booking_id
     */
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * 
     * @return
     *     The country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The geoId
     */
    public Integer getGeoId() {
        return geoId;
    }

    /**
     * 
     * @param geoId
     *     The geo_id
     */
    public void setGeoId(Integer geoId) {
        this.geoId = geoId;
    }

    /**
     * 
     * @return
     *     The googleId
     */
    public String getGoogleId() {
        return googleId;
    }

    /**
     * 
     * @param googleId
     *     The google_id
     */
    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    /**
     * 
     * @return
     *     The iata
     */
    public String getIata() {
        return iata;
    }

    /**
     * 
     * @param iata
     *     The iata
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The mapUrl
     */
    public String getMapUrl() {
        return mapUrl;
    }

    /**
     * 
     * @param mapUrl
     *     The map_url
     */
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *     The Searchable
     */
    public com.iknow.places.domain.content.Searchable getSearchable() {
        return Searchable;
    }

    /**
     * 
     * @param Searchable
     *     The _searchable
     */
    public void setSearchable(com.iknow.places.domain.content.Searchable Searchable) {
        this.Searchable = Searchable;
    }

    /**
     * 
     * @return
     *     The countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * @param countryName
     *     The country_name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * 
     * @return
     *     The morpher
     */
    public Morpher getMorpher() {
        return morpher;
    }

    /**
     * 
     * @param morpher
     *     The morpher
     */
    public void setMorpher(Morpher morpher) {
        this.morpher = morpher;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 
     * @param areaName
     *     The area_name
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 
     * @return
     *     The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * 
     * @param locale
     *     The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Id).append(V).append(bookingId).append(country).append(created).append(geoId).append(googleId).append(iata).append(location).append(mapUrl).append(rating).append(type).append(updated).append(Searchable).append(countryName).append(morpher).append(name).append(areaName).append(locale).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof City) == false) {
            return false;
        }
        City rhs = ((City) other);
        return new EqualsBuilder().append(Id, rhs.Id).append(V, rhs.V).append(bookingId, rhs.bookingId).append(country, rhs.country).append(created, rhs.created).append(geoId, rhs.geoId).append(googleId, rhs.googleId).append(iata, rhs.iata).append(location, rhs.location).append(mapUrl, rhs.mapUrl).append(rating, rhs.rating).append(type, rhs.type).append(updated, rhs.updated).append(Searchable, rhs.Searchable).append(countryName, rhs.countryName).append(morpher, rhs.morpher).append(name, rhs.name).append(areaName, rhs.areaName).append(locale, rhs.locale).isEquals();
    }

}
