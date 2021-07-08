# Spring-Boot-Microservice-Communcation-Using-Kafka 
Basic example of making asynchronous communication between multiple microservices using Message Broker - Kafka. <br/>

In this example I have created 3 zookeeper nodes and 3 brokers in kafka cluster. You can also change the number of nodes/broker as per your requirement.
#### 1. Kafka Configuration on Windows/Ubuntu
* Download kafka binaries using this [link](https://kafka.apache.org/downloads).
* Start 3 nodes of zookeeper using zookeeper.properties file
* Start 3 brokers in Kafka Cluster using server.properties
* Create a topic where you want to produce or consume messages. Refer below command for topic creation <br>
  `kafka-topics.sh --bootstrap-server hostname1:port1,hostname2:port2,hostname3:port3 --create --topic myTopic --partitions 3 --replication-factor 3`
  
#### 2. Microservice
This project contains 2 microservices, an Api Gateway and a Servic Registry:
* <b> Department Service:</b> This service is used to manage department details.
* <b> Employee Service:</b> This service is used to manage Employee details.
* <b> Api-Gateway:</b> This gateway is used to receive and forward requests from UI to Microservices and also provides custom message when any microservice is down using circuit breaker.
* <b> Service-Registry:</b> This is used to register all microservices on Eureka server.

#### 3. Endpoints
<b>Department Service</b>
![Department Service](https://github.com/shubhamarora05/spring-boot-microservice-async-communcation-using-kafka/blob/main/images/department-service.JPG)
<br><br>
<b>Employee Service</b>
![Employee Service](https://github.com/shubhamarora05/spring-boot-microservice-async-communcation-using-kafka/blob/main/images/employee-service.JPG)

#### 4. Producer and Consumer
* <b>sendNotification</b> API contains the producer which is responsible to send messages on kafka topic.
* A consumer is running inside Employee service which consumes the message sent by Department Service and send the same to employee email.
