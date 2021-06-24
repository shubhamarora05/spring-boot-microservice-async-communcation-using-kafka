# Spring-Boot-Microservice-Communcation-Using-Kafka 
Basic example of making asynchronous communication between multiple microservices using Message Broker - Kafka. <br/>

In this example I have created 3 zookeeper nodes and 3 brokers in kafka cluster. 
#### 1. Kafka Configuration on Windows/Ubuntu
* Download kafka binaries using this [link](https://kafka.apache.org/downloads).
* Start 3 nodes of zookeeper using zookeeper.properties file
* Start 3 brokers in Kafka Cluster using server.properties
* Create a topic where you want to produce or consume messages. You can refer below command for topic creation <br>
  `kafka-topics.sh --bootstrap-server hostname1:port1,hostname2:port2,hostname3:port3 --create --topic myTopic --partitions 3 --replication-factor 3`
  
#### 2. Microservice
This project contains 2 microservices, an Api Gateway and a Servic Registry:
* <b> Department Service:</b> This service is used to manage department details and also produce message on kafka to send notification to employee microservice.
* <b> Employee Service:</b> This service is used to manage Employee details and consume messages from kafka to send email notification to employee's email.
* <b> Api-Gateway:</b> This gateway is used to receive and forward requests from UI to Microservices and also provides custom message when any microservice is down using circuit breaker.
* <b> Service-Registry:</b> This is used to register all microservices on Eureka server.
