package com.autoapi.questions;

import com.autoapi.models.characters.SingleCharacterResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetCharacterLocationName implements Question {
    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(SingleCharacterResponse.class).getLocation().getName();
    }
}
