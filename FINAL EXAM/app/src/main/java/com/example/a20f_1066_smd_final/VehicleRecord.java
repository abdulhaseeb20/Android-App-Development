package com.example.a20f_1066_smd_final;

public class VehicleRecord {
String name, cnic, model, cc, color, city;

    public VehicleRecord(String name, String cnic, String model, String cc, String color, String city) {
        this.name = name;
        this.cnic = cnic;
        this.model = model;
        this.cc = cc;
        this.color = color;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
