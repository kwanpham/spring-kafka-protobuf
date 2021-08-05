package quan.dev.springkafkaprotobuf.config;


import org.apache.kafka.common.serialization.Serializer;
import quan.dev.springkafkaprotobuf.model.KafkaMesageProtobuf;
import quan.dev.springkafkaprotobuf.model.ProtoMessage;

public class ProtobufSerializer implements Serializer<KafkaMesageProtobuf> {


    @Override
    public byte[] serialize(String s, KafkaMesageProtobuf simpleMessage) {
        return simpleMessage.toByteArray();
    }
}
