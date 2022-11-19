package com.example.bookmicroservice.service;

import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Metodo que se encarga de la logica de negocio de la aplicacion
 */
@Service
@Transactional
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    /**
     * Metodo que regresa invoca el metodo del repositorio que devuelve la lista de libro registrados
     * @return lista de libros
     */
    public List<Book> list(){
        return (List<Book>) bookRepository.findAll();
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un id devuelve el libro
     * @param id
     * @return libro que corresponde al id
     */
    public Optional<Book> getOne(int id){
        return bookRepository.findById(id);
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un nombre  regresa el libro
     * @param nombre
     * @return libro que corresponde al nombre
     */

    public Optional<Book> getByName(String nombre){
        return bookRepository.findByNombre(nombre);
    }

    /**
     * Metodo que invoca el metodo del repositorio que guarda en la base de datos un nuevo libro
     * @param book
     */

    public void save(Book book){
        bookRepository.save(book);
    }

    /**
     *  Metodo que invoca el metodo del repositorio que dado un id elimina el libro de la base de datos.
     * @param id
     */

    public void delete(int id){
        bookRepository.deleteById(id);
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un id determina si un libro existe o no en la base de datos
     * @param id
     * @return booleano que indica si existe el libro o no
     */
    public boolean existsById(int id){
        return bookRepository.existsById(id);
    }

    /**
     * Metodo que invoca el metodo del repositorio que dado un nombre determina si un libro existe o no en la base de datos
     * @param nombre
     * @return booleano que indica si existe el libro o no
     */
    public boolean existsByName(String nombre){
        return bookRepository.existsByNombre(nombre);
    }

    //Paginacion
    public Page<Book> paginas(PageRequest pageable) {
        return bookRepository.findAll(pageable);

        /**
         * Metodo que  invoca el metodo del repositorio que pagina la lista de libros
         * @param pageable
         * @return lista de libros paginados
         */

    }


}
