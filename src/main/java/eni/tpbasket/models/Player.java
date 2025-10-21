package eni.tpbasket.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Player {
    @NotNull(message = "L'id du joueur est obligatoire")
    private Integer id;
    @NotBlank(message = "Le nom du joueur est obligatoire")
    @Size(max = 50, message = "Le nom fait au maximum 50 caractères")
    private String name;
    @NotBlank(message = "Le prénom du joueur est obligatoire")
    @Size(max = 50, message = "Le prénom fait au maximum 50 caractères")
    private String firstName;

    public Player() {}

    public Player(Integer id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
