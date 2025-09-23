package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.graphql.model.Starship;

@Repository
public class StarshipRepository {
    private final List<Starship> starships = new ArrayList<>();

    public List<Starship> findAll() {
        return starships;
    }

    public Starship findById(String id) {
        return starships.stream()
                .filter(s -> String.valueOf(s.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Starship starship) {
        starships.add(starship);
    }

    public void update(Starship starship) {
        for (int i = 0; i < starships.size(); i++) {
            if (String.valueOf(starships.get(i).getId()).equals(String.valueOf(starship.getId()))) {
                starships.set(i, starship);
                return;
            }
        }
        save(starship);
    }

    public void delete(String id) {
        starships.removeIf(s -> String.valueOf(s.getId()).equals(id));
    }
}
