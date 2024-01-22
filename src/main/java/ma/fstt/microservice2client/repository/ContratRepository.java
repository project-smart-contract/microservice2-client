package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    List<Contrat> findByIdClient(int idClient);
}
