package quan.dev.springkafkaprotobuf.service;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import quan.dev.springkafkaprotobuf.model.KafkaMesageProtobuf;
import quan.dev.springkafkaprotobuf.model.KafkaMessage;

@Service
public class Consummer {

    StopWatch stopWatchJson;

    StopWatch stopWatchProtobuf;

    @KafkaListener(topics = "testJson", containerFactory = "kafkaListenerContainerFactoryJson")
    public void listenJson(KafkaMessage message) {
        if (message.getId() == 0) {
            stopWatchJson = StopWatch.createStarted();
        }

        if (message.getId() == 100000) {
            stopWatchJson.stop();
            System.out.println("json consumer : " + stopWatchJson);
        }
        //System.out.println("Received Message in group - group-id: " + message);
    }

    @KafkaListener(topics = "testProtobuf", containerFactory = "kafkaListenerContainerFactoryProtobuf")
    public void listenProtobuf(KafkaMesageProtobuf message) {
        if (message.getId() == 0) {
            stopWatchProtobuf = StopWatch.createStarted();
        }

        if (message.getId() == 100000) {
            stopWatchProtobuf.stop();
            System.out.println("protobuf consumer :" + stopWatchProtobuf);
        }
       // System.out.println("Received Message in group - group-id: " + message);
    }
}
