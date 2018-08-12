package desafio.happe.demo.controller;

import desafio.happe.demo.entity.Produtos;
import desafio.happe.demo.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutosService produtosService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produtos>> findAll() {
        List<Produtos> list = produtosService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <Produtos> findById(@PathVariable Long id) {
        Produtos obj = produtosService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/categoria/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<Produtos>> findAllByCategoria(@PathVariable Long id) {
        List<Produtos> list = produtosService.findAllByCategoria(id);
        return ResponseEntity.ok().body(list);
    }

}
