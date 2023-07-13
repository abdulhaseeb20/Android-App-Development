package com.example.smd_classwork.CardViewExample;

public class My_Model
{
    private String Name;
    private int count, thumbnails;

    public My_Model(String name, int count, int thumbnails)
    {
        Name = name;
        this.count = count;
        this.thumbnails = thumbnails;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(int thumbnails) {
        this.thumbnails = thumbnails;
    }
}
