// Service
package ma.fstt.microservice2client.service;

import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.entity.Section;
import ma.fstt.microservice2client.entity.Vehicule;
import ma.fstt.microservice2client.repository.ContratRepository;
import ma.fstt.microservice2client.repository.SectionRepository;
import ma.fstt.microservice2client.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Contrat createContract(Contrat contrat) {

        for (Section section : contrat.getSections()) {
            sectionRepository.save(section);
        }
        for (Vehicule vehicule : contrat.getVehicules()) {
            vehiculeRepository.save(vehicule);
        }

        return contratRepository.save(contrat);
    }
}
