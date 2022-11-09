package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Tool implements CatalogItem{
    private String id;
    private String type;
    private String manufacturer ;
    private int count;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCount() {
        return count;
    }

    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }
    public String toString(){
        return "";
    }
    @Override
    public boolean matchesName(String searchStr) {
        if(type.toLowerCase().contains(searchStr.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        if(manufacturer.toLowerCase().contains(searchStr.toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try {
            FileStorageService.writeContentsToFile(
                    this.toString()
                    + " ," + LocalDate.now()
                    +" , " +  LocalTime.now() ,
                    "src/main/resources/logs/tools",
                    true);
        } catch (FileStorageException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
