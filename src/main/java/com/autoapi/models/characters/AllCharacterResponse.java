package com.autoapi.models.characters;

import java.util.List;

public class AllCharacterResponse {

    private Info info;
    private List<Result> results = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
