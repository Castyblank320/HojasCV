/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hojascv.infrastructure;

import com.mycompany.hojascv.models.CV;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class JSON {
    final java.lang.reflect.Type typeSave = new TypeToken<List<CV>>() {
    }.getType();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String path;
    
    public JSON(String path){
        this.path = path;
    }
    
    public ArrayList<CV> getSave() {
        try {
            ArrayList<CV> CVs = new ArrayList<CV>();
            Gson gson = new GsonBuilder().create();
            FileReader fileReader = new FileReader(this.path);

            java.lang.reflect.Type typeListProducts = new TypeToken<List<CV>>() {
            }.getType();

            CVs = gson.fromJson(fileReader, typeListProducts);

            return CVs;

        } catch (Exception e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }

        return new ArrayList<CV>();
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void saveCV(CV cv){
        List<CV> save = this.getSave();
        save.add(cv);
        this.save(save);
    }
    
    public void save(List<CV> save) {
        try (FileWriter fileWriter = new FileWriter(this.path)) {
            String json = gson.toJson(save);
            fileWriter.write(json);
            System.out.println("Lista guardada en " + fileWriter.getEncoding());
            fileWriter.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
