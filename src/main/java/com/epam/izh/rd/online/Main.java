package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.SimpleAuthorRepository;
import com.epam.izh.rd.online.repository.SimpleSchoolBookRepository;
import com.epam.izh.rd.online.service.SimpleSchoolBookService;

import java.awt.print.Book;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        SimpleAuthorRepository repository = new SimpleAuthorRepository();
        repository.save(new Author("Иван", "Иванов", LocalDate.now(), "Россия"));
        repository.save(new Author("Иван", "Иванов", LocalDate.now(), "Россия"));
        repository.save(new Author("Иван1", "Иванов3", LocalDate.now(), "Россия"));
        repository.save(new Author("Иван2", "Иванов4", LocalDate.now(), "Россия"));
        repository.findByFullName("Иван1", "Иванов3");
        repository.remove(new Author("Иван1", "Иванов3", LocalDate.now(), "Россия"));

        SimpleSchoolBookRepository bookRepository = new SimpleSchoolBookRepository();
        bookRepository.save(new SchoolBook(5, "привет", "пока", "kjk", LocalDate.now()));
        bookRepository.save(new SchoolBook(5, "привет1", "пока", "kjk", LocalDate.now()));
        bookRepository.save(new SchoolBook(5, "привет", "пока", "kjk", LocalDate.now()));
        bookRepository.save(new SchoolBook(5, "привет2", "пока", "kjk", LocalDate.now()));
        System.out.println(bookRepository.findByName("привет"));

        SimpleSchoolBookService bookService = new SimpleSchoolBookService();
        bookService.getNumberOfBooksByName("привет");

    }

}
