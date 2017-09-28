package com.example.admin.parcelableandserializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 9/28/2017.
 */

public class PersonParcelable implements Parcelable {

    String name, age, gender, address;

    public PersonParcelable(String name, String age, String gender, String address) {

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    protected PersonParcelable(Parcel in) {
        name = in.readString();
        age = in.readString();
        gender = in.readString();
        address = in.readString();
    }

    public static final Creator<PersonParcelable> CREATOR = new Creator<PersonParcelable>() {
        @Override
        public PersonParcelable createFromParcel(Parcel in) {
            return new PersonParcelable(in);
        }

        @Override
        public PersonParcelable[] newArray(int size) {
            return new PersonParcelable[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(gender);
        parcel.writeString(address);
    }
}
