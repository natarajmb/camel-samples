package com.cognitivenode.model;

/**
 * Contact bean to hold the the contact details
 *
 * @author nataraj.basappa
 * @version 1.0, 10/12/2012
 */
public class ContactBean {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public ContactBean(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContactBean) {
            ContactBean bean = (ContactBean) obj;
            if (bean.getEmail().equalsIgnoreCase(this.email))
                return true;
        }
        return false;
    }
}
