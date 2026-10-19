package org.example;

class Library {
    private int books;

    Library(int totalBooks) {
        books = totalBooks;
    }

    void borrowBook(String student) {
        synchronized (this) {
            if (books > 0) {
                System.out.println(student + " взяв книгу.");
                books--;
            } else {
                System.out.println("Немає книг для " + student);
            }
        }
    }
}

class LibraryUser extends Thread {
    Library library;
    String studentName;

    LibraryUser(Library library, String studentName) {
        this.library = library;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        library.borrowBook(studentName);
    }
}

public class SyncBlockExample {
    public static void main(String[] args) {
        Library library = new Library(2);

        LibraryUser u1 = new LibraryUser(library, "Студент 1");
        LibraryUser u2 = new LibraryUser(library, "Студент 2");
        LibraryUser u3 = new LibraryUser(library, "Студент 3");

        u1.start();
        u2.start();
        u3.start();
    }
}