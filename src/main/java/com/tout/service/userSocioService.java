package com.tout.service;

import com.tout.model.userSocio;
import com.tout.model.usersEntity;
import com.tout.repository.userSocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userSocioService implements InterfazServiceSocio {
    @Autowired
    private userSocioRepository dataSocio;

    @Override
    public List<userSocio> listar() {
        return (List<userSocio>) dataSocio.findAll();

    }

    @Override
    public Optional<userSocio> listarId(int id) {
        return dataSocio.findById(id);
    }

    @Override
    public int save(userSocio u) {
        int res = 0;
        userSocio us = dataSocio.save(u);
        if (!us.equals(null)) {
            res = 1;
        }
        return res;

    }

    @Override
    public void delete(int id) {
        dataSocio.deleteById(id);
    }
}
