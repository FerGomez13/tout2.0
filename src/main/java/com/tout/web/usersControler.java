package com.tout.web;

import com.tout.model.usersEntity;
import com.tout.service.InterfazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class usersControler {

    @Autowired
    private InterfazService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<usersEntity> u = service.listar();
        model.addAttribute("usuarios",u);
        return "interfazUsuario";
    }
    @GetMapping("/nuevo")
    public String agregar(Model model){

        model.addAttribute("usuarios",new usersEntity());
        return "formularioUsuarios.html";
    }
    @PostMapping("/save")
    public String save(@Valid usersEntity u, Model model){
        service.save(u);
        return "redirect:/Listar";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<usersEntity> user = service.listarId(id);
        model.addAttribute("usuarios",user);
        return "interfazUsuario";
    }

        @GetMapping("/eliminar/{id}")
    public  String eliminar(Model model, @PathVariable int id){
        service.delete(id);
            return "redirect:/Listar";
        }
}
