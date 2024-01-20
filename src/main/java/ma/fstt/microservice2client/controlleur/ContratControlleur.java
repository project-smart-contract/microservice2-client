
package ma.fstt.microservice2client.controlleur;

import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.entity.Section;
import ma.fstt.microservice2client.entity.Vehicule;
import ma.fstt.microservice2client.service.ContratService;
import ma.fstt.microservice2client.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET} ,path = "/client")
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
@PostMapping("/ajouterContrat")
public Contrat ajouterContrat(@RequestBody Contrat contrat) {
    return contratService.ajouterContrat(contrat);
}


    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return contratService.ajouterVehicule(vehicule);
    }



    @PostMapping("/ajouterSection")
    public Section ajouterSection(@RequestBody Section section) {
        return contratService.ajouterSection(section);
    }

    @PostMapping("/initialiserSections")
    public void initialiserSections() {

        sectionService.initialiserSections();
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
    public String hello(){return "hello";}
}


