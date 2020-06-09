package com.kolliadit.recyclerview;

public class MyUser {

    public int pos;
    public String name;
    public int vote;
    public MyUser(int a, String n) {
        this.pos = a;
        this.name = n;
        this.vote=0;
    }
    public void vote(){
        this.vote++;
    }
    public int getVote(){
        return this.vote;
    }
}