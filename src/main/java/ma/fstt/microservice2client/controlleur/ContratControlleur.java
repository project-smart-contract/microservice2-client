
package ma.fstt.microservice2client.controlleur;

import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.entity.Option;
import ma.fstt.microservice2client.entity.Section;
import ma.fstt.microservice2client.entity.Vehicule;
import ma.fstt.microservice2client.service.ContratService;
import ma.fstt.microservice2client.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, path = "/client")
public class ContratControlleur {

    @Autowired
    private ContratService contratService;
    @Autowired
    private SectionService sectionService;

    //@PostMapping("/create")
//public Contrat createContract(@RequestBody Contrat contrat) {
//
//    return contratService.createContractWithSectionsAndVehicles(contrat);
//}
//    @PostMapping("/ajouterContrat")
//    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
//        int idClient = contrat.getIdClient();
//        return contratService.ajouterContrat(contrat, idClient);
//    }

    @PutMapping("/activerContrat/{id}")
    public ResponseEntity<Contrat> activerContrat(@PathVariable(value = "id") int contratId) {
        Contrat contrat = contratService.activerContrat(contratId);
        return ResponseEntity.ok().body(contrat);
    }
    @PostMapping("/ajouterContrat")
    public Contrat ajouterContratF(@RequestBody Contrat contrat) {
        int idClient = contrat.getIdClient();
        Long idFormule = contrat.getIdFormule();
        List<Long> optionList = contrat.getOptionFormules();
        return contratService.ajouterContratF(contrat, idClient,idFormule,optionList);
    }


    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        int idClient = vehicule.getIdClient();
        return contratService.ajouterVehicule(vehicule, idClient);
    }


    @PostMapping("/ajouterSection")
    public Section ajouterSection(@RequestBody Section section) {
        return contratService.ajouterSection(section);
    }

    @PostMapping("/initialiserSections")
    public void initialiserSections() {

        sectionService.initialiserSections();
    }

    @GetMapping("/getcontratbyidClient/{idClient}")
    public ResponseEntity<Map<String, Object>> getContratAndVehiculeByIdClient(@PathVariable int idClient) {
        Map<String, Object> result = contratService.getContratAndVehiculeByIdClient(idClient);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
//    @PostMapping("/create")
//    public Contrat createContract(@RequestBody Contrat contrat) {
//        return contratService.createContract(contrat);
//    }

//    @PostMapping("/create-section")
//    public Section createSection(@RequestBody Section section) {
//        return contratService.createSection(section);
//    }


    @GetMapping("")
    public String hello() {
        return "hello";
    }
}


