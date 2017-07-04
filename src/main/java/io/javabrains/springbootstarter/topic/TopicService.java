package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

    /**
     * Need to use ArrayList so that we can mutate the list, as
     * Arrays.asList is immutable
     */
//    List<Course> topics = new ArrayList<>(Arrays.asList(
//            new Course("spring", "Spring Framework", "Spring Framework Description"),
//            new Course("java", "Core Java", "Core Java Description"),
//            new Course("javascript", "Javascript", "Javascript Description")
//    ));

    /**
     * Map any request that is a GET on /topics.
     * GET is the default request.
     * @return
     */
    public List<Topic> getAllTopics(){
    	List<Topic> topics = new ArrayList<>();
    	topicRepository.findAll()
    	.forEach(topics::add);
    	return topics;
    }

    public Topic getTopic(String id){
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    	return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    /**
     * Loop through the topics (depending on the size),
     * and for each topic in that list, it is going to
     * compare the id with the input id, and if it matches
     * at that location send the updated topic to the list
     * and return.
     * @param topic
     */
    public void updateTopic(String id, Topic topic) {
//        for(int i = 0; i < topics.size(); i++){
//            Course t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
    	topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
    	topicRepository.delete(id);
    }
}
