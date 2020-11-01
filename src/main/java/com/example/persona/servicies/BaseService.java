package com.example.persona.servicies;

import com.example.persona.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;//trae una lista de personas en nuestra db
    public Page<E> findAll(Pageable pegeable) throws Exception;


    public E findById(ID id) throws Exception;//nos trae una persona segun su id
    public E save(E entity) throws Exception;//nos crea una nueva entidad
    public E update(ID id, E entity) throws Exception;//tiene los parametros y actualiza la entidad
    public boolean delete(ID id)throws Exception;//elimina el registro de la db

}
