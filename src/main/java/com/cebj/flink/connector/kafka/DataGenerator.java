package com.cebj.flink.connector.kafka;

import com.cebj.flink.util.PropertiesUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DataGenerator {
    File dataFile;
    String inTopic;
    Producer producer;

    public DataGenerator(String path, String inTopic) {
        this.dataFile = new File(path);
        this.inTopic = inTopic;
        Properties props = PropertiesUtil.readConf("D:\\IdeaProjects\\flinkoperator\\src\\main\\java\\com\\cebj\\flink\\conf\\dataGenerator.properties");
        producer = new KafkaProducer<>(props);
    }

    private String generate(BufferedReader in) throws IOException {
        return in.readLine();
    }

    public void put() {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            while ((line = generate(reader)) != null) {
                producer.send(new ProducerRecord(inTopic, line));
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
