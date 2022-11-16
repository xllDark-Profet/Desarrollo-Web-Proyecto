package com.example.bookmicroservice.repository;

import com.example.bookmicroservice.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public interface BookRepository extends JpaRepository<Book, Integer> {

    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.book (name, description, editorial_id, date_edition, image_url, quantity) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int createBook(String name, String description,Integer editorial, String fechaEdicion, String image_url, Integer quantity);

    //Get
    //pagination
    @Query(value = "SELECT * FROM desarolloweb.book", nativeQuery = true)
    Page<Book> findAllPage(Pageable pageable);

    //getAllBooks
    @Query(value = "SELECT * FROM desarolloweb.book", nativeQuery = true)
    ArrayList<Book> findAll();

    //getJustOneBookById
    @Query(value = "SELECT * FROM desarolloweb.book WHERE id=?1", nativeQuery = true)
    Book findBookById(Integer id);
    //hetJustOneBookByName
    Book findBookByName(String Name);
    //getBooksFromEditorial
    @Query(value="SELECT * FROM desarolloweb.book WHERE editorial_id=?1", nativeQuery = true)
    ArrayList<Book> finBookByEditorial_id(Integer editorial_id);


    //Put
    @Modifying
    @Query(value = "UPDATE desarolloweb.book SET name=?1, description=?2, editorial_id=?3, date_edition=?4, image_url=?5, quantity=?6 WHERE id=?7", nativeQuery = true)
    int updateBook(String name, String description, Integer editorial, String date_edition ,String image_url, Integer quantity, Integer id);

    //Patch
    @Modifying
    @Query(value = "UPDATE desarolloweb.book SET name=?1 WHERE id=?2", nativeQuery = true)
    int patchName(String name, Integer id);

    @Modifying
    @Query(value = "UPDATE desarolloweb.book SET description=?1 WHERE id=?2", nativeQuery = true)
    int patchDescription(String description, Integer id);

    @Modifying
    @Query(value = "UPDATE desarolloweb.book SET quantity=?1 WHERE id=?2", nativeQuery = true)
    int patchQuantity(Integer quantity, Integer id);

    //Delete
    @Modifying
    @Query(value = "delete from desarolloweb.book where id=?1", nativeQuery = true)
    int deleteBookById(Integer id);

}
