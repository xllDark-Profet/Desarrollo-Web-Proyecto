package com.example.bookmicroservice.controller;

import com.example.bookmicroservice.PatchEntities.PatchBookChangeDescription;
import com.example.bookmicroservice.PatchEntities.PatchBookChangeName;
import com.example.bookmicroservice.PatchEntities.PatchBookChangeQuantity;
import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
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

    //PRUEBA
    @GetMapping("/bookp/{pageNo}/{pageSize}")
    private List<Book> getAllPage(@PathVariable(value = "pageNo", required = true) Integer pageNumber, @PathVariable(value = "pageSize", required = true) Integer pageSize) {
        if(pageNumber==null){
            pageNumber=0;
        } else if (pageSize==null) {
            pageSize=2;
        }
        return bookService.getAllBooksPage(pageNumber, pageSize);
    }

    //GET all the books

    @GetMapping("/book")
    private ArrayList<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //GET just one book by id
    @GetMapping("/bookId/{idBook}")
    private Book getBookById(@PathVariable("idBook") Integer id) {
        return bookService.getBookById(id);
    }

    //Get just one book by name
    @GetMapping("/bookName/{nameBook}")
    private Book getBookByName(@PathVariable("nameBook") String name) {
        return bookService.getBookByName(name);
    }

    //Get books by editorial
    @GetMapping("/bookEditorial/{idEditorial}")
    private ArrayList<Book> getBooksByEditorialId(@PathVariable("idEditorial") Integer editorialId) {
        return bookService.getBooksByEditorial(editorialId);
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

    //PATCH
    //PATCH book's name
    @PatchMapping("/bookChangeName")
    private String patchBookName(@RequestBody PatchBookChangeName patchBookChangeName) {
        String retorno = "";
        int auxiliar = bookService.patchName(patchBookChangeName.getName(), patchBookChangeName.getId());
        if (auxiliar == 1) {
            retorno = "El nombre del libro se modifico correctamente";
        } else {
            retorno = "No se pudo cambiar el nombre";
        }
        return retorno;
    }

    //PATCH book's description
    @PatchMapping("/bookChangeDescription")
    private String patchBookDescription(@RequestBody PatchBookChangeDescription patchBookChangeDescription) {
        String retorno = "";
        int auxiliar = bookService.patchDescription(patchBookChangeDescription.getDescription(), patchBookChangeDescription.getId());
        if (auxiliar == 1) {
            retorno = "La descripcion del libro se modifico correctamente";
        } else {
            retorno = "No se pudo cambiar la descripcion";
        }
        return retorno;
    }

    //PATCH book's quantity
    @PatchMapping("/bookChangeQuantity")
    private String patchBookQuantity(@RequestBody PatchBookChangeQuantity patchBookChangeQuantity) {
        String retorno = "";
        int auxiliar = bookService.patchQuantity(patchBookChangeQuantity.getQuantity(), patchBookChangeQuantity.getId());
        if (auxiliar == 1) {
            retorno = "La cantidad disponible del libro se modifico correctamente";
        } else {
            retorno = "No se pudo cambiar la cantidad disponible";
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

    //COMMUNICATION WITH EDITORIAL REPOSITORY
    @GetMapping("/getUseId")
    private ArrayList<Integer> getIdUse(){
        return bookService.editorialIdUse();
    }


}
