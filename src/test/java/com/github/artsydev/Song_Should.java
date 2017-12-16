package com.github.artsydev;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;


public class Song_Should {

    @Test public void
    return_the_song_lyrics() {
        String songLyrics = Song.writeSongLyrics();

        assertThat(songLyrics, is(not(emptyString())));
    }

}
