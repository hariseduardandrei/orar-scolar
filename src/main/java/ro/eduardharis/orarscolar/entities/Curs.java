package ro.eduardharis.orarscolar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Curs {

    @Id
    @GeneratedValue
    private Long id;

    private String student;

    private String dayOfWeek;

    private String materie;

    public Curs() {
    }

    public Curs(final String student, final String dayOfWeek, final String materie) {
        this.student = student;
        this.dayOfWeek = dayOfWeek;
        this.materie = materie;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(final String student) {
        this.student = student;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(final String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(final String materie) {
        this.materie = materie;
    }
}
