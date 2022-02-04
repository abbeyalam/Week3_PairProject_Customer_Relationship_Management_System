package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerTest {

    @Test
    public void test_get_balance_due () {
        Customer testCustomer = new Customer("Tom", "Smith");

        Map<String,Double> map = new HashMap<>();
        map.put("Grooming",1.0);
        map.put("Walking",2.0);
        map.put("Sitting",3.0);

        Assert.assertEquals(6.0, testCustomer.getBalanceDue(map),0.1);

    }
}
