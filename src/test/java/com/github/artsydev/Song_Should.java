package com.github.artsydev;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;


public class Song_Should {

    private static final String SINGLE_ANIMAL_LYRICS =
            "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!";
    private static final String TWO_ANIMALS_LYRICS =
            "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a horse...\n" +
            "...She's dead, of course!";
    private static final String SEVEN_ANIMALS_LYRICS =
            "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a spider;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a bird;\n" +
            "How absurd to swallow a bird.\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cat;\n" +
            "Fancy that to swallow a cat!\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a dog;\n" +
            "What a hog, to swallow a dog!\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cow;\n" +
            "I don't know how she swallowed a cow!\n" +
            "She swallowed the cow to catch the dog,\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a horse...\n" +
            "...She's dead, of course!";
    private static final String ALPHABET_ANIMAL_LYRICS =
            "There was an old lady who swallowed a A.\n"
            + "A behavior!\n"
            + "\n"
            + "There was an old lady who swallowed a B;\n"
            + "B behavior.\n"
            + "She swallowed the B to catch the A;\n"
            + "A behavior!\n"
            + "\n"
            + "There was an old lady who swallowed a C;\n"
            + "C behavior?\n"
            + "She swallowed the C to catch the B,\n"
            + "She swallowed the B to catch the A;\n"
            + "A behavior!\n"
            + "\n"
            + "There was an old lady who swallowed a D;\n"
            + "D behavior!!!\n"
            + "She swallowed the D to catch the C,\n"
            + "She swallowed the C to catch the B,\n"
            + "She swallowed the B to catch the A;\n"
            + "A behavior!\n"
            + "\n"
            + "There was an old lady who swallowed a E...\n"
            + "E behaving badly.";

    private static final Animal FLY = new Animal("fly",
                                                 "I don't know why she swallowed a fly - perhaps she'll die!");
    private static final Animal SPIDER = new Animal("spider",
                                                    "That wriggled and wiggled and tickled inside her.");
    private static final Animal BIRD = new Animal("bird", "How absurd to swallow a bird.");
    private static final Animal CAT = new Animal("cat", "Fancy that to swallow a cat!");
    private static final Animal DOG = new Animal("dog", "What a hog, to swallow a dog!");
    private static final Animal COW = new Animal("cow",
                                                 "I don't know how she swallowed a cow!");
    private static final Animal HORSE = new Animal("horse",
                                                   "...She's dead, of course!");
    private static final Animal A = new Animal("A", "A behavior!");
    private static final Animal B = new Animal("B", "B behavior.");
    private static final Animal C = new Animal("C", "C behavior?");
    private static final Animal D = new Animal("D", "D behavior!!!");
    private static final Animal E = new Animal("E", "E behaving badly.");

    @Test public void
    return_empty_lyrics_if_animal_list_is_null() {
        String songLyrics = Song.lyricsFor(null);

        assertThat(songLyrics, is(emptyString()));
    }

    @Test public void
    return_empty_lyrics_if_animal_list_is_empty() {
        Animal[] animals = {};

        String song = Song.lyricsFor(animals);

        assertThat(song, is(emptyString()));
    }

    @Test public void
    return_one_short_verse_for_a_single_animal() {
        String lyrics = Song.lyricsFor(FLY);

        assertThat(lyrics, is(SINGLE_ANIMAL_LYRICS));
    }

    @Test public void
    return_two_short_verses_for_two_animals() {
        String lyrics = Song.lyricsFor(FLY, HORSE);

        assertThat(lyrics, is(TWO_ANIMALS_LYRICS));
    }

    @Test public void
    return_short_verses_for_first_and_last_with_explanatory_verses_for_other_animals() {
        String lyrics = Song.lyricsFor(FLY, SPIDER, BIRD, CAT, DOG, COW, HORSE);

        assertThat(lyrics, is(SEVEN_ANIMALS_LYRICS));
    }

    @Test public void
    return_short_verses_for_first_and_last_with_explanatory_verses_for_letter_animals() {
        String lyrics = Song.lyricsFor(A, B, C, D, E);

        assertThat(lyrics, is(ALPHABET_ANIMAL_LYRICS));
    }

}
