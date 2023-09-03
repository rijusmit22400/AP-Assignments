package com.library;

import java.util.*;

public class Run {
    public static void run(){
        Librarian sameer = new Librarian();
        Library lib = new Library();
        int arg;
        sameer.setlib(lib);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("---------------------------------");
            System.out.println("1. Enter as librarian");
            System.out.println("2. Enter as member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");         
            arg = sc.nextInt();
            if(arg==3){
                System.out.println("---------------------------------");
                System.out.println("Thanks For Visiting!");
                System.out.println("---------------------------------"); 
                break;
            }
            else if(arg==1){
                while(true){
                    System.out.println("---------------------------------");
                    System.out.println("1. Register a member");
                    System.out.println("2. Remove a member");
                    System.out.println("3. Add a book");
                    System.out.println("4. Remove a book");
                    System.out.println("5. View all members along with their books and fines to be paid");
                    System.out.println("6. View all books");
                    System.out.println("7. Back");
                    System.out.println("---------------------------------"); 
                    arg = sc.nextInt();
                    if(arg==7){
                        break;
                    }
                    else if(arg==1){
                        sc.nextLine();
                        System.out.printf("Name: ");
                        String name = sc.nextLine();
                        System.out.printf("Age: ");
                        int age = sc.nextInt();
                        System.out.printf("Phone: ");
                        long phone = sc.nextLong();
                        sameer.add_member(name.trim(), phone, age);
                    }
                    else if(arg==2){
                        System.out.printf("Member ID: ");
                        int id = sc.nextInt();
                        sameer.rm_member(id);
                    }
                    else if(arg==3){
                        String name;
                        sc.nextLine();
                        System.out.print("Book title: ");
                        name = sc.nextLine(); 
                        System.out.print("Author: ");
                        String author = sc.nextLine(); 
                        System.out.print("Copies: ");
                        int cpy = sc.nextInt(); 
                        sc.nextLine();
                        sameer.add_book(name.trim(), author.trim(), cpy);
                    }
                    else if(arg==4){
                        int id;
                        System.out.print("Book ID: ");
                        id = sc.nextInt(); 
                        sameer.rm_book(id);
                    }
                    else if(arg==5){
                        if(lib.getMember_Count()==0){
                            System.out.println("Nothing to display........");
                            continue;
                        }
                        String display="";
                        for(int i=0;i<lib.getMember_Count();i++){
                            String n = "\nId - "+lib.members.get(i).getID()+"\n"+lib.members.get(i).toString()+"\n"+"Fine payable - "+lib.members.get(i).pay_fine();
                            display = display + n+"\n";
                        }
                        System.out.println(display.substring(0,display.length()-1));
                    }
                    else if(arg==6){
                        if(lib.getBook_Count()==0){
                            System.out.println("Nothing to display........");
                            continue;
                        }
                        String display="";
                        for(int i=0;i<lib.book_count;i++){
                            String n = "\nId - "+lib.books.get(i).getID()+"\n"+lib.books.get(i).toString();
                            display = display + n+"\n";
                        }
                        System.out.println(display.substring(0,display.length()-1));
                    }
                    else{
                        System.out.println("Enter a valid arg......................");
                    }
                }
            }
            else if(arg==2){
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Phone: ");
                long ph = sc.nextLong();
                if(lib.auth(name,ph)){
                    int i = lib.findmem(name, ph);
                    System.out.println("Welcome: "+lib.members.get(i).Name.split(" ")[0]+" Member ID: "+lib.members.get(i).getID());
                    Member mem = lib.members.get(lib.findmem(name,ph));
                    while(true){
                        System.out.println("---------------------------------");
                        System.out.println("1. List Available Books");
                        System.out.println("2. List My Books");
                        System.out.println("3. Issue book");
                        System.out.println("4. Return book");
                        System.out.println("5. Pay Fine");
                        System.out.println("6. Back");
                        System.out.println("---------------------------------"); 
                        arg=sc.nextInt();
                        if(arg==6){
                            break;
                        }
                        else if(arg==1){
                            mem.list_books();
                        }
                        else if(arg==2){
                            mem.list_m_books();
                        }
                        else if(arg==3){
                            if(mem.pay_fine()!=0 ){
                                System.out.println("You have some fine due\nKindly pay first.");
                                continue;
                            }
                            if(mem.holding.size()==2){
                                System.out.println("You are currentrly holding the maximum amount of books.");
                                continue;
                            }
                            int id;
                            System.out.print("Book id: ");
                            id = sc.nextInt();
                            System.out.print("Book Name: ");
                            sc.nextLine();
                            String tit = sc.nextLine();
                            if (mem.issue(id,tit)==1){
                                System.out.println("---------------------------------");
                                System.out.println("Book Issued Successfully!");
                            }
                            else{
                                System.out.println("---------------------------------");
                                System.out.println("Sorry the book for id: "+id+" is not available");
                            }
                        }
                        else if(arg==4){
                            int id;
                            System.out.print("Book id: ");
                            id = sc.nextInt();
                            mem.pay_fine();
                            int fine = mem.pay_fine(id);
                            mem.return_b(id); 
                            System.out.println("---------------------------------");
                            System.out.println("Book ID: "+id+" Successfully returned. " + fine +" Rupees has been charged for your delay of "+fine/3+" days.");
                        }
                        else if(arg==5){
                            if(mem.lib.books.size()!=0){
                                System.out.println("Kindly return your books first..");
                                continue;
                            }
                            if(mem.get_fine()==0){
                                mem.pay_fine();
                            }
                            int fine = mem.get_fine();
                            System.out.println("---------------------------------");
                            if(fine==0){
                                System.out.println("You have no fine!!");
                            }
                            else{
                                System.out.println("You had a total fine of Rs. "+fine+". It has been paid succesfully!");
                            }
                        }
                        else{
                            System.out.println("Enter a valid arg......................");
                        }
                    }
                }
                else{
                    System.out.println("Member with name: "+name+" and Phone no: "+ph+" doesn't exist.");
                    continue;
                }        
            }
            else{
                System.out.println("Please provide a valid arg................");
            }
        }
        sc.close();
    }
}
