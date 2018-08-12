package desafio.happe.demo.service;


import desafio.happe.demo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    UsuarioService usuarioService;

    public Usuario facebookLogin(Usuario usuarioFB) {
        Usuario usuario = usuarioService.findByEmail(usuarioFB.getEmail());

        if(Objects.isNull(usuario)){
            usuario = usuarioService.insert(usuarioFB);
        }

        return usuario;

    }
}
