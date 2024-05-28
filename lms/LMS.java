package lms;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class LMS {

    private List<Book> books = new ArrayList<>();
    private List<Book> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("New book added: " + book.getTitle() + ", Author: " + book.getAuthor());
    }

    public boolean removeBook(Book book) {
        boolean removed = books.removeIf(b -> b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor()));
        if (removed) {
            System.out.println("Book removed: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
        return removed;
    }

    public void borrowBook(Book book, Student student) {
        if (books.remove(book)) {
            borrowedBooks.add(book);
            System.out.println(student.firstName + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            books.add(book);
            System.out.println("Book returned: " + book.getTitle());
            return true;
        } else {
            System.out.println("This book was not borrowed.");
            return false;
        }
    }

    public void saveState(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(books);
            System.out.println("Library state saved to: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean loadState(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            books = (List<Book>) ois.readObject();
            System.out.println("Library state loaded from: " + filePath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}