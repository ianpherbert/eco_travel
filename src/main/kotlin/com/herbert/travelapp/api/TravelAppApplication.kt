package com.herbert.travelapp.api

import io.mongock.runner.springboot.EnableMongock
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongock
class TravelAppApplication

fun main(args: Array<String>) {
    runApplication<TravelAppApplication>(*args)
}
