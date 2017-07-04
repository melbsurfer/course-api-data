package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by adrake on 6/16/17.
 */
@Entity
public class Topic {

    /**
     * No argument constructor so that the object
     * is easier to initialize
     */
    public Topic(){

    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param description
     */
    public Topic(String id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    @Id
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

}
