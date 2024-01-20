// Service
package ma.fstt.microservice2client.service;

import jakarta.transaction.Transactional;
import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.entity.Section;
import ma.fstt.microservice2client.entity.Vehicule;
import ma.fstt.microservice2client.repository.ContratRepository;
import ma.fstt.microservice2client.repository.SectionRepository;
import ma.fstt.microservice2client.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private SectionRepository sectionRepository;

    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }


    public Section ajouterSection(Section section) {
        return sectionRepository.save(section);
    }


//    public Contrat createContract(Contrat contrat) {
//
//        for (Section section : contrat.getSections()) {
//            sectionRepository.save(section);
//        }
//        for (Vehicule vehicule : contrat.getVehicules()) {
//            vehiculeRepository.save(vehicule);
//        }
//
//        return contratRepository.save(contrat);
//    }

//    public Contrat createContract(Contrat contrat) {
//        // Sauvegardez d'abord le contrat
//        contratRepository.save(contrat);
//
//        // Ensuite, sauvegardez les sections
//        for (Section section : contrat.getSections()) {
//            sectionRepository.save(section);
//        }
//
//        // Enfin, sauvegardez les véhicules
//        for (Vehicule vehicule : contrat.getVehicules()) {
//            vehiculeRepository.save(vehicule);
//        }
//
//        return contrat;
//    }




//        public Contrat createContract(Contrat contrat) {
//            // Supposez que vous ayez déjà les ID des sections et des véhicules que vous souhaitez associer.
//            List<Section> sections = sectionRepository.findAllById(contrat.getSections().stream().map(Section::getId).collect(Collectors.toList()));
//            List<Vehicule> vehicules = vehiculeRepository.findAllById(contrat.getVehicules().stream().map(Vehicule::getId).collect(Collectors.toList()));
//
//            contrat.setSections(sections);
//            contrat.setVehicules(vehicules);
//
//            return contratRepository.save(contrat);
//        }

//    public Contrat createContract(Contrat contrat) {
//        List<Section> sections = createSections(contrat.getSections());
//        List<Vehicule> vehicules = createVehicules(contrat.getVehicules());
//
//        contrat.setSections(sections);
//        contrat.setVehicules(vehicules);
//
//        return contratRepository.save(contrat);
//    }
//
//    public Section createSection(Section section) {
//        // Enregistrez la section séparément et retournez-la.
//        return sectionRepository.save(section);
//    }
//
//    private List<Section> createSections(List<Section> sections) {
//        // Enregistrez les sections séparément et retournez la liste associée.
//        return sectionRepository.saveAll(sections);
//    }
//
//    private List<Vehicule> createVehicules(List<Vehicule> vehicules) {
//        // Enregistrez les véhicules séparément et retournez la liste associée.
//        return vehiculeRepository.saveAll(vehicules);
//    }

//    public Contrat createContractWithSectionsAndVehicles(Contrat contrat ) {
//        return contratRepository.save(contrat);
//
//    }
//@Transactional
//public Contrat createContractWithSectionsAndVehicles(Contrat contrat ) {
//    for (Section section : contrat.getSections()) {
//        section.setContrat(contrat);
//
//    }
//    for (Vehicule vehicule : contrat.getVehicules()) {
//        vehicule.setContrat(contrat);
//
//    }
//    return contratRepository.save(contrat);
//}

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

}



