package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule,Integer> {
    List<Vehicule> findByIdClient(int idClient);
}
