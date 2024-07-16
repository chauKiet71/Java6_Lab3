package com.lab4.lab4;

import com.fasterxml.jackson.databind.JsonNode;
import com.lab4.lab4.bean.Student;
import com.lab4.lab4.bean.StudentMap;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentDao {
    RestTemplate restTemplate = new RestTemplate();

    String url = "https://lab4-80ecb-default-rtdb.firebaseio.com/students.json";
    private  String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }
    public StudentMap findAll() {
        return restTemplate.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key) {
        return restTemplate.getForObject(getUrl(key), Student.class);
    }   

    public  String create(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode reps = restTemplate.postForObject(url, entity, JsonNode.class);
        return reps.get("name").asText();
    }

    public Student update( String key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        restTemplate.put(getUrl(key), entity);
        return data;
    }

    public void delete( String key) {
        restTemplate.delete(getUrl(key));
    }
}
