package pro.ivashchuk.moviesadvisor.domain;

import javax.persistence.Entity;

@Entity
public class Actor {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Actor() {
    }
}
