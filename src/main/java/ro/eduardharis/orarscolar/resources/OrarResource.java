package ro.eduardharis.orarscolar.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrarResource {

    @GetMapping("/orar")
    public String getOrar() {
        String orar = "luni marti miercuri joi vineri";
        return String.format("Orarul tau este %s", orar);
    }
}
