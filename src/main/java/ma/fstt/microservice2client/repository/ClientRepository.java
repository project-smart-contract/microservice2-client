package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}