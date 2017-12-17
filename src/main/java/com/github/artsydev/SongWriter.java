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
            return swallowedLyric(cast.get(0), PERIOD);
        } else if (cast.size() == 2) {
            return swallowedLyric(cast.get(0), PERIOD) +
                   verseSeparator() +
                   swallowedLyric(cast.get(1), ELLIPSES);
        }

        return NO_LYRICS;
    }

    private static String verseSeparator() {
        return "\n\n";
    }

    private static String swallowedLyric(Animal animal, String punctuation) {
        return String.format("There was an old lady who swallowed a %s%s\n%s",
                             animal.getName(),
                             punctuation,
                             animal.getBehavior());
    }


    private static boolean noCastMembers(List<Animal> cast) {
        return cast == null || cast.size() == 0;
    }

}
