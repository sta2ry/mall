package org.featx.sta2ry.mall

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(value = ["org.featx.sta2ry.lyrae.end"])
open class MallApplication
fun main() {
    SpringApplication.run(MallApplication::class.java)
}