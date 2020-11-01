package com.example.persona.repositories;


import com.example.persona.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean//no se pueden crear instancias

public interface BaseRepository <E extends Base, ID extends Serializable>  extends JpaRepository<E,ID> {

}
