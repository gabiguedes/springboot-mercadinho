package desafio.happe.demo.config;

import desafio.happe.demo.entity.Categoria;
import desafio.happe.demo.entity.Produtos;
import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.repository.CategoriaRepository;
import desafio.happe.demo.repository.ProdutosRepository;
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
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private BCryptPasswordEncoder bc;

    @Override
    public void run(String... args) throws Exception {

        Usuario gabriela = new Usuario(
                null,
                "Gabriela Guedes",
                "gabriela_rayssa@hotmail.com",
                bc.encode("123"));

        Categoria cat1 = new Categoria(null, "Alimentos");
        Categoria cat2 = new Categoria(null, "Limpeza");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        usuarioRepository.saveAll(Arrays.asList(gabriela));

        Produtos p1 = new Produtos(null, "Arroz", 2000.00,cat1);
        Produtos p2 = new Produtos(null, "Feijão", 800.00,cat1);
        Produtos p3 = new Produtos(null, "Macarrão", 80.00,cat1);
        Produtos p4 = new Produtos(null, "Pão", 800.00,cat1);
        Produtos p5 = new Produtos(null, "Carne de Sol", 100.00,cat1);

        produtosRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}