package eni.tpbasket.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Team {

    @NotNull(message = "Le numéro d'équipe est obligatoire")
    private Integer number;

    @NotBlank(message = "Le nom de l'équipe est obligatoire")
    @Size(max = 30, message = "Le nom fait au maximum 30 caractères")
    private String name;

    public Team() {}

    public Team(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}