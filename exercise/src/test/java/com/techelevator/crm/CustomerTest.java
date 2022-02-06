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

        Assert.assertEquals("The test should return added values",6.0, testCustomer.getBalanceDue(map),0.1);

        //pass null value
        Assert.assertEquals("If parameter is null, return 0", 0, testCustomer.getBalanceDue(null),0.1);

        //map with null value
        map.put(null,null);
        Assert.assertEquals("If element is null, add other values and return", 6.0, testCustomer.getBalanceDue(map),0.1);

        map.put("",4.);
        Assert.assertEquals("If key is empty, don't add value", 6.0, testCustomer.getBalanceDue(map),0.1);

        map.put("Stuff",null);
        Assert.assertEquals("If value is null don't break program", 6.0, testCustomer.getBalanceDue(map),0.1);

        map.put(null,4.0);
        Assert.assertEquals("If key is null, don't add value", 6.0, testCustomer.getBalanceDue(map),0.1);



        /*
        Map<String, Double> test = new HashMap<>();
        test.put(null,null);
         */

    }
}
