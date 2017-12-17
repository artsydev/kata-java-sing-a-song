package com.github.artsydev;


import java.util.List;


public class SongWriter {

    private static final String NO_LYRICS = "";
    private static final String ELIPSES = "...";
    private static final String PERIOD = ".";

    public static String lyricsFor(List<CastMember> cast) {
        if (noCastMembers(cast)) {
            return NO_LYRICS;
        }

        if (cast.size() == 1) {
            return firstVerse(cast.get(0).getAnimal());
        } else if (cast.size() == 2) {
            return firstVerse(cast.get(0).getAnimal()) + lastVerse(cast.get(1));
        }

        return NO_LYRICS;
    }

    private static String firstVerse(String animal) {
        return oldLadySwallowed(animal, PERIOD) + dontKnowWhySheSwallowed(animal);
    }

    private static String lastVerse(CastMember cast) {
        return oldLadySwallowed(cast.getAnimal(), ELIPSES) + cast.getRhyme();
    }

    private static String oldLadySwallowed(String animal, String punctuation) {
        return "There was an old lady who swallowed a " + animal + punctuation + "\n";
    }

    private static String dontKnowWhySheSwallowed(String animal) {
        return "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n";
    }

    private static boolean noCastMembers(List<CastMember> cast) {
        return cast == null || cast.size() == 0;
    }

}
