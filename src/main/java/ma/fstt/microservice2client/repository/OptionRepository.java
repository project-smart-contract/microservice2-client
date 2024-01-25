package ma.fstt.microservice2client.repository;

import ma.fstt.microservice2client.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByIdIn(List<Long> optionIds);
}

