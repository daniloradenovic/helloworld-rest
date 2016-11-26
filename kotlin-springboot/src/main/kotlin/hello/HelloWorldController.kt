package hello

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class HelloWorldController {

    @RequestMapping(value = "/helloworld")
    fun helloWorld() = "Hello World!"
}
