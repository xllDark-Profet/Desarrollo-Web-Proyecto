package com.example.bookmicroservice.repository;

import com.example.bookmicroservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface BookRepository extends JpaRepository<Book, Integer> {

    //getAllBooks
    @Query(value = "SELECT id, name, description, editorial, fechaEdicion, image_url FROm desarolloweb.book", nativeQuery = true)
    ArrayList<Book> findAll();

    //getJustOneBook
    @Query(value = "select id, name, description, editorial, fechaEdicion, image_url from desarolloweb.book where id=?1", nativeQuery = true)
    Book findBookById(Integer id);

    //Put
    @Modifying
    @Query(value = "update desarolloweb.book set name=?1, description=?2, editorial=?3, fechaEdicion=?4, image_url=?5 where id=?6", nativeQuery = true)
    int updateBook(String name, String description, String editorial, String fechaEdicion ,String image_url, Integer id);


    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.book (id, name, description, editorial, fechaEdicion, image_url) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int createBook(Integer id, String name, String description, String editorial, String fechaEdicion, String image_url);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.book where id=?1", nativeQuery = true)
    int deleteBookById(Integer id);


}
