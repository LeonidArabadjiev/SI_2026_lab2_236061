import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SI2026Lab2Test {

    @Test
    void searchBookEveryStatementTest() {

        Library lib1 = new Library();
        assertThrows(IllegalArgumentException.class, () -> {
            lib1.searchBookByTitle("");
        });

        Library lib2 = new Library();
        lib2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib2.borrowBook("Clean Code", "Robert C. Martin");
        List<Book> res2 = lib2.searchBookByTitle("Clean Code");
        assertNull(res2);

        Library lib3 = new Library();
        lib3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        List<Book> res3 = lib3.searchBookByTitle("Clean Code");
        assertNotNull(res3);
        assertEquals(1, res3.size());
    }

    @Test
    void borrowBookEveryBranchTest() {

        Library lib1 = new Library();
        lib1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(IllegalArgumentException.class, () -> {
            lib1.borrowBook("", "Robert C. Martin");
        });

        Library lib2 = new Library();
        lib2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(RuntimeException.class, () -> {
            lib2.borrowBook("The Hobbit", "Tolkien");
        });

        Library lib3 = new Library();
        lib3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertDoesNotThrow(() -> {
            lib3.borrowBook("Clean Code", "Robert C. Martin");
        });

        Library lib4 = new Library();
        lib4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib4.borrowBook("Clean Code", "Robert C. Martin");
        assertThrows(RuntimeException.class, () -> {
            lib4.borrowBook("Clean Code", "Robert C. Martin");
        });
    }

    @Test
    void searchBookMultipleConditionTest() {

        Library lib1 = new Library();
        lib1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib1.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(lib1.searchBookByTitle("The Hobbit"));

        Library lib2 = new Library();
        lib2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertNull(lib2.searchBookByTitle("The Hobbit"));

        Library lib3 = new Library();
        lib3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib3.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(lib3.searchBookByTitle("Clean Code"));

        Library lib4 = new Library();
        lib4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertNotNull(lib4.searchBookByTitle("Clean Code"));
    }

    @Test
    void borrowBookMultipleConditionTest() {

        Library lib1 = new Library();
        lib1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertDoesNotThrow(() -> {
            lib1.borrowBook("Clean Code", "Robert C. Martin");
        });

        Library lib2 = new Library();
        lib2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(IllegalArgumentException.class, () -> {
            lib2.borrowBook("Clean Code", "");
        });

        Library lib3 = new Library();
        lib3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(IllegalArgumentException.class, () -> {
            lib3.borrowBook("", "Robert C. Martin");
        });

        Library lib4 = new Library();
        lib4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(IllegalArgumentException.class, () -> {
            lib4.borrowBook("", "");
        });
    }
}