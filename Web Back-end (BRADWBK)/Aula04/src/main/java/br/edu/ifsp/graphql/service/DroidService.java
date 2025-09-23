package br.edu.ifsp.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.repository.DroidRepository;

@Service
public class DroidService {

    private final DroidRepository droidRepository;

    public DroidService(DroidRepository droidRepository) {
        this.droidRepository = droidRepository;
    }

    public List<Droid> findAllDroids() {
        return droidRepository.findAll();
    }

    public Droid findDroidById(String id) {
        return droidRepository.findById(id);
    }

    public Droid createDroid(String id, String name, String primaryFunction) {
        Droid droid = new Droid(id, name, List.of(), new ArrayList<>(), primaryFunction);
        droidRepository.save(droid);
        return droid;
    }

    public void updateDroid(Droid droid) {
        droidRepository.update(droid);
    }

    public void deleteDroid(String id) {
        droidRepository.delete(id);
    }
}
