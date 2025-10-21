package eni.tpbasket.controllers;

import eni.tpbasket.models.Player;
import eni.tpbasket.repository.InMemoryPlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final InMemoryPlayerRepository repository;

    public PlayerController(InMemoryPlayerRepository repository) {
        this.repository = repository;
    }

    // Lister tous les joueurs (simulation DB en mémoire)
    @GetMapping
    public List<Player> listAll() {
        return repository.findAll();
    }
}
