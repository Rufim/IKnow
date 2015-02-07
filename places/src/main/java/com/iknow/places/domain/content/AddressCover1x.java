
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class AddressCover1x {

    @Expose
    private Object copyrights;
    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String filename;

    /**
     * 
     * @return
     *     The copyrights
     */
    public Object getCopyrights() {
        return copyrights;
    }

    /**
     * 
     * @param copyrights
     *     The copyrights
     */
    public void setCopyrights(Object copyrights) {
        this.copyrights = copyrights;
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
     *     The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 
     * @param filename
     *     The filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(copyrights).append(Id).append(filename).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressCover1x) == false) {
            return false;
        }
        AddressCover1x rhs = ((AddressCover1x) other);
        return new EqualsBuilder().append(copyrights, rhs.copyrights).append(Id, rhs.Id).append(filename, rhs.filename).isEquals();
    }

}
