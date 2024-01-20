package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Integer> {

}
