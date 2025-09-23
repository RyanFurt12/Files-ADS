package br.edu.ifsp.graphql.model;

import java.util.List;

public interface Character {
    String getId();
    String getName();
    List<Episode> getAppearsIn();
    List<Character> getFriends();
}
