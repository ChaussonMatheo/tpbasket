package eni.tpbasket.controllers;

import eni.tpbasket.models.Team;
import eni.tpbasket.repository.InMemoryTeamRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final InMemoryTeamRepository repository;

    public TeamController(InMemoryTeamRepository repository) {
        this.repository = repository;
    }

    // Lister toutes les équipes (simulation DB en mémoire)
    @GetMapping
    public List<Team> listAll() {
        return repository.findAll();
    }

    // Récupérer une équipe par son numéro
    @GetMapping("/{number}")
    public ResponseEntity<Team> getByNumber(@PathVariable Integer number) {
        return repository.findByNumber(number)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{name}")


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fe -> errors.put(fe.getField(), fe.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            Team saved = repository.save(team);
            URI location = URI.create("/api/teams/" + saved.getNumber());
            return ResponseEntity.created(location).body(saved);
        } catch (IllegalArgumentException ex) {
            Map<String, String> err = Map.of("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
        }
    }
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> delete(@PathVariable Integer number) {
        return repository.findByNumber(number)
                .map(team -> {
                    repository.delete(team);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}