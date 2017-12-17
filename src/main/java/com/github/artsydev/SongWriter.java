package com.github.artsydev;


import java.util.List;


public class SongWriter {

    private static final String NO_LYRICS = "";

    public static String lyricsFor(List<CastMember> cast) {
        if (noCastMembers(cast)) {
            return NO_LYRICS;
        }

        if (cast.size() == 1) {
            return prologue(cast.get(0).getAnimal());
        }

        return NO_LYRICS;
    }

    private static String prologue(String animal) {
        return "There was an old lady who swallowed a " + animal + ".\n"
                + perhapsSheWillDie(animal);
    }

    private static String perhapsSheWillDie(String animal) {
        return "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n";
    }

    private static boolean noCastMembers(List<CastMember> cast) {
        return cast == null || cast.size() == 0;
    }

}
