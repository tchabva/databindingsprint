package com.northcoders.databindingdemo.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.databindingdemo.BR;

public class Person extends BaseObservable {
    private String name;
    private int age;
    private String emailAddress;

    public Person(String name, int age, String emailAddress) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public Person() {
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getAge() {
        return String.valueOf(age);
    }

    public void setAge(int age) {
        if (this.age != age) {
            this.age = age;
            notifyPropertyChanged(BR.ageString);
        }
    }

    @Bindable
    public String getAgeString() {
        return String.valueOf(age);
    }

    public void setAgeString(String ageString) {
        try {
            int num = Integer.parseInt(ageString);
            this.setAge(num);
        } catch (NumberFormatException e) {
            this.setAge(0);
        }
    }

    @Bindable
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        notifyPropertyChanged(BR.emailAddress);
    }
}
