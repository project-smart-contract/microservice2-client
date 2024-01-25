package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Formule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormuleRepository extends JpaRepository<Formule, Long> {
}
