package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetTests {
    @Test
    public void test_list_vaccinations(){
        Pet pet = new Pet("Rito", "Dog");
        List<String> testList = new ArrayList<>(Arrays.asList("Rabies", "Flu", "Polio"));

        Assert.assertEquals("empty list should return empty string", "",pet.listVaccinations());
        pet.setVaccinations(testList);

        Assert.assertEquals("expecting String of vaccinations","Rabies, Flu, Polio",pet.listVaccinations());
        //test empty list return empty string


        //test happy path


    }
}
