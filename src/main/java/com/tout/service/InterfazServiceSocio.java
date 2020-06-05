package com.tout.service;

import com.tout.model.userSocio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InterfazServiceSocio {

    public List<userSocio> listar();

    public Optional<userSocio> listarId(int id);

    public int save(userSocio u);

    public void delete(int id);

}

