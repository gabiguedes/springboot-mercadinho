package desafio.happe.demo.controller;

import desafio.happe.demo.entity.Usuario;
import desafio.happe.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <Usuario> findById(@PathVariable Long id) {
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/recuperar/senha/{email}", method = RequestMethod.GET)
    public ResponseEntity <Usuario> recuperarSenha(@PathVariable String email) {
        Usuario obj = usuarioService.recuperarSenha(email);

        if (Objects.isNull(obj)) {
            return ResponseEntity.status(404).body(obj);
        }

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity <Usuario> login(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.login(usuario);

        if (Objects.isNull(obj) ) {
            return ResponseEntity.status(403).body(obj);
        }

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Usuario> insert(@RequestBody Usuario usuario) {

        usuario.setId(null);
        Usuario obj = usuarioService.insert(usuario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity <Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity <Void> update(@PathVariable Long id, @RequestBody Usuario usuario) {

        usuario.setId(id);
        usuarioService.update(usuario);

        return ResponseEntity.ok().build();
    }

}
