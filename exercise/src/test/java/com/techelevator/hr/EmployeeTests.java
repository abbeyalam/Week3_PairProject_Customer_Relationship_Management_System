package com.techelevator.hr;

import com.techelevator.crm.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests {

    @Test
    public void getFullNameReturnsCorrectFormat() {
        Employee employee = new Employee("Test", "Testerson");
        String fullName = employee.getFullName();

        assertEquals("The employee full name is not in the correct format.", "Testerson, Test", fullName);
    }

    @Test
    public void raiseSalaryTest_Positive() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(5);

        assertEquals("The employee raise of 5% was not computed correctly.",employee.getSalary(), 100 * 1.05, 0.0);
    }

    @Test
    public void raiseSalaryTest_Negative() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(-10); //"raise" by negative 10%

        assertEquals("Salary should remain the same when raise percentage is negative.",100, employee.getSalary(),0.0);
    }

    @Test
    public void test_get_balance_due () {
        Employee testEmployee = new Employee("Tom", "Smith");

        Map<String,Double> map = new HashMap<>();
        map.put("Grooming",1.0);
        map.put("Walking",2.0);
        map.put("Sitting",3.0);

        Assert.assertEquals("The test should return added values",5.0, testEmployee.getBalanceDue(map),0.1);

        //pass null value
        Assert.assertEquals("If parameter is null, return 0", 0, testEmployee.getBalanceDue(null),0.1);

        //map with null value
        map.put(null,null);
        Assert.assertEquals("If element is null, add other values and return", 5.0, testEmployee.getBalanceDue(map),0.1);

        map.put("",4.);
        Assert.assertEquals("If key is empty, don't add value", 5.0, testEmployee.getBalanceDue(map),0.1);

        map.put("Stuff",null);
        Assert.assertEquals("If value is null don't break program", 5.0, testEmployee.getBalanceDue(map),0.1);

        map.put(null,4.0);
        Assert.assertEquals("If key is null, don't add value", 5.0, testEmployee.getBalanceDue(map),0.1);
    }

}
