package com.cognitivenode.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

/**
 * Bean to hold unmarshalled address data
 *
 * @author nataraj.basappa
 * @version 1.0, 29/11/2012
 */
@XStreamAlias("address")
public class AddressBean implements Serializable {

    @XStreamAsAttribute
    String addressLine1;
    @XStreamAsAttribute
    String addressLine2;
    @XStreamAsAttribute
    String addressLine3;
    @XStreamAsAttribute
    String countryCode;
    @XStreamAsAttribute
    String name;
    @XStreamAsAttribute
    String postcode;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
