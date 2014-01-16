package com.cognitivenode.service;

import com.cognitivenode.model.ContactBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Service that implements contact service
 *
 * @author nataraj.basappa
 * @version 1.0, 10/12/2012
 */
public class ContactServiceImpl implements IContactService {

    private List<ContactBean> contactBeans = null;

    public ContactServiceImpl() {
        contactBeans = new ArrayList<ContactBean>();
        contactBeans.add(new ContactBean("Nataraj", "Basappa", "natarajmb@gmail.com", "07875359990"));
        contactBeans.add(new ContactBean("Poornima", "Kemparaju", "poornima.pk@gmail.com", "07875224696"));
    }

    @Override
    public ContactBean getContact(String email) {
        for (ContactBean bean : contactBeans) {
            if (bean.getEmail().equalsIgnoreCase(email))
                return bean;
        }
        return null;
    }

    @Override
    public ContactBean updateContact(ContactBean contactBean) {
        for (ContactBean bean : contactBeans) {
            if (bean.getEmail().equalsIgnoreCase(contactBean.getEmail())) {
                bean.setEmail(contactBean.getEmail());
                bean.setFirstName(contactBean.getFirstName());
                bean.setLastName(contactBean.getLastName());
                bean.setPhone(contactBean.getPhone());
                return bean;
            }
        }
        return null;
    }

    @Override
    public ContactBean addContact(ContactBean contactBean) {
        for (ContactBean bean : contactBeans) {
            if (bean.getEmail().equalsIgnoreCase(contactBean.getEmail()))
                return bean;
        }
        contactBeans.add(contactBean);
        return contactBean;
    }

    @Override
    public boolean deleteContact(String email) {
        for (ContactBean bean : contactBeans) {
            if (bean.getEmail().equalsIgnoreCase(email)) {
                return contactBeans.remove(contactBeans);
            }
        }
        return false;
    }
}
