package com.zemoso.kafka.Gateway;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.JsonNode;
import com.zemoso.kafka.Consumer.KafkaConsumer;
import com.zemoso.kafka.Producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Value("${topic.boot}")
    private String topic;


//
//    @ResponseBody
//    @RequestMapping(value ={"/{subject}"}, method = RequestMethod.GET)
////    public ResponseEntity<Map> greeting(@RequestBody JsonNode json) {
//    public ResponseEntity<String> get(@PathVariable("subject") String subject) {
//        Map<String,Object> result = new HashMap<>();
////        String topic = json.get("topic").asText();
////        String subject = json.get("subject").asText();
//
//        kafkaProducer.send(topic, subject);
////        try {
////            kafkaConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////
//        return new ResponseEntity<>("Ok", HttpStatus.OK);
//    }

    @ResponseBody
    @RequestMapping(value ={"/post"}, method = RequestMethod.POST)
//    public ResponseEntity<Map> greeting(@RequestBody JsonNode json) {
    public ResponseEntity<String> post(@RequestBody JsonNode json) {
//        Map<String,Object> result = new HashMap<>();
////        String topic = json.get("topic").asText();
//        String subject = json.get("subject").asText();

        kafkaProducer.send(topic, json);
//        try {
//            kafkaConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }


}
