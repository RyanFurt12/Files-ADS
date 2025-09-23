package br.edu.ifsp.graphql.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Droid implements Character {
    private String id;
    private String name;
    private List<Episode> appearsIn;
    private List<Character> friends;
    private String primaryFunction;
}
