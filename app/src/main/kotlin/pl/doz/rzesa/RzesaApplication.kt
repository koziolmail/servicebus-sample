package pl.doz.rzesa

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication(scanBasePackages = ["pl.doz.rzesa", "pl.doz.kamsoft"])
class RzesaApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplication.run(RzesaApplication::class.java, *args)
}