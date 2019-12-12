package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(SchoolBook book) {
        SchoolBook[] schoolBooks1 = new SchoolBook[schoolBooks.length + 1];
        schoolBooks1[schoolBooks1.length - 1] = book;
        for (int i = 0; i < schoolBooks.length; i++) {
            schoolBooks1[i] = schoolBooks[i];
        }
        schoolBooks = schoolBooks1;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int count = 0;
        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                count++;
            }
        }
        if (count == 0) {
            return new SchoolBook[0];
        }
        SchoolBook[] schoolBooksName = new SchoolBook[count];
        int index = 0;
        for (int i = 0; i < schoolBooks.length; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                schoolBooksName[index] = schoolBooks[i];
                index++;
            }
        }
        return schoolBooksName;
    }

    @Override
    public boolean removeByName(String name) {
        SchoolBook[] schoolBooks1 = new SchoolBook[0];
        int count = 0;
        if (findByName(name) != new SchoolBook[0]) {
            for (int i = 0; i < schoolBooks.length; i++) {
                if (schoolBooks[i].getName().equals(name)) {
                    count++;
                }
            }
            schoolBooks1 = new SchoolBook[schoolBooks.length - count];
            int index = 0;
            for (int j = 0; j < schoolBooks.length; j++) {
                if (!(schoolBooks[j].getName().equals(name))) {
                        schoolBooks1[index] = schoolBooks[j];
                        index++;
                }
            }
            schoolBooks = schoolBooks1;
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
