package com.example.myfinanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// PersonalInfo.java
public class PersonalInfo {
    private String name;
    private String age;
    private String retAge;
    private String curSalary;
    private String avgIncrement;

    // Add other fields like age, retirement age, etc.
    public PersonalInfo(String name, String age, String retAge, String curSalary, String avgIncrement) {
        this.name = name;
        this.age = age;
        this.retAge = retAge;
        this.curSalary = curSalary;
        this.avgIncrement = avgIncrement;

        // Initialize other fields here
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRetAge() {
        return retAge;
    }

    public void setRetAge(String retAge) {
        this.retAge = retAge;
    }

    public String getCurSalary() {
        return curSalary;
    }

    public void setCurSalary(String curSalary) {
        this.curSalary = curSalary;
    }

    public String getAvgIncrement() {
        return avgIncrement;
    }

    public void setAvgIncrement(String avgIncrement) {
        this.avgIncrement = avgIncrement;
    }


    // Add getters and setters for other fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
