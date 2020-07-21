package ru.job4j.accident.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accident")
public class Accident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String address;

    public Accident() {
    }

    public Accident(int id, String name, String text, String address) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Accident) {
            Accident accident = (Accident) o;
            return accident.id == this.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 17 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
