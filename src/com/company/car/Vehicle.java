package com.company.car;

public abstract class Vehicle {

    protected String registrationNumber;
    protected String color;


    public abstract String getRegistrationNumber();

    public abstract void setRegistrationNumber(String registrationNumber);

    public abstract String getColor();

    public abstract void setColor(String color);

}
