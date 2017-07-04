package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

    /**
     * Map any request that is a GET on /courses.
     * GET is the default request.
     * @return
     */
    public List<Course> getAllCourses(String topicId){
    	List<Course> courses = new ArrayList<>();
    	courseRepository.findByTopicId(topicId)
    	.forEach(courses::add);
    	return courses;
    }

    public Course getCourse(String id){
        // return course.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    	return courseRepository.findOne(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    /**
     * Loop through the courses (depending on the size),
     * and for each course in that list, it is going to
     * compare the id with the input id, and if it matches
     * at that location send the updated course to the list
     * and return.
     * @param course
     */
    public void updateCourse(Course course) {
//        for(int i = 0; i < coursess.size(); i++){
//            Course t =  courses.get(i);
//            if(t.getId().equals(id)){
//                 courses.set(i, course);
//                return;
//            }
//        }
    	courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //courses.removeIf(t -> t.getId().equals(id));
    	courseRepository.delete(id);
    }
}
