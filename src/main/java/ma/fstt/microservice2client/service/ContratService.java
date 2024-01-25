// Service
package ma.fstt.microservice2client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.entity.Section;
import ma.fstt.microservice2client.entity.Vehicule;
import ma.fstt.microservice2client.repository.ContratRepository;
import ma.fstt.microservice2client.repository.SectionRepository;
import ma.fstt.microservice2client.repository.*;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ma.fstt.microservice2client.entity.Client;

@Service
public class ContratService {

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private ClientRepository clientRepository;


    public Contrat ajouterContrat(Contrat contrat, int idClient) {
        contrat.setIdClient(idClient);
        return contratRepository.save(contrat);
    }
    public Contrat activerContrat(int id) {
        Contrat contrat = contratRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contrat"));
        contrat.setIsActive(!contrat.getIsActive());
        return contratRepository.save(contrat);
    }



    public Section ajouterSection(Section section) {


        return sectionRepository.save(section);
    }

//    @KafkaListener(topics = "client-info", groupId = "user-group")
//    public void listen(String message) {
//        System.out.println("Received message: " + message);}

//    @KafkaListener(topics = "client-info", groupId = "user-group")
//    public void listen(String message) {
//        System.out.println("Received message: " + message);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            Client client = mapper.readValue(message, Client.class);
//            Client clientEntity = new Client();
//            clientEntity.setId(client.getId());
//            clientEntity.setEmail(client.getEmail());
//            clientEntity.setPassword(client.getPassword());
//            clientEntity.setNomSoc(client.getNomSoc());
//            clientEntity.setNumSocie(client.getNumSocie());
//            clientEntity.setPrenom(client.getPrenom());
//            clientEntity.setNom(client.getNom());
//            clientEntity.setNumPermis(client.getNumPermis());
//            clientEntity.setCin(client.getCin());
//            clientEntity.setAdresse(client.getAdresse());
//            clientEntity.setDateNaissance(client.getDateNaissance());
//            clientEntity.setNumeroTelephone(client.getNumeroTelephone());
//
//            clientRepository.save(clientEntity);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//



    @KafkaListener(topics = "formule-info", groupId = "user-group")
    public void receiveFormule(String formuleJson) {
        System.out.println("Received message: " + formuleJson);
        //ObjectMapper mapper = new ObjectMapper();

//  try {
//            Client client = mapper.readValue(formuleJson, Client.class);
//            Client clientEntity = new Client();
//            clientEntity.setId(client.getId());
//            clientEntity.setEmail(client.getEmail());
//            clientEntity.setPassword(client.getPassword());
//            clientEntity.setNomSoc(client.getNomSoc());
//            clientEntity.setNumSocie(client.getNumSocie());
//            clientEntity.setPrenom(client.getPrenom());
//            clientEntity.setNom(client.getNom());
//            clientEntity.setNumPermis(client.getNumPermis());
//            clientEntity.setCin(client.getCin());
//            clientEntity.setAdresse(client.getAdresse());
//            clientEntity.setDateNaissance(client.getDateNaissance());
//            clientEntity.setNumeroTelephone(client.getNumeroTelephone());
//
//            clientRepository.save(clientEntity);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }

    @Autowired
    private VehiculeRepository vehiculeRepository;
    public Vehicule ajouterVehicule(Vehicule vehicule, int idClient) {
        vehicule.setIdClient(idClient);
        return vehiculeRepository.save(vehicule);
    }
    public Map<String, Object> getContratAndVehiculeByIdClient(int idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        List<Contrat> contrats = contratRepository.findByIdClient(idClient);
        List<Vehicule> vehicules = vehiculeRepository.findByIdClient(idClient);
        Map<String, Object> result = new HashMap<>();
        result.put("client", client);
        result.put("contrats", contrats);
        //result.put("vehicules", vehicules);
        return result;
    }

//    @Autowired
//    private ContratRepository contratRepository;
//    @Autowired
//    private SectionRepository sectionRepository;
//
//    public Contrat ajouterContrat(Contrat contrat) {
//        return contratRepository.save(contrat);
//    }
//
//
//    public Section ajouterSection(Section section) {
//        return sectionRepository.save(section);
//    }
//
//
//    @KafkaListener(topics = "client-info", groupId = "user-group")
//    public void listen(String message) {
//        System.out.println("Received message: " + message);}
//
//    @Autowired
//    private VehiculeRepository vehiculeRepository;
//
//    public Vehicule ajouterVehicule(Vehicule vehicule) {
//
//        return vehiculeRepository.save(vehicule);
//    }

    // Traitez le message reçu
        // Par exemple, vous pouvez convertir le message JSON en un objet UserCredential
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            UserCredential userCredential = objectMapper.readValue(message, UserCredential.class);
//            // Faites quelque chose avec l'objet UserCredential
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException("Failed to convert JSON to UserCredential", e);
//        }
   // }


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


}



