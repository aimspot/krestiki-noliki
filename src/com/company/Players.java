package com.company;

public class Players {

    String name;

    public Players(String name){
        this.name = name;
        Greeting();
    }

    void Greeting(){
        System.out.print("Hello " + name);
    }

}
