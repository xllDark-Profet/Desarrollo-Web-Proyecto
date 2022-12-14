package com.example.bookmicroservice.controller;


import com.example.bookmicroservice.dto.BookDto;
import com.example.bookmicroservice.dto.Message;
import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de la comunicacion rest
 */
@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")

public class BookController {

    @Autowired
    BookService bookService;

    /**
     * Metodo que devuelve la lista de libros registrada en la base de datos
     * @return lista de libros
     */
    @GetMapping("/lista")
    public ResponseEntity<List<Book>> list(){
        List<Book> list = bookService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /**
     * Metodo que dado un id devuelve el libro correspondiente a el
     * @param id
     * @return libro que corresponde al id y el codigo http de resultado de la operacion
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") int id){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("no existe el libro"), HttpStatus.NOT_FOUND);
        Book book = bookService.getOne(id).get();
        return new ResponseEntity(book, HttpStatus.OK);
    }

    /**
     * Metodo que dado un nombre devuelve el libro correspondiente a el
     * @param name
     * @return libro que corresponde al nombre y el codigo http de resultado de la operacion
     */
    @GetMapping("/detailname/{name}")
    public ResponseEntity<Book> getByName(@PathVariable("name") String name){
        if(!bookService.existsByName(name))
            return new ResponseEntity(new Message("no existe el libro"), HttpStatus.NOT_FOUND);
        Book book = bookService.getByName(name).get();
        return new ResponseEntity(book, HttpStatus.OK);
    }

    /**
     * Metodo que crea un libro. Verifica la validez de los atributos del nuevo libro.
     * @param bookDto
     * @return mensaje que indica el resultado de la operacion y el codigo http de resultado de la operacion
     */

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookDto bookDto){
        if(StringUtils.isBlank(bookDto.getNombre()))
            return new ResponseEntity(new Message("Ingresa un nombre"), HttpStatus.BAD_REQUEST);
        if(bookService.existsByName(bookDto.getNombre()))
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        Book book = new Book(bookDto.getNombre(), bookDto.getDescripcion(), bookDto.getCantidad(), bookDto.getEditorial(), bookDto.getImagen_url(), bookDto.getDia_edicion());
        bookService.save(book);
        return new ResponseEntity(new Message("Libro creado"), HttpStatus.OK);
    }

    /**
     * Metodo que dado un id y un libro modifica los atributos de este. Verifica primero la validez
     * de dichos atributos.
     * @param id
     * @param bookDto
     * @return mensjae que indica el resultado de la operacion y el codigo http de resultado de la operacion
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody BookDto bookDto){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        if(bookService.existsByName(bookDto.getNombre()) && bookService.getByName(bookDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(bookDto.getNombre()))
            return new ResponseEntity(new Message("Ingrese el nombre"), HttpStatus.BAD_REQUEST);

        Book book = bookService.getOne(id).get();
        book.setNombre(bookDto.getNombre());
        book.setDescripcion(bookDto.getDescripcion());
        book.setCantidad(bookDto.getCantidad());
        book.setEditorial(bookDto.getEditorial());
        book.setImagen_url(bookDto.getImagen_url());
        book.setDia_edicion(bookDto.getDia_edicion());
        bookService.save(book);
        return new ResponseEntity(new Message("Libro actualizado"), HttpStatus.OK);
    }

    /**
     * Metodo que elimina un libro dado un id
     * @param id
     * @return mensaje con el resultado de la operacion y el codigo http de resultado de la operacion
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("Libro no existe"), HttpStatus.NOT_FOUND);
        bookService.delete(id);
        return new ResponseEntity(new Message("Libro eliminado"), HttpStatus.OK);
    }

    /**
     * Metodo que se encarga de la paginacion de los libros
     * @param page
     * @param size
     * @param order
     * @param asc
     * @return paginacion de los resultados y el codigo http de resultado de la operacion
     */
    //Paginacion
    @GetMapping("/libros")
    public ResponseEntity<Page<Book>> paginas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){
        Page<Book> books = bookService.paginas(PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            books = bookService.paginas(PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity<Page<Book>>(books, HttpStatus.OK);
    }



    //COMMUNICATION WITH EDITORIAL REPOSITORY
    /*
    @GetMapping("/getUseId")
    private ArrayList<Integer> getIdUse(){
        return bookService.editorialIdUse();
    }

     */



}
