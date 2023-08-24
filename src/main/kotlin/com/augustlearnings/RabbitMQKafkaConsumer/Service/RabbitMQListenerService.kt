package com.augustlearnings.RabbitMQKafkaConsumer.Service

import com.augustlearnings.RabbitMQKafkaConsumer.Model.Student
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitMQListenerService {

    @RabbitListener(queues = ["message_queue"])
    fun listener(studentMessage : Student) {
        println(studentMessage)
    }
}