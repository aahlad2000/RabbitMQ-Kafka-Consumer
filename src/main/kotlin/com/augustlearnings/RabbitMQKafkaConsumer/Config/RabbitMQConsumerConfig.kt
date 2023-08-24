package com.augustlearnings.RabbitMQKafkaConsumer.Config


import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration



@Configuration
class RabbitMQConsumerConfig{

    @Bean
    fun queue() : Queue {
        return Queue(QUEUE)
    }

    @Bean
    fun exchange() : TopicExchange {
        return TopicExchange(EXCHANGE)
    }

    @Bean
    fun binding(queue : Queue, exchange : TopicExchange) : Binding {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY)
    }

    @Bean
    fun template (connectionFactory: ConnectionFactory) : AmqpTemplate{
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = messageConverter()
        return rabbitTemplate
    }

    @Bean
    fun messageConverter() : MessageConverter {
        return Jackson2JsonMessageConverter();
    }

    companion object{
        val QUEUE : String = "message_queue"
        val EXCHANGE : String = "message_exchange"
        val ROUTING_KEY : String = "message_routingKey"
    }
}