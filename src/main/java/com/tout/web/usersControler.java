package com.tout.web;

import com.tout.model.userSocio;
import com.tout.model.usersEntity;
import com.tout.service.InterfazService;
import com.tout.service.InterfazServiceSocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class usersControler {
    @Autowired
    private InterfazService service;
    @Autowired
    private InterfazServiceSocio serviciosSocio;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<usersEntity> u = service.listar();
        model.addAttribute("usuario", u);
        List<userSocio> so = serviciosSocio.listar();
        model.addAttribute("usSocio", so);
        return "interfazUsuario";
    }

    @GetMapping("/nuevo")
    public String agregar(Model model) {

        model.addAttribute("usuarios", new usersEntity());
        return "crearUsuarioForm";
    }


    @PostMapping("/save")
    public String save(@Valid usersEntity u, Model model) {
        service.save(u);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<usersEntity> user = service.listarId(id);
        model.addAttribute("usuarios", user);
        return "crearUsuarioForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Model model, @PathVariable int id) {
        service.delete(id);
        return "redirect:/listar";
    }
    //AQUI ESTAN LOS SERVICIOS DE SOCIOS


    @GetMapping("/nuevoSocio")
    public String nuevoSocio(Model model) {
        model.addAttribute("usuarioSocio", new userSocio());
        return "crearSocioForm";

    }

    @PostMapping("/saveSocio")
    public String saveSocio(Model model, @Valid userSocio soci) {
        String uno = soci.getContrasena().substring(0, 4);
        String dos = soci.getApellidoMaterno().substring(0, 2);
        String tres = soci.getNombre().substring(0, 3);
        String complet = uno + dos + tres;
        soci.setNombreUsuario(complet);
        serviciosSocio.save(soci);
        return "redirect:/listar";
    }

    @GetMapping("/editarSocio/{id}")
    public String editarSocio(@PathVariable int id, Model model) {
        Optional<userSocio> usSocio = serviciosSocio.listarId(id);
        model.addAttribute("usuarioSocio", usSocio);
        return "crearSocioForm";
    }

    @GetMapping("/eliminarSocio/{id}")
    public String eliminarSocio(Model model, @PathVariable int id) {
        serviciosSocio.delete(id);
        return "redirect:/listar";
    }

}
