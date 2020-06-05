package com.tout.service;

import com.tout.exception.RecordNotFoundException;
import com.tout.model.CitasEntity;
import com.tout.repository.citasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasService {

    @Autowired
    citasRepository repository;

    public List<CitasEntity> getCitas() {
        return (List<CitasEntity>) repository.findAll();
    }

    public CitasEntity getCitaById(String id){
        Optional<CitasEntity> cita = repository.findById(id);

        if (cita.isPresent()) {
            return repository.findById(id).get();
        }
        return cita.get();
    }

    public CitasEntity createCita(CitasEntity ci) {
        if (ci.getId() == null) {
            ci = repository.save(ci);

            return ci;
        } else {
            Optional<CitasEntity> cita = repository.findById(ci.getId());
            if (cita.isPresent()) {
                CitasEntity newCita = cita.get();
                newCita.setId(ci.getId());
                newCita.setNombreSocio(ci.getNombreSocio());
                newCita.setHora(ci.getHora());
                newCita.setFecha(ci.getFecha());

                newCita = repository.save(newCita);

                return newCita;
            } else {
                ci = repository.save(ci);

                return ci;
            }
        }
    }

    public void deleteCitasById(String id) throws RecordNotFoundException {
        Optional<CitasEntity> cita = repository.findById(id);

        if (cita.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No existe la Id");
        }
    }
}
