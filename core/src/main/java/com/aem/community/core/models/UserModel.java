package com.aem.community.core.models;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Anirudh Sharma
 *
 * User Component model class
 */
@Model(adaptables = Resource.class)
public class UserModel {

    @Inject
    private String firstName;

    @Inject
    private String lastName;

    @Inject
    private String gender;

    @Inject
    private String country;

    @Inject @Default(values="defaultValue")
    private String name;
// SLING CLASS METHOD WHICH RETURNS ARRAYLIST
    public ArrayList ret()
    {
        ArrayList l = new ArrayList();
        l.add("Array1");
        l.add("Array2");
        l.add("Array3");
        return l;
    }

    // SLING CLASS METHOD WHICH RETURNS MAP
    public HashMap mapRet()
    {
        HashMap h = new HashMap();
        h.put("key", "value1");
        h.put("key1", "value2");
        h.put("key2", "value3");
        return h;
    }


    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

}