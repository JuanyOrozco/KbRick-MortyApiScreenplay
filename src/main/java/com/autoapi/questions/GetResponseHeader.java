package com.autoapi.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetResponseHeader implements Question {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().contentType();
    }
}
