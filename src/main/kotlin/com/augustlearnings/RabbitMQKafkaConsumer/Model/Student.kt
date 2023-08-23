package com.augustlearnings.RabbitMQKafkaConsumer.Model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

enum class SECTION{
    A,B,C,D
}

@Data
@AllArgsConstructor
@NoArgsConstructor
data class Student(
    val studentId : Int,
    val studentName : String,
    val grade : String,
    val section : SECTION,
    val subjectsTakenByStudent : List<String>,
    val collegeName : String,
)