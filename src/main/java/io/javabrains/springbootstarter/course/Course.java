package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by adrake on 6/16/17.
 */
@Entity
public class Course {

    /**
     * No argument constructor so that the object
     * is easier to initialize
     */
    public Course(){

    }

    @Id
    private String id;
    private String name;
    private String description;

    /**
     * TODO: Look at using lazy loading here.  This is a JPA
     *       concept...
     */
    @ManyToOne
    private Topic topic;

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param topicId (not required, but added for convenience)
     */
    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
