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
            return firstVerse(cast.get(0).getName()) + verseSeparator() + lastVerse(cast.get(1));
        }

        return NO_LYRICS;
    }

    private static String verseSeparator() {
        return "\n";
    }

    private static String firstVerse(String animal) {
        return swallowedLyric(animal, PERIOD) + dontKnowWhyLyric(animal);
    }

    private static String lastVerse(Animal animal) {
        return swallowedLyric(animal.getName(), ELLIPSES) + animal.getBehavior();
    }

    private static String swallowedLyric(String animal, String punctuation) {
        return String.format("There was an old lady who swallowed a %s%s\n", animal, punctuation);
    }

    private static String dontKnowWhyLyric(String animal) {
        return String.format("I don't know why she swallowed a %s - perhaps she'll die!\n", animal);
    }

    private static boolean noCastMembers(List<Animal> cast) {
        return cast == null || cast.size() == 0;
    }

}
