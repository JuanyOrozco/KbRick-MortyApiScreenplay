package com.autoapi.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class getCharacterByName implements Task {

    private int id;


    public getCharacterByName(int id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/character/"+id).
                        with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }
    public static Performable withId(int id){
        return instrumented(getCharacter.class, id);
    }

}
