package eni.tpbasket.repository;
import eni.tpbasket.models.Player;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryPlayerRepository {
    private final List<Player> players = new ArrayList<>();

    @PostConstruct
    public void init() {
        players.add(new Player(1, "Dupont", "Jean"));
        players.add(new Player(2, "Martin", "Sophie"));
        players.add(new Player(3, "Durand", "Paul"));
    }

    public List<Player> findAll() {
        return new ArrayList<>(players);
    }
    public Optional<Player> findById(Integer id) {
        return players.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public Player save(Player player) {
        if (findById(player.getId()).isPresent()) {
            throw new IllegalArgumentException("ID de joueur déjà utilisé : " + player.getId());
        }
        players.add(player);
        return player;
    }
    public void delete(Player player) {
        players.remove(player);
    }

}
