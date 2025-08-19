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

        Assertions.assertTrue(library.books.contains(book));
        Assertions.assertTrue(library.articles.contains(article));
        Assertions.assertTrue(library.newspapers.contains(newspaper));
    }

    @Test
    public void shouldCheckOutArticleIfInStock() {

        Library library = new Library();
        Article article = new Article("Very important journal");
        library.addToStock(article);

        Assertions.assertEquals("item has been checked out", library.checkOutArticle("Very important journal"));
    }

    @Test
    public void shouldDeclineIfNotArticleAvailableInStockOrCheckedOut() {
        Library library = new Library();
        Article article = new Article("Very important journal");
        library.addToStock(article);
        article.checkOut();

        Assertions.assertEquals("item is not part of the library's collection", library.checkOutArticle("My favourite article"));
        Assertions.assertEquals("item is currently on loan", library.checkOutArticle("Very important journal"));
    }

    @Test
    public void shouldCheckOutBookIfInStock() {
        Library library = new Library();
        Book book = new Book("Captivating book");
        library.addToStock(book);

        Assertions.assertEquals("item has been checked out", library.checkOutBook("Captivating book"));

    }

    @Test
    public void shouldDeclineIfNotBookAvailableInStock() {
        Library library = new Library();
        Book book = new Book("Captivating book");
        library.addToStock(book);
        book.checkOut();

        Assertions.assertEquals("item is not part of the library's collection", library.checkOutBook("My favourite book"));
        Assertions.assertEquals("item is currently on loan", library.checkOutBook("Captivating book"));
    }
}
