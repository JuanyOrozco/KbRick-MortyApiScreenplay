package com.autoapi.apiresources;

public class ApiUtils {

    public int getCharId(String name) {
        CharacterList charName =CharacterList.valueOf(name);
        int charId = Integer.parseInt(charName.getId());
        return charId;
    }
}
