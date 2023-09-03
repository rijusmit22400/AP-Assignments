package com.library;

public class Book {
    int quantity;
    String title;
    String author;
    Book(int q, String t,String a){
        this.quantity=q;
        this.title=t;
        this.author=a;
    }
    boolean issue;
    int id;

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id=id;
    }
    public boolean isAvail(){
        return issue;
    }

    public void issueing(){
        this.issue=true;
    }

    public void returning(){
        this.issue=false;
    }

    @Override
    public String toString(){
        return "Name - "+this.title+"\n"+"Author - "+this.author;
    }
}
