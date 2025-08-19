package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Article> articles;
    List<Book> books;
    List<Newspaper> newspapers;

    public Library() {
        this.books = new ArrayList<>();
        this.articles = new ArrayList<>();
        this.newspapers = new ArrayList<>();

    }

    public void addToStock(Article item) {
        this.articles.add(item);
    }

    public void addToStock(Book item) {
        this.books.add(item);
    }

    public void addToStock(Newspaper item) {
        this.newspapers.add(item);
    }

    // The following methods may contain code that you are unfamiliar with. The strange syntax of article -> something
    // is called a lambda expression (https://www.w3schools.com/java/java_lambda.asp)
    public String checkInArticle(String title) {
        List<Article> filtered = this.articles.stream()
                .filter(article -> article.title.equals(title))
                .toList();

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }

        return filtered.get(0).checkIn();
    }

    public String checkOutArticle(String title) {
        List<Article> filtered = this.articles.stream()
                .filter(article -> article.title.equals(title))
                .toList();

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }


        return filtered.get(0).checkOut();
    }

    public String checkInBook(String title) {
        List<Book> filtered = this.books.stream()
                .filter(book -> book.title.equals(title))
                .toList();

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }

        return filtered.get(0).checkIn();
    }

    public String checkOutBook(String title) {
        List<Book> filtered = this.books.stream()
                .filter(book -> book.title.equals(title))
                .toList();

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }

        return filtered.get(0).checkOut();
    }

    public String checkOutNewspaper(String title) {
        List<Newspaper> filtered = this.newspapers.stream()
                .filter(newspaper -> newspaper.title.equals(title))
                .toList();

        if (filtered.size() < 1) {
            return "item is not part of the library's collection";
        }

        return filtered.get(0).checkOut();
    }
}
