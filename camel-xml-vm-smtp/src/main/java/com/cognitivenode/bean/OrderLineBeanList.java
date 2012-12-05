package com.cognitivenode.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper to hold the OrderLine bean, boiler plate code
 * to get XStream to un-marshall XML to beans.
 *
 * @author nataraj.basappa
 * @version 1.0, 30/11/2012
 */
@XStreamAlias("orderLines")
public class OrderLineBeanList implements Serializable {

    @XStreamImplicit
    List<OrderLineBean> orderLineBeans;

    public List<OrderLineBean> getOrderLineBeans() {
        return orderLineBeans;
    }

    public void add(OrderLineBean orderLineBean) {
        if (orderLineBeans == null)
            orderLineBeans = new ArrayList<OrderLineBean>();
        orderLineBeans.add(orderLineBean);
    }
}
