package ro.eduardharis.orarscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.eduardharis.orarscolar.entities.Curs;

import java.util.List;

public interface CursRepository extends JpaRepository<Curs, Long> {

    List<Curs> findAllByDayOfWeekAndStudent(String dayOfWeek, String student);

    void removeAllByDayOfWeekAndMaterieAndStudent(String dayOfWeek, String materie, String student);
}
