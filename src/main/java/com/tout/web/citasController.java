package com.tout.web;

import com.tout.exception.RecordNotFoundException;
import com.tout.model.CitasEntity;
import com.tout.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class citasController {

    @Autowired
    private CitasService service;

    @RequestMapping("/consultaCita")
    public String getCitas(Model model) //Consulta General
    {
        List<CitasEntity> cita = service.getCitas();

        model.addAttribute("cita", cita);
        return "consultaCita";
    }

    @RequestMapping("/modificarCita")
    public String getCitasM(Model model) //Consulta General
    {
        List<CitasEntity> cita = service.getCitas();

        model.addAttribute("cita", cita);
        return "consultaMCita";
    }

    @RequestMapping("/registraCita")
    public String inicio(Model model) {
        model.addAttribute("cita", new CitasEntity());
        return "createCita";
    }

    @RequestMapping("/editCita")
    public String update() {
        return "modificarCita";
    }

    @RequestMapping(path = {"/editarCitas/{id}"})
    public String editCitasById(Model model, @PathVariable(value = "id", required = true) String id) {
        CitasEntity cita = service.getCitaById(id);
        model.addAttribute("cita", cita);
        return "modificarCita";
    }

    @RequestMapping(path = {"/deleteCita", "/deleteCita/{id}"})
    public String deleteProductosById(@PathVariable("id") String id) throws RecordNotFoundException {
        service.deleteCitasById(id);
        return "redirect:/consultaCita";
    }

    @RequestMapping(path = "/createCita", method = RequestMethod.POST)
    public String createCita(@RequestParam(value = "id", required = false) Optional<String> id,
                                @RequestParam(value = "nombreSocio", required = true) String nombreSocio,
                                @RequestParam(value = "hora", required = true) int hora,
                                @RequestParam(value = "fecha", required = true) int fecha) {
        CitasEntity citaEntity;
        if (id.isPresent()) {
            citaEntity = service.getCitaById(id.get());
        } else {
            citaEntity = new CitasEntity(); //empty entity
        }
        citaEntity.setNombreSocio(nombreSocio);
        citaEntity.setHora(hora);
        citaEntity.setFecha(fecha);

        service.createCita(citaEntity);
        return "redirect:/consultaCita";
    }

    @RequestMapping(path = "/updateCita", method = RequestMethod.POST)
    public String updateCita(@RequestParam(value = "id", required = false) Optional<String> id,
                               @RequestParam(value = "nombreSocio", required = true) String nombreSocio,
                               @RequestParam(value = "hora", required = true) int hora,
                               @RequestParam(value = "fecha", required = true) int fecha) {
        CitasEntity citaEntity;
        if (id.isPresent()) {
            citaEntity = service.getCitaById(id.get());
        } else {
            citaEntity = new CitasEntity();
        }
        citaEntity.setNombreSocio(nombreSocio);
        citaEntity.setHora(hora);
        citaEntity.setFecha(fecha);

        service.createCita(citaEntity);
        return "redirect:/consultaCita";
    }

    @RequestMapping("/eliminarCita")
    public String getCitasBajas(Model model)
    {
        List<CitasEntity> cita = service.getCitas();

        model.addAttribute("cita", cita);
        return "eliminarCita";
    }
}