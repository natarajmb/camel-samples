package com.cognitivenode.service;

import com.cognitivenode.framework.annotation.HttpDelete;
import com.cognitivenode.framework.annotation.HttpGet;
import com.cognitivenode.framework.annotation.HttpPost;
import com.cognitivenode.framework.annotation.HttpPut;
import com.cognitivenode.model.ContactBean;

/**
 * Interface for the contact service
 *
 * @author nataraj.basappa
 * @version 1.0, 10/12/2012
 */
public interface IContactService {

    @HttpGet(url = "/contact/")
    public ContactBean getContact(String email);

    @HttpPost(url = "/contact/")
    public ContactBean updateContact(ContactBean contactBean);

    @HttpPut(url = "/contact/")
    public ContactBean addContact(ContactBean contactBean);

    @HttpDelete(url = "/contact/")
    public boolean deleteContact(String email);

}
