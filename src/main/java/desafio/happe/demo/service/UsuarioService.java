package desafio.happe.demo.service;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.repository.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bc;

    private Random rand = new Random();

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

        if (Objects.isNull(obj)) {
            throw new ObjectNotFoundException(1L,"Usuario");
        }

        String newPass = newPassword();
        obj.setSenha(bc.encode(newPass));

        usuarioRepository.save(obj);

        obj.setSenha(newPass);

        return obj;
    }

    private String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);

        if (opt == 0) { // gera um digito

            return (char) (rand.nextInt(10) + 48);

        } else if (opt == 1) { // gera uma letra maiuscula

            return (char) (rand.nextInt(26) + 65);

        } else { // gera letra minuscula

            return (char) (rand.nextInt(26) + 97);

        }
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
