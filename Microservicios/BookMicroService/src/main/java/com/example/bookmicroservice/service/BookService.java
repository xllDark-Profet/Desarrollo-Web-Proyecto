package com.example.bookmicroservice.service;
import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.repository.BookRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    //Get all
    public ArrayList<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Get by id
    public Book getBookById(Integer id) {
        Book bookById = new Book();
        bookById = bookRepository.findBookById(id);
        return bookById;
    }

    //Put
    @Transactional
    public int updateBook(@NotNull @org.jetbrains.annotations.NotNull Book updateOne) {
        int recibe = -10;
        recibe = bookRepository.updateBook(updateOne.getName(), updateOne.getDescription(), updateOne.getEditorial(), updateOne.getFechaEdicion(), updateOne.getImageUrl(), updateOne.getId());
        return recibe;
    }

    //Post
    @Transactional
    public int createBook(@NotNull @org.jetbrains.annotations.NotNull Book newBook) {
        int recibe = -10;
        recibe = bookRepository.createBook(newBook.getId(), newBook.getName(), newBook.getDescription(), newBook.getEditorial(), newBook.getFechaEdicion(), newBook.getImageUrl());
        return recibe;
    }

    //Delete
    @Transactional
    public int deleteBook(Integer id) {
        int recibe = -10;
        recibe = bookRepository.deleteBookById(id);
        return recibe;
    }


}
