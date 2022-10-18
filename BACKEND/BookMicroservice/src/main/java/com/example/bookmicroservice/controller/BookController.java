package com.example.bookmicroservice.controller;


import com.example.bookmicroservice.dto.BookDto;
import com.example.bookmicroservice.dto.Message;
import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")

public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book-list")
    public ResponseEntity<List<Book>> list(){
        List<Book> list = bookService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/book-detail/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") int id){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("no existe el libro"), HttpStatus.NOT_FOUND);
        Book book = bookService.getOne(id).get();
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @GetMapping("/book-detail-name/{name}")
    public ResponseEntity<Book> getByName(@PathVariable("name") String name){
        if(!bookService.existsByName(name))
            return new ResponseEntity(new Message("no existe el libro"), HttpStatus.NOT_FOUND);
        Book book = bookService.getByName(name).get();
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-book")
    public ResponseEntity<?> create(@RequestBody BookDto bookDto){
        if(StringUtils.isBlank(bookDto.getName()))
            return new ResponseEntity(new Message("Ingresa un nombre"), HttpStatus.BAD_REQUEST);
        if(bookDto.getQuantity()==0 || bookDto.getQuantity()<0 )
            return new ResponseEntity(new Message("La cantidad debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(bookService.existsByName(bookDto.getName()))
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Book book = new Book(bookDto.getName(), bookDto.getDescription(), bookDto.getEditorial_id(), bookDto.getDate_edition(), bookDto.getImage_url(), bookDto.getQuantity());
        bookService.save(book);
        return new ResponseEntity(new Message("Libro creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-book/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody BookDto bookDto){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        if(bookService.existsByName(bookDto.getName()) && bookService.getByName(bookDto.getName()).get().getId() != id)
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(bookDto.getName()))
            return new ResponseEntity(new Message("Ingrese el nombre"), HttpStatus.BAD_REQUEST);
        if(bookDto.getQuantity()==0 || bookDto.getQuantity()<0 )
            return new ResponseEntity(new Message("La cantidad debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        Book book = bookService.getOne(id).get();
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setEditorial_id(bookDto.getEditorial_id());
        book.setDate_edition(bookDto.getDate_edition());
        book.setImage_url(bookDto.getImage_url());
        book.setQuantify(bookDto.getQuantity());
        bookService.save(book);
        return new ResponseEntity(new Message("Libro actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("Libro no existe"), HttpStatus.NOT_FOUND);
        bookService.delete(id);
        return new ResponseEntity(new Message("Libro eliminado"), HttpStatus.OK);
    }

    //COMMUNICATION WITH EDITORIAL REPOSITORY
    @GetMapping("/getUseId")
    private ArrayList<Integer> getIdUse(){
        return bookService.editorialIdUse();
    }

}
