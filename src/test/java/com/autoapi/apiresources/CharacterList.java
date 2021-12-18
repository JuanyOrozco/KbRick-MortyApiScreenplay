package com.autoapi.apiresources;

public enum CharacterList {

    Rick("1"),
    Morty("2"),
    Summer("3"),
    Beth("4"),
    Jerry("5");

    private String id;

    CharacterList(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
