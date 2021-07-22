package quan.dev.springkafkaprotobuf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() {
        for (int i = 0 ; i<1000 ; i++) {
            kafkaTemplate.send("test1", "msg " +i );
        }

    }

    @GetMapping("/test1")
    public String test1() {
        sendMessage();
        return "ok";
    }

}
