package ufrn.br.produtosapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.produtosapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
