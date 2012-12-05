package com.cognitivenode.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

/**
 * Bean to hold payment info
 *
 * @author nataraj.basappa
 * @version 1.0, 29/11/2012
 */
@XStreamAlias("payment")
public class PaymentBean implements Serializable {

    @XStreamAsAttribute
    String paymentType;
    @XStreamAsAttribute
    String cardChargeAmount;
    @XStreamAsAttribute
    String cardCvvAvv;
    @XStreamAsAttribute
    String cardType;
    @XStreamAsAttribute
    String addressLine1;
    @XStreamAsAttribute
    String addressLine2;
    @XStreamAsAttribute
    String addressLine3;
    @XStreamAsAttribute
    String countryCode;
    @XStreamAsAttribute
    String postcode;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardChargeAmount() {
        return cardChargeAmount;
    }

    public void setCardChargeAmount(String cardChargeAmount) {
        this.cardChargeAmount = cardChargeAmount;
    }

    public String getCardCvvAvv() {
        return cardCvvAvv;
    }

    public void setCardCvvAvv(String cardCvvAvv) {
        this.cardCvvAvv = cardCvvAvv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
