package com.tout.web;

import com.tout.model.usersEntity;
import com.tout.service.InterfazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping(path ="/nuevo")
    public String agregar(Model model){

        model.addAttribute("usuario",new usersEntity());
        return "formularioUsuarios.html";
    }
    @PostMapping(path ="/save")
    public String save(@Valid usersEntity u, Model model){
        service.save(u);
        return "redirect:/listar";
    }
}
