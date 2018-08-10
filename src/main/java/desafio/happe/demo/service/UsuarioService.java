package desafio.happe.demo.service;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findOne(id);
    }
}
