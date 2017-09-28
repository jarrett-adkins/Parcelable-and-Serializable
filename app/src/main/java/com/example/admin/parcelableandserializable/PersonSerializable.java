package com.example.admin.parcelableandserializable;

import java.io.Serializable;

/**
 * Created by Admin on 9/28/2017.
 */

public class PersonSerializable implements Serializable{

    String name, age, gender, address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public PersonSerializable(String name, String age, String gender, String address) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
}
