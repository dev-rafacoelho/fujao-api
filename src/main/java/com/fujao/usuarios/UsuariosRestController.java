package com.fujao.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuarioRetorna(@RequestBody Usuarios usuarios){
    	try {
    		Usuarios usuario = usuariosService.loginRetornaUsuario(usuarios);
    		return ResponseEntity.ok(usuario);
    	} catch (RuntimeException e) {
    		// Retornar erro apropriado com mensagem
    		if (e.getMessage().contains("não encontrado")) {
    			return ResponseEntity.status(404).body(new ErrorResponse(e.getMessage()));
    		} else if (e.getMessage().contains("Senha incorreta")) {
    			return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
    		}
    		return ResponseEntity.status(400).body(new ErrorResponse(e.getMessage()));
    	}
    }
    
    // Classe interna para resposta de erro
    private static class ErrorResponse {
    	private String message;
    	
    	public ErrorResponse(String message) {
    		this.message = message;
    	}
    	
    	public String getMessage() {
    		return message;
    	}
    }
    
    @GetMapping("/email/{email}")
    public Usuarios buscarPorEmail(@PathVariable String email){
    	Usuarios usuario = usuariosService.findByEmail(email);
    	if (usuario == null) {
    		throw new RuntimeException("Usuário não encontrado");
    	}
    	return usuario;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable Integer id){
    	return usuariosService.findById(id)
    		.map(usuario -> ResponseEntity.ok(usuario))
    		.orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuarios usuarioAtualizado){
    	try {
    		Usuarios usuario = usuariosService.atualizarUsuario(id, usuarioAtualizado);
    		return ResponseEntity.ok(usuario);
    	} catch (RuntimeException e) {
    		return ResponseEntity.status(404).body(new ErrorResponse(e.getMessage()));
    	}
    }
    
    
}