package library;

import java.util.*;


public class Member {
    String Name;
    long phone;
    int age;
    Member(String Name, long phone, int age){
        this.Name=Name;
        this.phone=phone;
        this.age=age;
    }
    Map<Book,Calendar> holding = new HashMap<>();
    Library lib;
    int id;
    public void setID(int id){
        this.id=id;
    }
    public int getID(){
        return this.id;
    }
    public void setlib(Library lib){
        this.lib=lib;
    }
    public void list_books(){
        if(lib.getBook_Count()==0){
            System.out.println("Nothing to display........");
        }
        else{
        String display="";
        for(int i=0;i<lib.book_count;i++){
            String n = "\nId - "+lib.books.get(i).getID()+"\n"+lib.books.get(i).toString();
            display = display + n+"\n";
        }
        System.out.println(display.substring(0,display.length()-1));
        }
    }

    public void list_m_books(){
        if(holding.size()==0){
            System.out.println("Nothing to display........");
        }
        else{
        String display="";
        for(Book n: holding.keySet()){
            String m = "\nId - "+n.getID()+"\n"+n.toString();;
            display = display + m +"\n";
        }
        System.out.println(display.substring(0,display.length()-1));
        }
    }

    public int pay_fine(){
        int normal_fine=0;
        Calendar today = Calendar.getInstance();
        for(Map.Entry<Book,Calendar> c: holding.entrySet()){
            long f = (today.getTimeInMillis()-c.getValue().getTimeInMillis());
            long days = f/(1000 * 60 * 60 * 24);
            if(f>0){
                normal_fine+=3*days;
            }
        }
        return normal_fine;
    }

    public int pay_fine(int id){
        int normal_fine=0;
        Calendar today = Calendar.getInstance();
        for(Map.Entry<Book,Calendar> c: holding.entrySet()){
            if(c.getKey().getID()==id){
                long f = (today.getTimeInMillis()-c.getValue().getTimeInMillis());
                long days = f/(1000);
                if(f>0){
                    normal_fine+=3*days;
                }
            }
        }
        return normal_fine;
    }

    public int issue(int id, String tit){
        int av=0;
        int i = lib.findbook(id);
        Calendar today = Calendar.getInstance();
        if(lib.books.get(i).isAvail()==false){
            String tit_of_book=lib.books.get(i).title.toLowerCase();
            if(tit_of_book.equals(tit.toLowerCase())==false){
                return 0;
            }
            today.add(Calendar.DAY_OF_YEAR, 10);
            this.lib.books.get(i).issueing();
            this.holding.put(lib.books.get(i),today);
            av=1;
        }
        return av;
    }
    public void return_b(int id){
        for(Book x: holding.keySet()){
            if(x.id==id){
                x.returning();
                this.holding.remove(x);
                break;
            }
        }    
    }

    @Override
    public String toString(){
        return "Name - "+this.Name+"\nPhone - "+this.phone;
    }
}
