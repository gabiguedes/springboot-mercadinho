package desafio.happe.demo.service;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(1L, "Usuario"));
    }

    public Usuario insert(Usuario obj) {
        return usuarioRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Usuario obj) {
        Usuario newObj = findById(obj.getId());
        return usuarioRepository.save(obj);
    }

    public Usuario login(Usuario usuario) {
        Usuario obj = findByEmail(usuario.getEmail());

        if (Objects.isNull(obj) || !usuario.getSenha().equals(obj.getSenha())) {
            return null;
        }

        return obj;
    }

    public Usuario recuperarSenha(String email) {
        Usuario obj = findByEmail(email);
        return obj;
    }


    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
