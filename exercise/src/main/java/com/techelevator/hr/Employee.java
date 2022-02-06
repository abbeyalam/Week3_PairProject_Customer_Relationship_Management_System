package com.techelevator.hr;

import com.techelevator.Billable;
import com.techelevator.Person;

import java.util.Map;

public class Employee extends Person implements Billable {

    private int employeeId;
    private String title;
    private Department department;
    private double salary;

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, "", 0);
    }

    public Employee(String firstName, String lastName, String title, double salary) {
        super(firstName, lastName);
        this.title = title;
        this.salary = salary;
    }

    @Override
    public String getFullName() {
        return this.getLastName() + ", " + this.getFirstName();
    }

    public void raiseSalary(double percentage) {
        if (percentage > 0) {
            this.salary += salary * percentage / 100;
        }
    }


    // getters and setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getBalanceDue(Map<String, Double> servicesRendered) {

        if(servicesRendered==null) {return 0;}

        double sum = 0;
        for (Map.Entry<String, Double> price : servicesRendered.entrySet()) {
            if(price.getValue()==null) {continue;}
            if(price.getKey()==null) {continue;}
            if(price.getKey().equals("")) {continue;}
            if (price.getKey().equalsIgnoreCase("Walking")){
                sum += price.getValue() / 2;
            } else {
                sum += price.getValue();
            }

        }
        return sum;
    }
}
