package com.tout.repository;

import com.tout.model.CitasEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface citasRepository extends CrudRepository<CitasEntity, String> {
}
