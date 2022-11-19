package com.example.personmicroservice.repository;

import com.example.personmicroservice.entity.Person;
import com.example.personmicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Esta clase extiende del repositorio de JPA para poder usar sus funcionalidades y es la encargada
 * de acceder a la base de datos
 */
@Controller
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //Get

    /**
     * Este metodo obtiene una persona usando su nombre de usuario y contrasena de la base de datos
     * @param username
     * @param password
     * @return la persona a la que corresponde el usuario y contrasena indicados
     */
    Person findPersonByUsernameAndPassword(String username, String password);
    //getAllPersons

    /**
     * Este metodo devuelve la lista de personas registradas en la libreria  de la base de datos
     * @return lista personas
     */
    ArrayList<Person> findAll();
    //getJustOnePerson

    /**
     * Este metodo obtiene una persona en especifico buscandola por el id en la base de datos
     * @param id
     * @return persona a la que corresponde el id indicado
     */
    Person findPersonById(Integer id);

    //Put

    /**
     * Este metodo modifica todos los atributos de una persona en la base de datos
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param cargo
     * @param username
     * @param password
     * @param id
     * @return el resultado de la operacion
     */
    @Modifying
    @Query(value = "update desarolloweb.person set name=?1, surname=?2, birth=?3, charge=?4, username=?5, password=?6 where id=?5", nativeQuery = true)
    int updatePerson(String nombre, String apellido, String fechaNacimiento, String cargo, String username, String password, Integer id);

    //Patch
    //Change name

    /**
     * Este metodo modifica el atributo nombre de una persona en la base de datos
     * @param name
     * @param id
     * @return resultado de la operacion
     */
    @Modifying
    @Query(value="update desarolloweb.person set name=?1 where id=?2", nativeQuery = true)
    int updatePersonName(String name, Integer id);

    /**
     * Este metodo modifica el atributo apellido de una persona en la base de datos
     * @param surname
     * @param id
     * @return reusltado de la operacion
     */
    //Change surname
    @Modifying
    @Query(value="update desarolloweb.person set surname=?1 where id=?2", nativeQuery = true)
    int updatePersonSurname(String surname, Integer id);

    /**
     * Este metodo modifica el atributo fecha de nacimiento  de una persona en la base de datos
     * @param birth
     * @param id
     * @return resultado de la operacion
     */
    //Change birth
    @Modifying
    @Query(value="update desarolloweb.person set birth=?1 where id=?2", nativeQuery = true)
    int updatePersonBirth(String birth, Integer id);

    /**
     * Este metodo modifica el atributo rol de una persona en la base de datos
     * @param charge
     * @param id
     * @return
     */
    //Change charge
    @Modifying
    @Query(value="update desarolloweb.person set charge=?1 where id=?2", nativeQuery = true)
    int updatePersonCharge(String charge, Integer id);

    /**
     * Este metodo crea una persona en la base de datos
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param username
     * @param password
     * @param cargo
     * @return el resultado de la operacion
     */
    //Post
    @Modifying
    @Query(value = "insert into desarolloweb.person (id, name, surname, birth, charge, username, password) values (?1, ?2, ?3, ?4, ?5, ?6,?7)", nativeQuery = true)
    int createPerson(Integer id, String nombre, String apellido, String fechaNacimiento,String username, String password, String cargo);

    /**
     * Este metodo elimina una persona de la base de datos
     * @param id
     * @return
     */
    //Delete
    int deletePersonById(Integer id);

}
