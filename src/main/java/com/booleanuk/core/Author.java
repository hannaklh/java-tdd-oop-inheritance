package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String contactInfo;
    private String website;
    private List<Item> work;

    public Author(String name, String contactInfo, String website, List<Item> work) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.website = website;
        this.work = work;
    }
    public Author(String name, String contactInfo, String website) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.website = website;
        this.work = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Item> getWork() {
        return work;
    }

    public void setWork(List<Item> work) {
        this.work = work;
    }

    public String addItem(Item item) {
       if (item.getClass().equals(Book.class) || item.getClass().equals(Article.class)) {
           work.add(item);
           return "item was added.";
       } else
           return "item is not a book or an article.";
    }

    public void removeItem(String title) {

        work.removeIf(item -> item.getTitle().equals(title));
    }

    public Item findItem(String title) {
        for (Item item : work) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }
}
