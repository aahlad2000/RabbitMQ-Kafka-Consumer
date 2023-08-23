package com.augustlearnings.RabbitMQKafkaConsumer.Config

import com.augustlearnings.RabbitMQKafkaConsumer.Model.Student
import com.fasterxml.jackson.databind.JsonDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
@EnableKafka
class KafkaConsumerConfig{

    @Value("\${spring.kafka.consumer.bootstrap-servers}")
    private val bootstrapServers : String = "localhost:9092"

    @Value("\${spring.kafka.consumer.group-id }")
    private val groupId : String = ""


    @Bean
    fun consumerFactory () : ConsumerFactory<String?, Any?>{
        var config : HashMap<String, Any> = hashMapOf()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        config[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        config[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        config[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = false
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class
        return DefaultKafkaConsumerFactory(config)
    }

}