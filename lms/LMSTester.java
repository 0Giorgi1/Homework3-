package lms;

public class LMSTester {
    public static void main(String[] args) {

        LMS iliauniLibrary = new LMS();

        // Load the library state from a file
        if (!iliauniLibrary.loadState("libraryState.txt")) {
            System.out.println("No saved library state found. Starting with an empty library.");
        }

        // Add some books to the library
        Book lor = new Book("Lord of the Rings", "J.R.R. Tolkien");
        Book oop = new Book("Object-Oriented Programming", "Paata Gogisvhili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);

        // Borrow some books
        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);

        // Save the library state to a file
        iliauniLibrary.saveState("libraryState.txt");
    }
}