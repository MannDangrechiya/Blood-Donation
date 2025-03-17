package com.example.blooddonation;

public class Donor {
    private String name;
    private String bloodType;
    private String contact;

    public Donor(String name, String bloodType, String contact) {
        this.name = name;
        this.bloodType = bloodType;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getContact() {
        return contact;
    }
}