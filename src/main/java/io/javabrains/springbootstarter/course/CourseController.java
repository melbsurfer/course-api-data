package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adrake on 6/16/17.
 */

/**
 * Automatically returns as JSON
 */
@RestController
public class    CourseController {

    /**
     * Dependency injection for the CourseService
     */
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    /**
     * Map this method to any request that is a POST on /topics
     * When the POST occurs execute the addTopic method.  The addTopic method
     * gets the POST body, converts it into a Course instance, and add it
     * to the list in the CourseService.

     * @RequestBody tells Spring MVC that the request payload is going to
     * contain a JSON representation of the Course instance, and we want it
     * to take that RequestBody, and convert it into a Course instance, and pass
     * it to that addTopic
     */
    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId ){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
