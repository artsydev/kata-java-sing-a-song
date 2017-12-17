package com.github.artsydev;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;


public class Song_Should {

    private static final String SINGLE_CAST_MEMBER_LYRICS =
            "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!";
    private static final String TWO_CAST_MEMBERS_LYRICS =
            "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a horse...\n" +
            "...She's dead, of course!";
    private static final String WHOLE_CAST_LYRICS =
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

    @Test public void
    return_empty_lyrics_if_the_cast_is_null() {
        String songLyrics = SongWriter.lyricsFor(null);

        assertThat(songLyrics, is(emptyString()));
    }

    @Test public void
    return_empty_lyrics_if_the_cast_is_empty() {
        List<Animal> cast = new ArrayList<>();

        String song = SongWriter.lyricsFor(cast);

        assertThat(song, is(emptyString()));
    }

    @Test public void
    return_the_lyrics_for_a_single_cast_member() {
        List<Animal> flyCast = new ArrayList<>();
        flyCast.add(FLY);

        String lyrics = SongWriter.lyricsFor(flyCast);

        assertThat(lyrics, is(SINGLE_CAST_MEMBER_LYRICS));
    }

    @Test public void
    return_the_lyrics_for_two_cast_members() {
        List<Animal> twoMemberCast = new ArrayList<>();
        twoMemberCast.add(FLY);
        twoMemberCast.add(HORSE);

        String lyrics = SongWriter.lyricsFor(twoMemberCast);

        assertThat(lyrics, is(TWO_CAST_MEMBERS_LYRICS));
    }

    @Test public void
    return_the_lyrics_for_the_whole_cast() {
        List<Animal> wholeCast = new ArrayList<>();
        wholeCast.add(FLY);
        wholeCast.add(SPIDER);
        wholeCast.add(BIRD);
        wholeCast.add(CAT);
        wholeCast.add(DOG);
        wholeCast.add(COW);
        wholeCast.add(HORSE);

        String lyrics = SongWriter.lyricsFor(wholeCast);

        assertThat(lyrics, is(WHOLE_CAST_LYRICS));
        assertThat(lyrics, is(WHOLE_CAST_LYRICS));
    }

}
