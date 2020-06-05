package com.tout.service;

import com.tout.model.usersEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface InterfazService {
    public List<usersEntity> listar();

    public Optional<usersEntity> listarId(int id);

    public int save(usersEntity u);

    public void delete(int id);

}
