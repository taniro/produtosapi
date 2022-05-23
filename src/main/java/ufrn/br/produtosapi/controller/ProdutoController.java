package ufrn.br.produtosapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.produtosapi.model.Produto;
import ufrn.br.produtosapi.service.ProdutoService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto entity) {
        Produto produto = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return (ResponseEntity<Produto>) service.findById(id)
                .map(record -> ResponseEntity.ok().body( (Produto) record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto entity) {

        return (ResponseEntity<Produto>) service.update(id, entity)
                .map( record ->ResponseEntity.ok().body((Produto) record ))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (service.delete(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
