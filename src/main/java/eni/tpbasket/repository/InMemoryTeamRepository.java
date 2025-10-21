package eni.tpbasket.repository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import eni.tpbasket.models.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class InMemoryTeamRepository {

    private final List<Team> teams = new ArrayList<>();

    @PostConstruct
    public void init() {
        // données simulées
        teams.add(new Team(1, "U15F1"));
        teams.add(new Team(2, "U17M1"));
        teams.add(new Team(3, "SeniorsF1"));
    }

    public List<Team> findAll() {
        // retourner une copie pour éviter modifications externes
        return new ArrayList<>(teams);
    }

    public Optional<Team> findByNumber(Integer number) {
        return teams.stream().filter(t -> t.getNumber().equals(number)).findFirst();
    }

    public Team save(Team team) {
        // vérifie unicité du numéro
        if (findByNumber(team.getNumber()).isPresent()) {
            throw new IllegalArgumentException("Numéro d'équipe déjà utilisé : " + team.getNumber());
        }
        teams.add(team);
        return team;
    }
    public void delete(Team team) {
        teams.remove(team);
    }
}
