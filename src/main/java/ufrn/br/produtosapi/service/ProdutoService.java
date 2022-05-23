package ufrn.br.produtosapi.service;

import org.springframework.stereotype.Service;
import ufrn.br.produtosapi.model.Produto;
import ufrn.br.produtosapi.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    protected final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto create(Produto entity) {
        return repository.save(entity);
    }

    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Produto> update(Long id, Produto entity) {
        return repository
                .findById(id)
                .map(record -> {
                    repository.saveAndFlush(entity);
                    return record;
                });
    }

    public Boolean delete(Long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
