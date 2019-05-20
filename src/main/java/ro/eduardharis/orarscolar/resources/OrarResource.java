package ro.eduardharis.orarscolar.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.eduardharis.orarscolar.entities.Curs;
import ro.eduardharis.orarscolar.repositories.CursRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Transactional
@CrossOrigin
public class OrarResource {

    private CursRepository cursRepository;

    @Autowired
    public OrarResource(final CursRepository cursRepository) {
        this.cursRepository = cursRepository;
    }

    @GetMapping("/orar/daysOfWeek")
    public List<String> getDaysOfWeek() {
        return Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    }

    @GetMapping("/orar/text/{student}/{dayOfWeek}")
    public String getOrarText(@PathVariable("student") String student, @PathVariable("dayOfWeek") String dayOfWeek) {

        String orar = cursRepository.findAllByDayOfWeekAndStudent(dayOfWeek, student)
                .stream()
                .map(Curs::getMaterie)
                .collect(Collectors.joining(", "));

        return String.format("Your time table for %s is %s", dayOfWeek, orar);
    }

    @GetMapping("/orar/{student}/{dayOfWeek}")
    public List<String> getOrar(@PathVariable("student") String student, @PathVariable("dayOfWeek") String dayOfWeek) {
        return cursRepository.findAllByDayOfWeekAndStudent(dayOfWeek, student)
                .stream()
                .map(Curs::getMaterie)
                .collect(Collectors.toList());
    }

    @PostMapping("/orar/{student}")
    public ResponseEntity<Long> addCurs(@PathVariable String student, @RequestBody Curs curs) {

        curs.setStudent(student);
        Curs saved = cursRepository.save(curs);
        return new ResponseEntity<>(saved.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/orar/{student}")
    public ResponseEntity<String> removeCurs(@PathVariable String student, @RequestBody Curs curs) {
        curs.setStudent(student);
        cursRepository.removeAllByDayOfWeekAndMaterieAndStudent(curs.getDayOfWeek(), curs.getMaterie(), student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
