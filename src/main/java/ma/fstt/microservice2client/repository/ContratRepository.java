package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
}
