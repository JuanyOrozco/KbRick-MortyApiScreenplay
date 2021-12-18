package com.autoapi.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class getCharacter implements Task {



    public getCharacter(){

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/character").
                        with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }


    public static Performable all(){
        return instrumented(getCharacter.class);
    }
}
