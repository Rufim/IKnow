
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;


public class Content {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String type;
    @Expose
    private Creator creator;
    @SerializedName("address_location")
    @Expose
    private AddressLocation addressLocation;
    @SerializedName("address_address")
    @Expose
    private String addressAddress;
    @SerializedName("address_google_place_id")
    @Expose
    private Object addressGooglePlaceId;
    @SerializedName("address_phone")
    @Expose
    private String addressPhone;
    @Expose
    private String url;
    @SerializedName("address_hours")
    @Expose
    private String addressHours;
    @Expose
    private String copyrights;
    @Expose
    private String updated;
    @Expose
    private String created;
    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("address_station")
    @Expose
    private AddressStation addressStation;
    @Expose
    private String state;
    @Expose
    private String title;
    @Expose
    private String body;
    @Expose
    private List<String> warnings = new ArrayList<String>();
    @Expose
    private Double rating;
    @Expose
    private Audit audit;
    @Expose
    private Integer views;
    @Expose
    private Integer articles;
    @Expose
    private String published;
    @Expose
    private String locale;
    @Expose
    private List<City> cities = new ArrayList<City>();
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @Expose
    private City city;
    @SerializedName("address_photos")
    @Expose
    private List<AddressPhoto> addressPhotos = new ArrayList<AddressPhoto>();
    @SerializedName("address_cover_1x")
    @Expose
    private AddressCover1x addressCover1x;
    @SerializedName("address_cover_4x")
    @Expose
    private AddressCover4x addressCover4x;

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
     *     The creator
     */
    public Creator getCreator() {
        return creator;
    }

    /**
     * 
     * @param creator
     *     The creator
     */
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    /**
     * 
     * @return
     *     The addressLocation
     */
    public AddressLocation getAddressLocation() {
        return addressLocation;
    }

    /**
     * 
     * @param addressLocation
     *     The address_location
     */
    public void setAddressLocation(AddressLocation addressLocation) {
        this.addressLocation = addressLocation;
    }

    /**
     * 
     * @return
     *     The addressAddress
     */
    public String getAddressAddress() {
        return addressAddress;
    }

    /**
     * 
     * @param addressAddress
     *     The address_address
     */
    public void setAddressAddress(String addressAddress) {
        this.addressAddress = addressAddress;
    }

    /**
     * 
     * @return
     *     The addressGooglePlaceId
     */
    public Object getAddressGooglePlaceId() {
        return addressGooglePlaceId;
    }

    /**
     * 
     * @param addressGooglePlaceId
     *     The address_google_place_id
     */
    public void setAddressGooglePlaceId(Object addressGooglePlaceId) {
        this.addressGooglePlaceId = addressGooglePlaceId;
    }

    /**
     * 
     * @return
     *     The addressPhone
     */
    public String getAddressPhone() {
        return addressPhone;
    }

    /**
     * 
     * @param addressPhone
     *     The address_phone
     */
    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The addressHours
     */
    public String getAddressHours() {
        return addressHours;
    }

    /**
     * 
     * @param addressHours
     *     The address_hours
     */
    public void setAddressHours(String addressHours) {
        this.addressHours = addressHours;
    }

    /**
     * 
     * @return
     *     The copyrights
     */
    public String getCopyrights() {
        return copyrights;
    }

    /**
     * 
     * @param copyrights
     *     The copyrights
     */
    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
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
     *     The addressStation
     */
    public AddressStation getAddressStation() {
        return addressStation;
    }

    /**
     * 
     * @param addressStation
     *     The address_station
     */
    public void setAddressStation(AddressStation addressStation) {
        this.addressStation = addressStation;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The body
     */
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 
     * @return
     *     The warnings
     */
    public List<String> getWarnings() {
        return warnings;
    }

    /**
     * 
     * @param warnings
     *     The warnings
     */
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
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
     *     The audit
     */
    public Audit getAudit() {
        return audit;
    }

    /**
     * 
     * @param audit
     *     The audit
     */
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    /**
     * 
     * @return
     *     The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 
     * @param views
     *     The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 
     * @return
     *     The articles
     */
    public Integer getArticles() {
        return articles;
    }

    /**
     * 
     * @param articles
     *     The articles
     */
    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    /**
     * 
     * @return
     *     The published
     */
    public String getPublished() {
        return published;
    }

    /**
     * 
     * @param published
     *     The published
     */
    public void setPublished(String published) {
        this.published = published;
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

    /**
     * 
     * @return
     *     The cities
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * 
     * @param cities
     *     The cities
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    /**
     * 
     * @return
     *     The bodyHtml
     */
    public String getBodyHtml() {
        return bodyHtml;
    }

    /**
     * 
     * @param bodyHtml
     *     The body_html
     */
    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The city
     */
    public City getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The addressPhotos
     */
    public List<AddressPhoto> getAddressPhotos() {
        return addressPhotos;
    }

    /**
     * 
     * @param addressPhotos
     *     The address_photos
     */
    public void setAddressPhotos(List<AddressPhoto> addressPhotos) {
        this.addressPhotos = addressPhotos;
    }

    /**
     * 
     * @return
     *     The addressCover1x
     */
    public AddressCover1x getAddressCover1x() {
        return addressCover1x;
    }

    /**
     * 
     * @param addressCover1x
     *     The address_cover_1x
     */
    public void setAddressCover1x(AddressCover1x addressCover1x) {
        this.addressCover1x = addressCover1x;
    }

    /**
     * 
     * @return
     *     The addressCover4x
     */
    public AddressCover4x getAddressCover4x() {
        return addressCover4x;
    }

    /**
     * 
     * @param addressCover4x
     *     The address_cover_4x
     */
    public void setAddressCover4x(AddressCover4x addressCover4x) {
        this.addressCover4x = addressCover4x;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Id).append(type).append(creator).append(addressLocation).append(addressAddress).append(addressGooglePlaceId).append(addressPhone).append(url).append(addressHours).append(copyrights).append(updated).append(created).append(V).append(addressStation).append(state).append(title).append(body).append(warnings).append(rating).append(audit).append(views).append(articles).append(published).append(locale).append(cities).append(bodyHtml).append(categories).append(tags).append(city).append(addressPhotos).append(addressCover1x).append(addressCover4x).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Content) == false) {
            return false;
        }
        Content rhs = ((Content) other);
        return new EqualsBuilder().append(Id, rhs.Id).append(type, rhs.type).append(creator, rhs.creator).append(addressLocation, rhs.addressLocation).append(addressAddress, rhs.addressAddress).append(addressGooglePlaceId, rhs.addressGooglePlaceId).append(addressPhone, rhs.addressPhone).append(url, rhs.url).append(addressHours, rhs.addressHours).append(copyrights, rhs.copyrights).append(updated, rhs.updated).append(created, rhs.created).append(V, rhs.V).append(addressStation, rhs.addressStation).append(state, rhs.state).append(title, rhs.title).append(body, rhs.body).append(warnings, rhs.warnings).append(rating, rhs.rating).append(audit, rhs.audit).append(views, rhs.views).append(articles, rhs.articles).append(published, rhs.published).append(locale, rhs.locale).append(cities, rhs.cities).append(bodyHtml, rhs.bodyHtml).append(categories, rhs.categories).append(tags, rhs.tags).append(city, rhs.city).append(addressPhotos, rhs.addressPhotos).append(addressCover1x, rhs.addressCover1x).append(addressCover4x, rhs.addressCover4x).isEquals();
    }

}
