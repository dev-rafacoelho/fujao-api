package com.fujao.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosRestController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> buscarTodas() {
    	return usuariosService.findAll();
    }
    
    @PostMapping
    public Usuarios salvarUsuario(@RequestBody Usuarios usuarios){
    	return usuariosService.save(usuarios);
    }   
    
    @GetMapping("/login")
    public Boolean loginUsuario(@RequestBody Usuarios usuarios){
    	return usuariosService.login(usuarios);
    } 
    
    
}