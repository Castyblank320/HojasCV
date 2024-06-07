/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hojascv.models;

/**
 *
 * @author user
 */
public class CV{
    private Person person;
    private String general="";
    private String experience="";
    private String Skills="";
    
    public CV(Person person){
        this.person = person;
    }
    
    public String getId(){
        return person.getId();
    }
    
    public String getGeneral() {
        return general;
    }
    
    public void setGeneral(String general) {
        this.general = general;
    }

    public Person getPerson() {
        return person;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String Skills) {
        this.Skills = Skills;
    }
    
}
