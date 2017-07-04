package io.javabrains.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    /**
     *
     * @param topicId
     * @return
     *
     * A custom repository method that uses JPA's naming / nomenclature
     * to find topic records by name.  Declaring the methods with this
     * format allows Spring Data JPA to implement the method.  Since
     * this method is looking for a Topic it is necessary to add the
     * property that we are looking for.  In this case it is: Id
     *
     * Reference: https://www.youtube.com/watch?v=_Jnu_jHfQbM&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x&index=31
     *
     */
	public List<Course> findByTopicId(String topicId);
 
}
