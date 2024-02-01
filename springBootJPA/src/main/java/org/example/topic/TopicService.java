package org.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> allTopics = new ArrayList<>(Arrays.asList(
            new Topic("Java", "Namaste Java"),
            new Topic("Javascript", "Namaste Javascript")
    ));

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        return allTopics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void addTopic(){
        topicRepository.save(new Topic("Java", "Namaste Java"));
    }


    public void updateTopic(Topic topic, String id){
        for(int i=0; i< allTopics.size(); i++){
            Topic t = allTopics.get(i);
            if( t.getId().equals(id)){
                allTopics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        allTopics.removeIf(t -> t.getId().equals(id));
    }
}
