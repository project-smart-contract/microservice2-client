package ma.fstt.microservice2client.restController;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET} , path = "/service2")
public class ExchangeRestController {

    @GetMapping("dth/{amount}")
    public Double dtoh(@PathVariable Double amount){

        return amount * 9.8 ;
    }

    @GetMapping("/{msg}")
    public String Service2(@PathVariable String msg){

        return "Microservice 2 AFTER DOCKERFILE: "+ msg;
    }
}
