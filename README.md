# Hello Rest!

"Hello World!" REST service implemented in various languages and frameworks. 

Some language/framework combinations offer much more features besides the plain
REST GET call, with full blown project bootstrapping that allows easy addition of new features,
while others provide only the required "Hello World!" response in as few lines as possible.

## Python
The winner of this small competition is probably Python, with all the code fitting in 10 lines
of code

```python
from flask import Flask

app = Flask(__name__)

@app.route('/helloworld')
def index():
    return "Hello, World!"

if __name__ == '__main__':
    app.run(debug=True, port=8080)
```

The only required dependency is `flask`, which is installed with `pip` - Python's package manager, which
 comes with Python, and Python is in turn installed by default on most Unix distributions.

You can find the whole Python/Flask example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/python-flask).

## Ruby/Rails

Rails is a popular web framework, famous for quick project bootstrapping. Our `Hello World!` REST example is
no exception - by calling `rails new myapp` we can generate a full blown project - including
some predefined views and controllers, support for i18n, configuration files and test directories.
With a few more lines of code, we are able to reach our desired goal, all in a matter of minutes.

We need a controller

```ruby
class HelloWorldController < ApplicationController
  def helloworld
    render plain: "Hello World!"
  end
end
```

and change the `config/routes.rb` file to redirect `/helloworld` requests
to our controller

```ruby
Rails.application.routes.draw do
  get 'hello_world/helloworld'

  get 'helloworld', to: 'hello_world#helloworld'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
```

You can find the whole Ruby/Rails example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/ruby-rails).

## Groovy/Grails

Groovy counterpart of popular Rails framework, named Grails, provides that familiar ease
of setup and convention-over-configuration approach as Rails does. Besides
running inside a JVM and making Java developers feel more like at home, it also uses 
Gradle for build management (which is also written in Groovy!),
whose .gradle files are usually a joy to read and skim through, compared to XML based
variants.

We just need to modify the generated controller

```groovy
package groovy.grails

class HelloworldController {

    def index() {
        render "Hello World!"
    }
}
```

You can find the whole Groovy/Grails example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/groovy-grails).

## Java/Scala and Play Framework

Play framework also enables creating full blown web applications, with easy bootstrapping with
`activator new myapp`. In addition to what Rails/Grails
provide, Play Framework brings a whole Reactive environment with Actors and reactive streams
to the table. Besides, it provides two implementations - Java AND Scala. Therefore, a controller
for our example can be written in Java as

```java
package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class HomeController extends Controller {

  public Result index() {
    return ok("Hello World!");
  }
}
```

or in Scala as

```scala
package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject() extends Controller {

  def index = Action {
    Ok("Hello World!")
  }
}
```
And the end result is the same.

You can find the whole Java/Play example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/java-play).

You can find the whole Scala/Play example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/scala-play).

## Kotlin and Spring Boot

This is quite an interesting combination. Spring is a well-established framework and was
[the most widely used Java web framework in 2012](https://zeroturnaround.com/rebellabs/the-curious-coders-java-web-frameworks-comparison-spring-mvc-grails-vaadin-gwt-wicket-play-struts-and-jsf/). 
It enables adding quite a lot of functionality with annotations. In addition to that, Kotlin's syntax
 is quite concise, which makes for an easily readable main class
 
```kotlin
@SpringBootApplication
open class HelloWorld


fun main(args: Array<String>) {
    SpringApplication.run(HelloWorld::class.java, *args)
}
```

and controller

```kotlin
@RestController
open class HelloWorldController {

    @RequestMapping(value = "/helloworld")
    fun helloWorld() = "Hello World!"
}
```

You can find the whole Kotlin/Spring Boot example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/kotlin-springboot).

## Go

This example, besides being really short in terms of lines of code,
 has one interesting feature - apart from Go lang installation, it has 0
 dependencies. This code snippet is all it's needed
 
 ```go
 package main
 
 import (
     "fmt"
     "log"
     "net/http"
 )
 
 func main() {
     http.HandleFunc("/helloworld", func(w http.ResponseWriter, r *http.Request) {
         fmt.Fprint(w, "Hello World!")
     })
 
     log.Fatal(http.ListenAndServe(":8080", nil))
 }
 ```

You can find the whole Go example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/go).

## JavaScript with node.js

For those who are accustomed to JavaScript, node.js brings a pleasantly
simple way of creating a RESTful web service. Design of this simple application
is split into two parts, a server setup

```javascript
var express = require("express");
var bodyParser = require("body-parser");
var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

var routes = require("./routes/routes.js")(app);

var server = app.listen(8080, function () {
    console.log("Listening on port %s...", server.address().port);
});
```

and a `routes/routes.js` file with the following

```javascript
var appRouter = function (app) {
    app.get("/helloworld", function (req, res) {
        res.send("Hello World!");
    });
}

module.exports = appRouter;
```

You can find the whole JavaScript/node.js example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/javascript-nodejs).

## Crystal
"A compiled language with Ruby like syntax and type inference." Although it is not 
yet production ready, creating and running our "Hello World!" REST example is pretty easy.

All the code is here:

```ruby
require "http/server"

server = HTTP::Server.new(8080) do |context|
  if context.request.path == "/helloworld"
    context.response.content_type = "text/plain"
    context.response.print "Hello world!"
  end
end

puts "Listening on http://localhost:8080"
server.listen
```

You can find the whole Crystal example [here](https://github.com/daniloradenovic/helloworld-rest/tree/master/crystal).