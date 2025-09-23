package br.edu.ifsp.graphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.repository.DroidRepository;
import br.edu.ifsp.graphql.repository.HumanRepository;
import br.edu.ifsp.graphql.repository.StarshipRepository;

@Service
public class SearchService {

    private final HumanRepository humanRepository;
    private final DroidRepository droidRepository;
    private final StarshipRepository starshipRepository;

    public SearchService(HumanRepository humanRepository, DroidRepository droidRepository,
            StarshipRepository starshipRepository) {
        this.humanRepository = humanRepository;
        this.droidRepository = droidRepository;
        this.starshipRepository = starshipRepository;
    }

    public List<Object> search(String text) {
        if (text == null || text.isBlank()) {
            List<Object> all = new ArrayList<>();
            all.addAll(humanRepository.findAll());
            all.addAll(droidRepository.findAll());
            all.addAll(starshipRepository.findAll());
            return all;
        }

        String q = text.toLowerCase(Locale.ROOT);
        List<Object> results = new ArrayList<>();
        results.addAll(humanRepository.findAll().stream()
                .filter(h -> h.getName().toLowerCase(Locale.ROOT).contains(q))
                .collect(Collectors.toList()));
        results.addAll(droidRepository.findAll().stream()
                .filter(d -> d.getName().toLowerCase(Locale.ROOT).contains(q))
                .collect(Collectors.toList()));
        results.addAll(starshipRepository.findAll().stream()
                .filter(s -> s.getName().toLowerCase(Locale.ROOT).contains(q))
                .collect(Collectors.toList()));
        return results;
    }
}
