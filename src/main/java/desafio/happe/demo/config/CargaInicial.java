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

import java.util.Arrays;

@Configuration
public class CargaInicial implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario gabriela = new Usuario(
                null,
                "Gabriela Guedes",
                "gabriela_rayssa@hotmail.com",
                ("123"));

        Categoria cat1 = new Categoria(null, "Alimentos");
        Categoria cat2 = new Categoria(null, "Limpeza");
        Categoria cat3 = new Categoria(null, "Bebidas");
        Categoria cat4 = new Categoria(null, "Congelados");
        Categoria cat5 = new Categoria(null, "Confeitaria");
        Categoria cat6 = new Categoria(null, "Decoração");
        Categoria cat7 = new Categoria(null, "Açougue");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        usuarioRepository.saveAll(Arrays.asList(gabriela));

        Produtos p1 = new Produtos(null, "Arroz", 2000.00,cat1);
        Produtos p2 = new Produtos(null, "Feijão", 800.00,cat1);
        Produtos p3 = new Produtos(null, "Sorvete", 80.00,cat1);
        Produtos p4 = new Produtos(null, "Picolé", 300.00,cat1);
        Produtos p5 = new Produtos(null, "Cerveja", 50.00,cat1);
        Produtos p6 = new Produtos(null, "Tomate", 200.00,cat1);
        Produtos p7 = new Produtos(null, "Caipirinha", 1200.00,cat1);
        Produtos p8 = new Produtos(null, "Pão", 800.00,cat1);
        Produtos p9 = new Produtos(null, "Carne de Sol", 100.00,cat1);
        Produtos p10 = new Produtos(null, "Moela", 180.00,cat1);
        Produtos p11 = new Produtos(null, "Shampoo", 90.00,cat1);

        produtosRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

    }
}