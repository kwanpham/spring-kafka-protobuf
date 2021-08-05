package quan.dev.springkafkaprotobuf.config;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import quan.dev.springkafkaprotobuf.model.KafkaMesageProtobuf;
import quan.dev.springkafkaprotobuf.model.ProtoMessage;

@Slf4j
public class ProtobufDeserializer implements Deserializer<KafkaMesageProtobuf> {

    @Override
    public KafkaMesageProtobuf deserialize(String s, byte[] bytes) {
        try {
            return KafkaMesageProtobuf.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            log.error(e.toString());
            return null;
        }
    }
}
