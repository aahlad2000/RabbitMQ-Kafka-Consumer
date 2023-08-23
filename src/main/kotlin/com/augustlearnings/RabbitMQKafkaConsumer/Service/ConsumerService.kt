package com.augustlearnings.RabbitMQKafkaConsumer.Service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerService {

    @KafkaListener(topics = ["\${spring.kafka.student-topic}"],containerFactory = "kafkaListenerStringFactory", groupId = "group_id")
    fun consumeMessage(message : String){
        println("Consuming messages....")
    }
}