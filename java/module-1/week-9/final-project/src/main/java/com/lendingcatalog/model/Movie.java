package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Movie implements CatalogItem{
    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public Movie(String name, String director , LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }
    public String toString(){
        return "";
    }

    @Override
    public boolean matchesName(String searchStr) {
        if(name.toLowerCase().contains(searchStr.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if(director.toLowerCase().contains(searchStr.toLowerCase())){
            return true;

        }

        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if(releaseDate.getYear() == searchYear){
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(this.toString() +
                    " ," + LocalDate.now() +" , "
                    +  LocalTime.now() ,
                    "src/main/resources/logs/movies", true);
        } catch (FileStorageException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
