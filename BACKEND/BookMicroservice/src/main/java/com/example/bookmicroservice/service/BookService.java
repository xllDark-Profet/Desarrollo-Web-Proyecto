package com.example.bookmicroservice.service;

import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> list(){
        return (List<Book>) bookRepository.findAll();
    }

    public Optional<Book> getOne(int id){
        return bookRepository.findById(id);
    }

    public Optional<Book> getByName(String nombre){
        return bookRepository.findByNombre(nombre);
    }

    public void save(Book book){
        bookRepository.save(book);
    }

    public void delete(int id){
        bookRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return bookRepository.existsById(id);
    }

    public boolean existsByName(String nombre){
        return bookRepository.existsByNombre(nombre);
    }

    //Paginacion
    public Page<Book> paginas(PageRequest pageable){
        return bookRepository.findAll(pageable);
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
    /*
    public ArrayList<Integer>editorialIdUse(){
        ArrayList<Integer> ids=new ArrayList<>();
        for (Book book:list()) {
            if (!ids.contains(book.getEditorial_id())){
                ids.add(book.getEditorial_id());
            }
        }
        return ids;
    }
    * */

}
