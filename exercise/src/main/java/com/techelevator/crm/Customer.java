package com.techelevator.crm;

import com.techelevator.Billable;
import com.techelevator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person implements Billable {

    private String phoneNumber;
    private List<String> pets = new ArrayList<>();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }


    public Customer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }
    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public double getBalanceDue(Map<String, Double> servicesRendered) {

        if(servicesRendered==null) {return 0;}

        double sum = 0;
        for (Map.Entry<String, Double> price: servicesRendered.entrySet()){
            if(price.getValue()==null) {continue;}
            if(price.getKey()==null) {continue;}
            if(price.getKey().equals("")) {continue;}
            sum += price.getValue();

        }

        return sum;
    }
}
