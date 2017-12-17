package com.github.artsydev;


import java.util.List;


public class SongWriter {

    private static final String NO_LYRICS = "";
    private static final String ELLIPSES = "...";
    private static final String PERIOD = ".";

    public static String lyricsFor(List<Animal> cast) {
        if (noCastMembers(cast)) {
            return NO_LYRICS;
        }

        if (cast.size() == 1) {
            return firstVerse(cast.get(0).getName());
        } else if (cast.size() == 2) {
            return firstVerse(cast.get(0).getName()) + lastVerse(cast.get(1));
        }

        return NO_LYRICS;
    }

    private static String firstVerse(String animal) {
        return oldLadySwallowed(animal, PERIOD) + dontKnowWhySheSwallowed(animal);
    }

    private static String lastVerse(Animal cast) {
        return oldLadySwallowed(cast.getName(), ELLIPSES) + cast.getBehavior();
    }

    private static String oldLadySwallowed(String animal, String punctuation) {
        return "There was an old lady who swallowed a " + animal + punctuation + "\n";
    }

    private static String dontKnowWhySheSwallowed(String animal) {
        return "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n";
    }

    private static boolean noCastMembers(List<Animal> cast) {
        return cast == null || cast.size() == 0;
    }

}
