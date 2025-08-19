package com.booleanuk.core;

public class Article extends Item {

    Author author;
    public Article(String title) {
        super(title);
    }
    public Article(String title, Author author) {

        super(title);
        this.author = author;
    }
}
