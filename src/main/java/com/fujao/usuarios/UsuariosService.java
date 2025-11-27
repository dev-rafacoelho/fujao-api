package com.fujao.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Usuarios loginRetornaUsuario(Usuarios parametro) {
        List<Usuarios> usuarios = usuariosRepository.findByEmail(parametro.getEmail());

        if (usuarios.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuarios usuario = usuarios.get(0);
        if (usuario.getHash_senha().equals(parametro.getHash_senha())) {
            return usuario;
        }
        
        throw new RuntimeException("Senha incorreta");
    }

    public Usuarios findByEmail(String email) {
        List<Usuarios> usuarios = usuariosRepository.findByEmail(email);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    public Optional<Usuarios> findById(Integer id) {
        return usuariosRepository.findById(id);
    }

    public Usuarios atualizarUsuario(Integer id, Usuarios usuarioAtualizado) {
        Optional<Usuarios> usuarioExistente = usuariosRepository.findById(id);
        
        if (!usuarioExistente.isPresent()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuarios usuario = usuarioExistente.get();
        
        // Atualizar apenas os campos que foram fornecidos
        if (usuarioAtualizado.getNome() != null) {
            usuario.setNome(usuarioAtualizado.getNome());
        }
        if (usuarioAtualizado.getTelefone() != null) {
            usuario.setTelefone(usuarioAtualizado.getTelefone());
        }
        if (usuarioAtualizado.getEmail() != null) {
            usuario.setEmail(usuarioAtualizado.getEmail());
        }
        if (usuarioAtualizado.getHash_senha() != null && !usuarioAtualizado.getHash_senha().isEmpty()) {
            usuario.setHash_senha(usuarioAtualizado.getHash_senha());
        }
        // CPF geralmente não é alterado, mas se necessário, pode ser adicionado aqui
        
        return usuariosRepository.save(usuario);
    }
}