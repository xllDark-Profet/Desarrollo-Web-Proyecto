package com.example.bookmicroservice.service;

import com.example.bookmicroservice.entity.Book;
import com.example.bookmicroservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    BookRepository bookRepository;

    public List<Book> list(){
        return bookRepository.findAll();
    }

    public Optional<Book> getOne(int id){
        return bookRepository.findById(id);
    }

    public Optional<Book> getByName(String name){
        return bookRepository.findByName(name);
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

    public boolean existsByName(String name){
        return bookRepository.existsByName(name);
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
        for (Book book:list()) {
            if (!ids.contains(book.getEditorial_id())){
                ids.add(book.getEditorial_id());
            }
        }
        return ids;
    }

}
