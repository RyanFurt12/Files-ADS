package br.edu.ifsp.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.HumanRepository;

@Service
public class HumanService {

    private final HumanRepository humanRepository;

    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public List<Human> findAllHumans() {
        return humanRepository.findAll();
    }

    public Human findHumanById(String id) {
        return humanRepository.findById(id);
    }

    public Human createHuman(String id, String name, Double height) {
        Human human = new Human(id, name, List.of(), new ArrayList<>(), height == null ? 0.0 : height);
        humanRepository.save(human);
        return human;
    }

    public void deleteHuman(String id) {
        humanRepository.delete(id);
    }

    public void updateHuman(Human human) {
        humanRepository.update(human);
    }
}
