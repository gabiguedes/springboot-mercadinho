package desafio.happe.demo.config;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class CargaInicial implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bc;

    @Override
    public void run(String... args) throws Exception {

        usuarioRepository.deleteAll();

        Usuario gabriela = new Usuario(
                null,
                "Gabriela Guedes",
                "gabriela_rayssa@hotmail.com",
                bc.encode("123"));


        usuarioRepository.saveAll(Arrays.asList(gabriela));

    }
}
