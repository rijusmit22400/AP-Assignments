This is a project that mimics a real life library management system.

This program has two different use cases.
1. for the librarian.
2. for the member of the library.

as a java program that is indeed object oriented. there are 4 classes
Library
Librarian
Member
Book
Each class has its attributes and methods. And each of them represent a class relationship.


Composition:
Library   -> Member
          -> Books
Member    -> Books

Assosiation:
Library   -> Librarian
Librarian -> Libraray
Member    -> Library

Dependancy:
Member    -> Library
Librarian -> Library

It has all fucntionalities as given in the question. However there were some ambiguities that have been assumed for porper functioning of this program. One of such assumption is that a student must return all their books in order to pay the fine. A student cannot pay their fine unless they return their book.

Also for testing puposes the 1 day = 1 sec. Because this program cannot run for days.

Hi there it's a small request I need you to consider, I had comments on some files but it wasn't compiling, so I removed them I hope you understand. Also I have kept some methods and attribute names simple. 

Pls take this into consideration.