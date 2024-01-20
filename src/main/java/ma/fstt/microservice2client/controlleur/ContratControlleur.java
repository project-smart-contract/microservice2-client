
package ma.fstt.microservice2client.controlleur;

import ma.fstt.microservice2client.entity.Contrat;
import ma.fstt.microservice2client.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET} ,path = "/client")
public class ContratControlleur {

    @Autowired
    private ContratService contratService;

//    @PostMapping("/create")
//    public Contrat createContract(@RequestBody Contrat contrat) {
//        return contratService.createContract(contrat);
//    }


    @GetMapping("")
    public String hello(){return "hello";}
}


