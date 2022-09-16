package com.example.bookmicroservice.controller;

import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    //POST a new book
    @PostMapping("/bookNewBook")
    private String postNewBook(@RequestBody Book newBook) {
        String retorno = "";
        int auxiliar = bookService.createBook(newBook);
        if (auxiliar == 1) {
            retorno = "Tu libro fue publicado";
        } else {
            retorno = "No se pudo publicar el libro";
        }
        return retorno;
    }

    //GET all the books
    @GetMapping("/book")
    private ArrayList<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //GET just one book
    @GetMapping("/book/{idBook}")
    private Book getJustOneBook(@PathVariable("idBook") Integer id) {
        return bookService.getBookById(id);
    }


    //PUT one book
    @PutMapping("/bookUpdate")
    private String putBook(@RequestBody Book updateBook) {
        String retorno = "";
        int auxiliar = bookService.updateBook(updateBook);
        if (auxiliar == 1) {
            retorno = "Tu libro fue modificado";
        } else {
            retorno = "No se pudo actualizar la informacion";
        }
        return retorno;
    }

    //Delete one book
    @DeleteMapping("/bookDelete/{idBook}")
    private String deleteBook(@PathVariable("idBook") Integer id) {
        int auxiliar = bookService.deleteBook(id);
        String retorno = "";
        if (auxiliar == 1) {
            retorno = "Se elimino exitosamente";
        } else {
            retorno = "No se elimino";
        }
        return retorno;
    }


}
