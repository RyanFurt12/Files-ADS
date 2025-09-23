package br.edu.ifsp.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.repository.StarshipRepository;

@Service
public class StarshipService {

    private final StarshipRepository starshipRepository;

    public StarshipService(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> findAllStarships() {
        return starshipRepository.findAll();
    }

    public Starship findStarshipById(String id) {
        return starshipRepository.findById(id);
    }

    public Starship createStarship(String id, String name, Double length) {
        int numericId = 0;
        try {
            numericId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            numericId = starshipRepository.findAll().size() + 1;
        }
        Starship ship = new Starship(numericId, name, length == null ? 0.0 : length);
        starshipRepository.save(ship);
        return ship;
    }

    public void updateStarship(Starship starship) {
        starshipRepository.update(starship);
    }

    public void deleteStarship(String id) {
        starshipRepository.delete(id);
    }
}
