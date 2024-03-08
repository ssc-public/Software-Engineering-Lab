package main.classes;

import java.util.ArrayList;

public class Student {
    private String name;
    private int id;
    private ArrayList<Book> books;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean hasBook(Book book) {
        return this.books.contains(book);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }


    public void displayBooks() {
        System.out.println(this + " has these books:");
        for (Book book : this.books) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
        return name + "|" + id;
    }
}