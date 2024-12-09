package org.example;

public class Division {
    private static int lastId=0;
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Division(String name){
        this.name=name;
        this.id=++lastId;
    }
    public Division(){
        name=null;
        id=++lastId;
    }
}
