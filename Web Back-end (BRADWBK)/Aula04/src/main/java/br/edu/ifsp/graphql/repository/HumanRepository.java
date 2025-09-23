package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.graphql.model.Human;

@Repository
public class HumanRepository {
    private final List<Human> humans = new ArrayList<>();

    public List<Human> findAll() {
        return humans;
    }

    public Human findById(String id) {
        return humans.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Human human) {
        humans.add(human);
    }

    public void update(Human human) {
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getId().equals(human.getId())) {
                humans.set(i, human);
                return;
            }
        }
        save(human);
    }

    public void delete(String id) {
        humans.removeIf(h -> h.getId().equals(id));
    }
}
