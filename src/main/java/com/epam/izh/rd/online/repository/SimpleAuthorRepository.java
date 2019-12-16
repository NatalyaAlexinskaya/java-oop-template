package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.ArrayList;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        if (author == null || findByFullName(author.getName(), author.getLastName()) != null) {
            return false;
        } else {
            Author[] authors1 = new Author[authors.length + 1];
            authors1[authors1.length - 1] = author;
            for (int i = 0; i < authors.length; i++) {
                authors1[i] = authors[i];
            }
            authors = authors1;
            return true;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        if (name == null || lastname == null) {
            return null;
        }

        for (int i = 0; i < authors.length; i++) {
            if (name.equals(authors[i].getName()) && lastname.equals(authors[i].getLastName())) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        if (author == null) {
            return false;
        }

        Author[] authors1 = new Author[0];
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            int index = 0;
            authors1 = new Author[authors.length - 1];
            for (int j = 0; j < authors.length; j++) {
                if (!(author.getName().equals(authors[j].getName()) && author.getLastName().equals(authors[j].getLastName()))) {
                    authors1[index] = authors[j];
                    index++;
                }
            }
            authors = authors1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int count() {
        return authors.length;
    }
}
