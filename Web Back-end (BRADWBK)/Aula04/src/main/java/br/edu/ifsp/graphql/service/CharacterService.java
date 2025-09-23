package br.edu.ifsp.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.DroidRepository;
import br.edu.ifsp.graphql.repository.HumanRepository;

@Service
public class CharacterService {

    private final HumanRepository humanRepository;
    private final DroidRepository droidRepository;

    public CharacterService(HumanRepository humanRepository, DroidRepository droidRepository) {
        this.humanRepository = humanRepository;
        this.droidRepository = droidRepository;
    }

    public Character findCharacterById(String id) {
        Human h = humanRepository.findById(id);
        if (h != null) return h;
        Droid d = droidRepository.findById(id);
        if (d != null) return d;
        return null;
    }

    public Character addFriend(String characterId, String friendId) {
        Character character = findCharacterById(characterId);
        Character friend = findCharacterById(friendId);
        if (character == null || friend == null) {
            return null;
        }

        if (character instanceof Human) {
            Human h = (Human) character;
            List<Character> friends = h.getFriends() == null ? new ArrayList<>() : new ArrayList<>(h.getFriends());
            boolean exists = friends.stream().anyMatch(f -> f.getId().equals(friend.getId()));
            if (!exists) {
                friends.add(friend);
                h.setFriends(friends);
                humanRepository.update(h);
            }
            return h;
        } else if (character instanceof Droid) {
            Droid d = (Droid) character;
            List<Character> friends = d.getFriends() == null ? new ArrayList<>() : new ArrayList<>(d.getFriends());
            boolean exists = friends.stream().anyMatch(f -> f.getId().equals(friend.getId()));
            if (!exists) {
                friends.add(friend);
                d.setFriends(friends);
                droidRepository.update(d);
            }
            return d;
        }

        return null;
    }
}
