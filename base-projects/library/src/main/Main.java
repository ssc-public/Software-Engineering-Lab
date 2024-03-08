package main;

import main.classes.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        runExample();
    }

    static void runExample() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Author-1", 10);
        Book book2 = new Book("Book-2", "Author-2", 11);
        Book book3 = new Book("Book-3", "Author-3", 12);
        Book book4 = new Book("Book-4", "Author-1", 13);
        Book book5 = new Book("Not-owned-book", "Author-1", 15);

        Student student1 = new Student("Alice", 10);
        Student student2 = new Student("Bob", 11);
        Student student3 = new Student("John", 12);
        Student student4 = new Student("Not-registered-student", 13);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);


        library.lendBook(book1, student1);
        library.lendBook(book2, student3);
        library.returnBook(book2, student3);
        library.lendBook(book4, student2);

        library.lendBook(book5, student1);

        // Example for search functions
        var keys = new ArrayList<Object>(Arrays.asList(10, 11));
        library.searchBooks(SearchByType.ID, keys); // Should return [book1, book2]
        library.searchBooks(SearchByType.NAME, keys); // Should return null
    }
}
