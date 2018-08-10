package desafio.happe.demo.service;

import desafio.happe.demo.entity.Categoria;
import desafio.happe.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }
}
