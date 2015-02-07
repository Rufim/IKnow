
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Audit {

    @Expose
    private Moderation moderation;

    /**
     * 
     * @return
     *     The moderation
     */
    public Moderation getModeration() {
        return moderation;
    }

    /**
     * 
     * @param moderation
     *     The moderation
     */
    public void setModeration(Moderation moderation) {
        this.moderation = moderation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(moderation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Audit) == false) {
            return false;
        }
        Audit rhs = ((Audit) other);
        return new EqualsBuilder().append(moderation, rhs.moderation).isEquals();
    }

}
