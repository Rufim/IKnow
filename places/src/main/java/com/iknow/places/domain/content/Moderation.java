
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Moderation {

    @Expose
    private First first;
    @Expose
    private Last last;

    /**
     * 
     * @return
     *     The first
     */
    public First getFirst() {
        return first;
    }

    /**
     * 
     * @param first
     *     The first
     */
    public void setFirst(First first) {
        this.first = first;
    }

    /**
     * 
     * @return
     *     The last
     */
    public Last getLast() {
        return last;
    }

    /**
     * 
     * @param last
     *     The last
     */
    public void setLast(Last last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(first).append(last).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Moderation) == false) {
            return false;
        }
        Moderation rhs = ((Moderation) other);
        return new EqualsBuilder().append(first, rhs.first).append(last, rhs.last).isEquals();
    }

}
