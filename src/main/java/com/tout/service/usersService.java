package com.tout.service;

import com.tout.model.usersEntity;
import com.tout.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usersService implements InterfazService {
    @Autowired
    private usersRepository data;

    @Override
    public List<usersEntity> listar() {
        return (List<usersEntity>) data.findAll();
    }

    @Override
    public Optional<usersEntity> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(usersEntity u) {
        int res = 0;
        usersEntity usuario = data.save(u);
        if (!usuario.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
    data.deleteById(id);
    }



}
