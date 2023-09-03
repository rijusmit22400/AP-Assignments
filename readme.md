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

It has all fucntionalities as given in the question. However there were some ambiguities that have been assumed for porper functioning of this program. 
