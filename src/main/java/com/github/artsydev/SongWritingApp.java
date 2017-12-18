package com.github.artsydev;


public class SongWritingApp {

    public static void main(String[] args) {
        String songLyrics = Song.lyricsFor(null);

        System.out.println(songLyrics);
    }

}
