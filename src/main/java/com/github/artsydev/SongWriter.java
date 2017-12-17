package com.github.artsydev;


import java.util.List;


public class SongWriter {

    private static final String NO_LYRICS = "";
    private static final String ELLIPSES = "...";
    private static final String PERIOD = ".";

    public static String lyricsFor(List<Animal> animalList) {
        if (noAnimals(animalList)) {
            return NO_LYRICS;
        }

        if (animalList.size() == 1) {
            return swallowedLyric(animalList.get(0), PERIOD);
        } else if (animalList.size() == 2) {
            return swallowedLyric(animalList.get(0), PERIOD) +
                   verseSeparator() +
                   swallowedLyric(animalList.get(1), ELLIPSES);
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


    private static boolean noAnimals(List<Animal> animals) {
        return animals == null || animals.size() == 0;
    }

}
