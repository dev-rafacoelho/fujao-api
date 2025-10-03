package com.fujao.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    public Usuarios save(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public Boolean login(Usuarios parametro) {
        List<Usuarios> usuarios = usuariosRepository.findByEmail(parametro.getEmail());

        if (usuarios.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return usuarios.get(0).getHash_senha().equals(parametro.getHash_senha());
    }
}