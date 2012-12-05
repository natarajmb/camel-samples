package com.cognitivenode.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ISO8601GregorianCalendarConverter;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Bean class to hold the unmarshalled XML data
 *
 * @author nataraj.basappa
 * @version 1.0, 29/11/2012
 */
@XStreamAlias("order")
public class OrderBean implements Serializable {

    @XStreamAsAttribute
    String contactId;
    @XStreamAsAttribute
    String contactName;
    @XStreamAsAttribute
    String deliveryType;
    @XStreamAsAttribute
    String hybrisAccountNumber;
    @XStreamAsAttribute
    String hybrisOrderNumber;
    @XStreamAsAttribute
    double orderValueExVat;
    @XStreamAsAttribute
    double orderValueIncVat;
    @XStreamAsAttribute
    String salesOfficeCode;
    @XStreamAsAttribute
    String uniqueSerialNumber;
    @XStreamAsAttribute
    String numberNIFNIECIF;
    @XStreamConverter(ISO8601GregorianCalendarConverter.class)
    @XStreamAsAttribute
    Calendar orderDate;
    @XStreamAsAttribute
    double deliveryCost;
    @XStreamAlias("address")
    AddressBean addressBean;
    @XStreamAlias("payment")
    PaymentBean paymentBean;
    @XStreamAlias("orderLines")
    OrderLineBeanList orderLineBeanList;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getHybrisAccountNumber() {
        return hybrisAccountNumber;
    }

    public void setHybrisAccountNumber(String hybrisAccountNumber) {
        this.hybrisAccountNumber = hybrisAccountNumber;
    }

    public String getHybrisOrderNumber() {
        return hybrisOrderNumber;
    }

    public void setHybrisOrderNumber(String hybrisOrderNumber) {
        this.hybrisOrderNumber = hybrisOrderNumber;
    }

    public double getOrderValueExVat() {
        return orderValueExVat;
    }

    public void setOrderValueExVat(double orderValueExVat) {
        this.orderValueExVat = orderValueExVat;
    }

    public double getOrderValueIncVat() {
        return orderValueIncVat;
    }

    public void setOrderValueIncVat(double orderValueIncVat) {
        this.orderValueIncVat = orderValueIncVat;
    }

    public String getSalesOfficeCode() {
        return salesOfficeCode;
    }

    public void setSalesOfficeCode(String salesOfficeCode) {
        this.salesOfficeCode = salesOfficeCode;
    }

    public String getUniqueSerialNumber() {
        return uniqueSerialNumber;
    }

    public void setUniqueSerialNumber(String uniqueSerialNumber) {
        this.uniqueSerialNumber = uniqueSerialNumber;
    }

    public String getNumberNIFNIECIF() {
        return numberNIFNIECIF;
    }

    public void setNumberNIFNIECIF(String numberNIFNIECIF) {
        this.numberNIFNIECIF = numberNIFNIECIF;
    }

    public Date getOrderDate() {
        return orderDate.getTime();
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public AddressBean getAddressBean() {
        return addressBean;
    }

    public void setAddressBean(AddressBean addressBean) {
        this.addressBean = addressBean;
    }

    public PaymentBean getPaymentBean() {
        return paymentBean;
    }

    public void setPaymentBean(PaymentBean paymentBean) {
        this.paymentBean = paymentBean;
    }

    public OrderLineBeanList getOrderLineBeanList() {
        return orderLineBeanList;
    }

    public void setOrderLineBeanList(OrderLineBeanList orderLineBeanList) {
        this.orderLineBeanList = orderLineBeanList;
    }

    public double getTotalVat() {
        return orderValueIncVat - orderValueExVat;
    }
}
