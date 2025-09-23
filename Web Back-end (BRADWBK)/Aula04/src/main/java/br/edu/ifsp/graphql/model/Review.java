package br.edu.ifsp.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Review {
    private int stars;
    private String commentary;
}
