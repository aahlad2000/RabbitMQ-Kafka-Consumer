package com.augustlearnings.RabbitMQKafkaConsumer.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


private val logger : Logger = LoggerFactory.getLogger(KafkaConsumerService::class.java)
@Service
class KafkaConsumerService {

    @KafkaListener(topics = ["spring.kafka.student-topic"],groupId = "group_id")
    fun consumeMessage(message : String){
        logger.info("message : {message}")
    }
}