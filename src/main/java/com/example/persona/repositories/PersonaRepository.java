package com.example.persona.repositories;


import com.example.persona.entities.Persona;
import com.example.persona.servicies.PersonaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //hacemos el uso de querys para obtener el listado de personas de acuerdo si tiene el string nombre o apellido
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //boolean existsByDni(int dni);//se usa este metodo para verificar si existe una persona con ese dni

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%" )//query con jpquery
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%" )//query con jpquery
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",countQuery = "SELECT count(*) FROM persona", nativeQuery = true )//query con sqlquery
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%", nativeQuery = true )//query con sqlquery

    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
