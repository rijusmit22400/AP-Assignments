package com.library;

import java.util.*;

public class Library {
    Vector<Book> books = new Vector<Book>();
    Vector<Member> members = new Vector<Member>();
    int book_count=0;
    int member_count=0;
    int bookid_count=1;
    int memberid_count=1;
    public int getBook_Count(){
        return book_count;
    }

    public int getMember_Count(){
        return member_count;
    }

    public boolean auth(String Name, long Phone){
        boolean found=false;
        for(Member x: members){
            if(x.Name.toLowerCase().equals(Name.toLowerCase())&& x.phone==Phone){
                found=true;
                break;
            }
        }
        return found;
    }

    public int findmem(String Name, long Phone){
        int i=-1;
       for(Member x: members){
            if(x.Name.toLowerCase().equals(Name.toLowerCase())&& x.phone==Phone){
                i=members.indexOf(x);
                break;
            }
        }
        return i;
    }

    public int findbook(String Name, int id){
        int i=-1;
       for(Book x: books){
            if(x.title.toLowerCase().equals(Name.toLowerCase())&& x.id==id){
                i=books.indexOf(x);
                break;
            }
        }
        return i;
    }
    public int findbook(int id){
        int i=-1;
       for(Book x: books){
            if(x.id==id){
                i=books.indexOf(x);
                break;
            }
        }
        return i;
    }
}
