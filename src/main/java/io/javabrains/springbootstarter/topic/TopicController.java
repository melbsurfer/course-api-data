package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adrake on 6/16/17.
 */

/**
 * Automatically returns as JSON
 */
@RestController
public class TopicController {

    /**
     * Dependency injection for the CourseService
     */
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/test")
    public String getTestString(){
        return "Hello from the test!";
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    /**
     * Map this method to any request that is a POST on /topics
     * When the POST occurs execute the addTopic method.  The addTopic method
     * gets the POST body, converts it into a Course instance, and add it
     * to the list in the CourseService.
     *
     * @RequestBody tells Spring MVC that the request payload is going to
     * contain a JSON representation of the Course instance, and we want it
     * to take that RequestBody, and convert it into a Course instance, and pass
     * it to that addTopic
     */
    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}
