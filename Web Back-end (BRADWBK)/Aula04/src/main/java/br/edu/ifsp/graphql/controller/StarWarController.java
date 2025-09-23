package br.edu.ifsp.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.service.CharacterService;
import br.edu.ifsp.graphql.service.DroidService;
import br.edu.ifsp.graphql.service.HeroService;
import br.edu.ifsp.graphql.service.HumanService;
import br.edu.ifsp.graphql.service.ReviewService;
import br.edu.ifsp.graphql.service.SearchService;
import br.edu.ifsp.graphql.service.StarshipService;

@Controller
public class StarWarController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private DroidService droidService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private HumanService humanService;

    @Autowired
    private StarshipService starshipService;

    @Autowired
    private CharacterService characterService;

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return heroService.getHero(episode);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return droidService.findDroidById(id);
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        return searchService.search(text);
    }

    @QueryMapping
    public List<Human> humans() {
        return humanService.findAllHumans();
    }

    @QueryMapping
    public List<Starship> starships() {
        return starshipService.findAllStarships();
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return characterService.findCharacterById(id);
    }

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return reviewService.createReview(review);
    }

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Float height) {
        return humanService.createHuman(id, name, height == null ? null : Double.valueOf(height));
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        return droidService.createDroid(id, name, primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument String id, @Argument String name, @Argument Float length) {
        return starshipService.createStarship(id, name, length == null ? null : Double.valueOf(length));
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        return characterService.addFriend(characterId, friendId);
    }
}
