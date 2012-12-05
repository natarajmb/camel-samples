package com.cognitivenode.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

/**
 * Bean to hold unmarshalled order line data
 *
 * @author nataraj.basappa
 * @version 1.0, 29/11/2012
 */
@XStreamAlias("orderLine")
public class OrderLineBean implements Serializable {

    @XStreamAsAttribute
    String SKU;
    @XStreamAsAttribute
    String productName;
    @XStreamAsAttribute
    String apportionedPrice;
    @XStreamAsAttribute
    String lineNumber;
    @XStreamAsAttribute
    double orderLineValueExVat;
    @XStreamAsAttribute
    double orderLineVatValue;
    @XStreamAsAttribute
    String priceListCode;
    @XStreamAsAttribute
    int quantity;
    @XStreamAsAttribute
    String unit;

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getApportionedPrice() {
        return apportionedPrice;
    }

    public void setApportionedPrice(String apportionedPrice) {
        this.apportionedPrice = apportionedPrice;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public double getOrderLineValueExVat() {
        return orderLineValueExVat;
    }

    public void setOrderLineValueExVat(double orderLineValueExVat) {
        this.orderLineValueExVat = orderLineValueExVat;
    }

    public double getOrderLineVatValue() {
        return orderLineVatValue;
    }

    public void setOrderLineVatValue(double orderLineVatValue) {
        this.orderLineVatValue = orderLineVatValue;
    }

    public String getPriceListCode() {
        return priceListCode;
    }

    public void setPriceListCode(String priceListCode) {
        this.priceListCode = priceListCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
