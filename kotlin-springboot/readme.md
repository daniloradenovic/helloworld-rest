# Kotlin, Spring Boot

This example combines the power of Spring with clean syntax of Kotlin.
It is a from-scratch example that can be used simply by copy-pasting
the project and extending it as needed.

Entry point is `HelloWorld` class that looks like

```kotlin
package hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class HelloWorld


fun main(args: Array<String>) {
    SpringApplication.run(HelloWorld::class.java, *args)
}
```

while `HelloWorldController` is used for defining routes

```kotlin
package hello

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class HelloWorldController {

    @RequestMapping(value = "/helloworld")
    fun helloWorld() = "Hello World!"
}
```
Default port is 8080, so we just need to run the application and that's it.

This example was adapted from a very nice blog post on [@medium](https://medium.com/@dime.kotevski/writing-a-restful-backend-using-kotlin-and-spring-boot-9f162c96e428#.n1yxytipo)

## Dependencies
* Java