package com.springannot.example.SpringBook;

public class Genre {
    private String genre;

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return genre;
    }
}
