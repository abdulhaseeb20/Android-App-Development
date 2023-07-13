package com.example.smd_classwork.RecyclerViewExample;

public class Mobile
{
    private String Name, Company, Price;

    public Mobile(String name, String company, String price)
    {
        Name = name;
        Company = company;
        Price = price;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getCompany()
    {
        return Company;
    }

    public void setCompany(String company)
    {
        Company = company;
    }

    public String getPrice()
    {
        return Price;
    }

    public void setPrice(String price)
    {
        Price = price;
    }
}
