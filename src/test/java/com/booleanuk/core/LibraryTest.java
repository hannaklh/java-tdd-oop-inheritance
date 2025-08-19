package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Test
   public void shouldAddToStock() {
        Library library = new Library();

        Book book = new Book("Captivating book");
        Article article = new Article("Very important journal");
        Newspaper newspaper = new Newspaper("Today's newspaper");

        library.addToStock(book);
        library.addToStock(article);
        library.addToStock(newspaper);

        Assertions.assertTrue(library.items.contains(book));
        Assertions.assertTrue(library.items.contains(article));
        Assertions.assertTrue(library.items.contains(newspaper));
    }

    @Test
    public void shouldCheckOutItemIfInStock() {

        Library library = new Library();
        Article article = new Article("Very important journal");
        library.addToStock(article);

        Assertions.assertEquals("item has been checked out", library.checkOutItem("Very important journal"));

        Book book = new Book("Captivating book");
        library.addToStock(book);

        Assertions.assertEquals("item has been checked out", library.checkOutItem("Captivating book"));

    }

    @Test
    public void shouldDeclineIfItemNotAvailableInStockOrCheckedOut() {
        Library library = new Library();
        Article article = new Article("Very important journal");
        library.addToStock(article);
        article.checkOut();

        Assertions.assertEquals("item is not part of the library's collection", library.checkOutItem("My favourite article"));
        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Very important journal"));

        Book book = new Book("Captivating book");
        library.addToStock(book);
        book.checkOut();

        Assertions.assertEquals("item is not part of the library's collection", library.checkOutItem("My favourite book"));
        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Captivating book"));

    }
    @Test
    public void shouldDeclineIfNewspaper() {
        Library library = new Library();
        Newspaper newspaper = new Newspaper("Most interesting newspaper");
        library.addToStock(newspaper);

        Assertions.assertEquals("newspapers are not available for loan", library.checkOutItem("Most interesting newspaper"));
        Assertions.assertEquals("newspapers are not available for loan", library.checkOutItem("Most interesting newspaper"));
    }
}
