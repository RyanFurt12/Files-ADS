package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.graphql.model.Droid;

@Repository
public class DroidRepository {
    private final List<Droid> droids = new ArrayList<>();

    public List<Droid> findAll() {
        return droids;
    }

    public Droid findById(String id) {
        return droids.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Droid droid) {
        droids.add(droid);
    }

    public void update(Droid droid) {
        for (int i = 0; i < droids.size(); i++) {
            if (droids.get(i).getId().equals(droid.getId())) {
                droids.set(i, droid);
                return;
            }
        }
        save(droid);
    }

    public void delete(String id) {
        droids.removeIf(d -> d.getId().equals(id));
    }
}
