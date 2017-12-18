package com.github.artsydev;


public class Song {

    private static final String NO_LYRICS = "";
    private static final String ELLIPSES = "...";
    private static final String PERIOD = ".";
    private static final String SEMICOLON = ";";
    private static final String COMMA = ",";

    public static String lyricsFor(Animal... animalList) {
        return noAnimals(animalList)
               ? NO_LYRICS
               : songLyrics(animalList);
    }

    private static String songLyrics(Animal[] animalList) {
        StringBuilder lyrics = new StringBuilder();

        shortVerse(animalList[0], PERIOD, lyrics);
        explanatoryVerses(animalList, lyrics);
        if (animalList.length > 1) {
            verseSeparator(lyrics);
            shortVerse(animalList[animalList.length - 1], ELLIPSES, lyrics);
        }

        return lyrics.toString();
    }

    private static void shortVerse(Animal animal, String punctuation, StringBuilder lyrics) {
        lyrics.append(String.format("There was an old lady who swallowed a %s%s\n%s",
                                    animal.getName(),
                                    punctuation,
                                    animal.getBehavior()));
    }

    private static void explanatoryVerses(Animal[] animalList, StringBuilder lyrics) {
        int lastAnimalIndex = animalList.length - 1;
        if (dontHaveExplanatoryVerses(lastAnimalIndex)) return;

        for (int currentAnimal = 1; currentAnimal < lastAnimalIndex; currentAnimal++) {
            verseSeparator(lyrics);
            explanatoryLyrics(animalList, currentAnimal, lyrics);
        }
    }

    private static void explanatoryLyrics(Animal[] animals,
                                          int currentAnimal,
                                          StringBuilder lyrics) {
        shortVerse(animals[currentAnimal], SEMICOLON, lyrics);

        for (int i = currentAnimal; i > 1; i--) {
            lyrics.append(swallowLyrics(animals[i], animals[i - 1], COMMA));
        }
        lyrics.append(swallowLyrics(animals[1], animals[0], SEMICOLON));
        lyrics.append(String.format("\n%s", animals[0].getBehavior()));
    }

    private static String swallowLyrics(Animal swallowed, Animal toCatch, String punctuation) {
        return String.format("\nShe swallowed the %s to catch the %s%s",
                             swallowed.getName(),
                             toCatch.getName(),
                             punctuation);
    }

    private static void verseSeparator(StringBuilder lyrics) {
        if (lyrics.length() > 0) {
            lyrics.append("\n\n");
        }
    }

    private static boolean dontHaveExplanatoryVerses(int lastAnimalIndex) {
        return lastAnimalIndex <= 1;
    }

    private static boolean noAnimals(Animal[] animals) {
        return animals == null || animals.length == 0;
    }

}
