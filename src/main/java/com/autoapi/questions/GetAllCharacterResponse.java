package com.autoapi.questions;

import com.autoapi.models.characters.AllCharacterResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetAllCharacterResponse implements Question {

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(AllCharacterResponse.class).getInfo().getCount();
    }


}
