package com.augustlearnings.RabbitMQKafkaConsumer.Service

import com.augustlearnings.RabbitMQKafkaConsumer.Model.Student
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

private val logger : Logger = LoggerFactory.getLogger(RabbitMQListenerService::class.java)
@Component
class RabbitMQListenerService {

    @RabbitListener(queues = ["message_queue"])
    fun listener(studentMessage : Student) {
        logger.info("message : {studentMessage}")
    }
}