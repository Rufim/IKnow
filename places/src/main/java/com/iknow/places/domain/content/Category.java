
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Category {

    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String created;
    @Expose
    private String updated;
    @Expose
    private Morpher morpher;
    @Expose
    private String name;
    @Expose
    private String locale;

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
        return new HashCodeBuilder().append(V).append(Id).append(created).append(updated).append(morpher).append(name).append(locale).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return new EqualsBuilder().append(V, rhs.V).append(Id, rhs.Id).append(created, rhs.created).append(updated, rhs.updated).append(morpher, rhs.morpher).append(name, rhs.name).append(locale, rhs.locale).isEquals();
    }

}
