
package com.iknow.places.domain.content;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Morpher {

    @Expose
    private String nominative;
    @Expose
    private String genitive;
    @Expose
    private String dative;
    @Expose
    private String accusative;
    @Expose
    private String ablative;
    @Expose
    private String prepositional;

    /**
     * 
     * @return
     *     The nominative
     */
    public String getNominative() {
        return nominative;
    }

    /**
     * 
     * @param nominative
     *     The nominative
     */
    public void setNominative(String nominative) {
        this.nominative = nominative;
    }

    /**
     * 
     * @return
     *     The genitive
     */
    public String getGenitive() {
        return genitive;
    }

    /**
     * 
     * @param genitive
     *     The genitive
     */
    public void setGenitive(String genitive) {
        this.genitive = genitive;
    }

    /**
     * 
     * @return
     *     The dative
     */
    public String getDative() {
        return dative;
    }

    /**
     * 
     * @param dative
     *     The dative
     */
    public void setDative(String dative) {
        this.dative = dative;
    }

    /**
     * 
     * @return
     *     The accusative
     */
    public String getAccusative() {
        return accusative;
    }

    /**
     * 
     * @param accusative
     *     The accusative
     */
    public void setAccusative(String accusative) {
        this.accusative = accusative;
    }

    /**
     * 
     * @return
     *     The ablative
     */
    public String getAblative() {
        return ablative;
    }

    /**
     * 
     * @param ablative
     *     The ablative
     */
    public void setAblative(String ablative) {
        this.ablative = ablative;
    }

    /**
     * 
     * @return
     *     The prepositional
     */
    public String getPrepositional() {
        return prepositional;
    }

    /**
     * 
     * @param prepositional
     *     The prepositional
     */
    public void setPrepositional(String prepositional) {
        this.prepositional = prepositional;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nominative).append(genitive).append(dative).append(accusative).append(ablative).append(prepositional).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Morpher) == false) {
            return false;
        }
        Morpher rhs = ((Morpher) other);
        return new EqualsBuilder().append(nominative, rhs.nominative).append(genitive, rhs.genitive).append(dative, rhs.dative).append(accusative, rhs.accusative).append(ablative, rhs.ablative).append(prepositional, rhs.prepositional).isEquals();
    }

}
