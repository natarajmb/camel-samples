package com.cognitivenode;

import com.cognitivenode.customer.ICustomerService;
import com.cognitivenode.customer.types.*;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Customer Service class, generates a random customer data and pushes it across
 * to the requesting clients.
 *
 * @author nataraj.basappa
 * @version 1.0, 11/09/2012
 */
public class CXFCustomerServiceImpl implements ICustomerService {

    List<CustomerRecord> customerRecords = null;

    public CXFCustomerServiceImpl() {
        customerRecords = new ArrayList<CustomerRecord>();
        init(customerRecords);
    }

    private void init(List<CustomerRecord> customerRecords) {

        for (int index = 0; index < 5; index++) {
            CustomerRecord record = new CustomerRecord();
            record.setFirstName("Customer" + index);
            record.setLastName("Surname" + index);
            Calendar dateOfBirth = Calendar.getInstance();
            dateOfBirth.set(1980 + index, 7 + index, 15 + index);
            record.setDOB(dateOfBirth);
            record.setGender(5 % (index + 1) == 0 ? "M" : "F");
            record.setUsername("customers" + index);
            record.setPassword("password" + index);
            record.setPhone("7875359990" + index);

            Address billingAddress = new Address();
            billingAddress.setAddressLine1(index + " Betahouse Southcote Road");
            billingAddress.setAddressLine2("Reading");
            billingAddress.setPostCode("RG30 2AR");
            record.setBillingAddress(billingAddress);

            CreditCard creditCard = new CreditCard();
            creditCard.setCardHolderName(record.getFirstName() + " " + record.getLastName());
            creditCard.setCardNumber("4534 2345 9867 7633");
            creditCard.setCVC("23" + index);
            Calendar expiryDate = Calendar.getInstance();
            expiryDate.set(1, 3 + index, 2014 + index);
            creditCard.setExpiryDate(expiryDate);
            record.setCreditCard(creditCard);
            record.setCreditCard(creditCard);
            customerRecords.add(record);
        }
    }

    @Override
    public CustomersResponseType getCustomers(@WebParam(partName = "parameters", name = "EmptyType", targetNamespace = "http://www.cognitivenode.com/customer/types") String IGNORE_ME) {
        ArrayOfCustomerRecord aocr = new ArrayOfCustomerRecord();
        aocr.getCustomer().addAll(customerRecords);
        CustomersResponseType responseType = new CustomersResponseType();
        responseType.setCustomers(aocr);
        return responseType;
    }

    @Override
    public CustomerResponseType getCustomer(@WebParam(partName = "parameters", name = "CustomerRequestType", targetNamespace = "http://www.cognitivenode.com/customer/types") CustomerRequestType parameters) {
        if (parameters != null) {
            Identifier identifier = parameters.getCustomerId();
            for (CustomerRecord record : customerRecords) {
                if (record.getUsername().equals(identifier.getUsername())) {
                    CustomerResponseType responseType = new CustomerResponseType();
                    responseType.setCustomer(record);
                    return responseType;
                }
            }
        }
        return null;
    }

    @Override
    public CustomerResponseType getCustomerByLastName(@WebParam(partName = "parameters", name = "GetCustomerByLastNameType", targetNamespace = "http://www.cognitivenode.com/customer/types") GetCustomerByLastNameType parameters) {
        if (parameters != null) {
            String lastName = parameters.getLastName();
            for (CustomerRecord record : customerRecords) {
                if (record.getLastName().equals(lastName)) {
                    CustomerResponseType responseType = new CustomerResponseType();
                    responseType.setCustomer(record);
                    return responseType;
                }
            }
        }
        return null;
    }
}
