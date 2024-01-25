package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
