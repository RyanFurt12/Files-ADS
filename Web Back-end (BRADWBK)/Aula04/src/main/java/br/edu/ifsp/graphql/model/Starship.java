package br.edu.ifsp.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Starship {
    private int id;
    private String name;
    private double length;
}
