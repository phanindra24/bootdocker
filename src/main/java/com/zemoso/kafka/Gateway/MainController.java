package com.zemoso.kafka.Gateway;

import com.fasterxml.jackson.databind.JsonNode;
import com.zemoso.kafka.Consumer.KafkaConsumer;
import com.zemoso.kafka.Producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Value("${topic.boot}")
    private String topic;

    @ResponseBody
    @RequestMapping(value ={"/post"}, method = RequestMethod.POST)
    public ResponseEntity<String> post(@RequestBody JsonNode json) {
        kafkaProducer.send(topic, json);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
