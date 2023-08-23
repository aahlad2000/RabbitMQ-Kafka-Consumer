package com.augustlearnings.RabbitMQKafkaConsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitMqKafkaConsumerApplication

fun main(args: Array<String>) {
	runApplication<RabbitMqKafkaConsumerApplication>(*args)
}
