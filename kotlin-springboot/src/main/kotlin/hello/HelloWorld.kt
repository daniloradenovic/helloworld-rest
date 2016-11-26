package hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class HelloWorld


fun main(args: Array<String>) {
    SpringApplication.run(HelloWorld::class.java, *args)
}