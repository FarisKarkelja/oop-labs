package week10;

import java.util.*;

public class Song {
    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", Artist: " + artist + ", Genre: " + genre;
    }
}

class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(String targetGenre) {
        this.playlist = new ArrayList<>();
        this.targetGenre = targetGenre;
        this.currentIndex = 0;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }

    public String getTargetGenre() {
        return targetGenre;
    }

    public void setTargetGenre(String targetGenre) {
        this.targetGenre = targetGenre;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < playlist.size()) {
            if (playlist.get(currentIndex).getGenre().equals(targetGenre)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return playlist.get(currentIndex++);
    }
}

class MainCall {
    public static void main(String[] args){
        Song song1 = new Song("Song A", "Artist 1", "Pop");
        Song song2 = new Song("Song B", "Artist 2", "Rock");
        Song song3 = new Song("Song C", "Artist 3", "Pop");
        Song song4 = new Song("Song D", "Artist 4", "Jazz");
        Song song5 = new Song("Song E", "Artist 5", "Pop");

        List<Song> playlist = new ArrayList<>();
        playlist.add(song1);
        playlist.add(song2);
        playlist.add(song3);
        playlist.add(song4);
        playlist.add(song5);

        GenreFilterIterator iterator = new GenreFilterIterator("Pop");
        iterator.setPlaylist(playlist);

        System.out.println("Songs of genre " + iterator.getTargetGenre() + ":");
        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println(song);
        }
    }
}