package com.library;

public class Librarian {
    Library lib = new Library();
    
    public void setlib(Library library){
        this.lib=library;
    }

    public void add_member(String name, long Phone,int Age){
        Member mem = new Member(name,Phone,Age);
        mem.setlib(lib);
        mem.setID(lib.memberid_count);
        lib.members.add(mem);
        lib.member_count++;
        lib.memberid_count++;
        
    }
    public void add_book(String name, String author,int quantity){
        for(int i=0;i<quantity;i++){
            Book book = new Book(quantity,name,author);
            book.setID(lib.bookid_count);
            lib.books.add(book);
            lib.book_count++;
            lib.bookid_count++;
        }
    }
    public void rm_member(int id){
        for(Member x: lib.members){
            if(x.getID()==id){
                lib.members.remove(x);
                lib.member_count--;
                break;
            }
        }
    }
    public void rm_book(int id){
        for(Book x: lib.books){
            if(x.getID()==id){
                lib.books.remove(x);
                lib.book_count--;
                break;
            }
        }
    }
}
