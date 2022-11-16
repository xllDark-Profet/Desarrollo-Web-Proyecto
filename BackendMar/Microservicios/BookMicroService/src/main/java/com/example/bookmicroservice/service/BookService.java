package com.example.bookmicroservice.service;
import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.repository.BookRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    //Post
    @Transactional
    public int createBook(@NotNull @org.jetbrains.annotations.NotNull Book newBook) {
        int recibe = -10;
        Boolean result = false;
        result = editorialExist(newBook.getEditorial_id());
        if (result == true) {
            recibe = bookRepository.createBook(newBook.getName(), newBook.getDescription(), newBook.getEditorial_id(), newBook.getDate_edition(), newBook.getImage_url(), newBook.getQuantity());
        }
        return recibe;
    }

    //pagination
    public List<Book> getAllBooksPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        Page<Book> bookPage=bookRepository.findAllPage(pageable);
        return bookPage.getContent();
    }
    //Get all
    public ArrayList<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Get by id
    public Book getBookById(Integer id) {
        return bookRepository.findBookById(id);
    }

    //Get by name
    public Book getBookByName(String name) {
        return bookRepository.findBookByName(name);
    }
    //Get by editorial number
    public ArrayList<Book> getBooksByEditorial(Integer editorial_id){
        return bookRepository.finBookByEditorial_id(editorial_id);
    }

    //Put
    @Transactional
    public int updateBook(@NotNull @org.jetbrains.annotations.NotNull Book updateOne) {
        int recibe = -10;
        Boolean result = false;
        result = editorialExist(updateOne.getEditorial_id());
        if (result == true) {
            recibe = bookRepository.updateBook(updateOne.getName(), updateOne.getDescription(), updateOne.getEditorial_id(), updateOne.getDate_edition(), updateOne.getImage_url(), updateOne.getQuantity(), updateOne.getId());
        }
        return recibe;
    }

    //Patch
    @Transactional
    public int patchName(@NotNull @org.jetbrains.annotations.NotNull String name, @NotNull @org.jetbrains.annotations.NotNull Integer id){
        int recibe=-10;
        recibe=bookRepository.patchName(name,id);
        return recibe;
    }

    @Transactional
    public int patchQuantity(@NotNull @org.jetbrains.annotations.NotNull Integer quantity, @NotNull @org.jetbrains.annotations.NotNull Integer id){
        int recibe=-10;
        recibe=bookRepository.patchQuantity(quantity,id);
        return recibe;
    }

    @Transactional
    public int patchDescription(@NotNull @org.jetbrains.annotations.NotNull String description, @NotNull @org.jetbrains.annotations.NotNull Integer id){
        int recibe=-10;
        recibe=bookRepository.patchDescription(description,id);
        return recibe;
    }

    //Delete
    @Transactional
    public int deleteBook(Integer id) {
        int recibe = -10;
        recibe = bookRepository.deleteBookById(id);
        return recibe;
    }

    //COMMUNICATION WITH EDITORIAL SERVICE


    //COMMUNICATION BETWEEN SERVICES
    //If there exist any editorial
    public Boolean editorialExist(Integer idEditorial) {
        Boolean result = false;
        ArrayList<Integer> ids = new RestTemplate().getForObject("http://localhost:8082/editorials/idEditorial", ArrayList.class);
        for (Integer inte : ids) {
            if (inte == idEditorial) {
                result = true;
            }
        }
        return result;
    }
    //Id from editorial
    public ArrayList<Integer>editorialIdUse(){
        ArrayList<Integer> ids=new ArrayList<>();
        for (Book books:getAllBooks()) {
            if (!ids.contains(books.getEditorial_id())){
                ids.add(books.getEditorial_id());
            }
        }
        return ids;
    }

}
