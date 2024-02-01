package org.example.topic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Topic {

    @Id
    private String id;
    private String name;

    public Topic() {

    }
    public Topic (String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setid(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
