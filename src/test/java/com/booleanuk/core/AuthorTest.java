package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthorTest {

    @Test
    public void shouldAddItem(){
        Author author = new Author("Hanna Håkansson", "0768498654", "best.com");
        Book book = new Book("My book", author);
        Article article = new Article("Best article", author);
        author.addItem(book);
        author.addItem(article);

        Assertions.assertEquals(book, author.findItem("My book"));
    }
    @Test
    public void shouldRemoveItem(){
        Author author = new Author("Hanna Håkansson", "0768498654", "best.com");
        Book book = new Book("My book", author);
        Article article = new Article("Best article", author);
        author.addItem(book);
        author.addItem(article);
        author.removeItem("My book");

        Assertions.assertNull(author.findItem("My book"));
    }
}
