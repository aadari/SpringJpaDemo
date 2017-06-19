package com.example.springjpademo.beans;

/**
 * Created by Adi Adari on 12/27/2016.
 */
public class Hello
{
    private String name;
    public Hello(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return "Hello " + name;
    }
}