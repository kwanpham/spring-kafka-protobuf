package quan.dev.springkafkaprotobuf.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consummer {

    @KafkaListener(topics = "test1", groupId = "group-id")
    public void listen(String message) {

        System.out.println("Received Message in group - group-id: " + message);
    }
}
