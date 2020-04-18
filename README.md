# SpringBoot-Redis-Mongo-Kafka

Run Application - mvn spring-boot:run

Kafka Producer, Consumer, Topic

Start Kafka - bin/kafka-server-start.sh config/server.properties

Create Topic - bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

To fetch the topics - bin/kafka-topics.sh --list --bootstrap-server localhost:9092

Send some Messages - bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test
This is a message
This is another message

Start a consumer - bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning

Zookeeper

Start zoo keeper - sudo  bin/zkServer.sh start conf/zoo_sample.cfg 

Stop zoo keeper - sudo  bin/zkServer.sh stop conf/zoo_sample.cfg 
