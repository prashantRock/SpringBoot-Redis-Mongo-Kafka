package com.journaldev.bootifulmongodb.controller;

import com.journaldev.bootifulmongodb.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class ApacheKafkaWebController {


    private final Producer producer;
    @Autowired
    public ApacheKafkaWebController(Producer producer) {
        this.producer = producer;
    }
    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }


}
