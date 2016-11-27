# Scala, Play

Similar to the Groovy and Rails frameworks, Play's Activator - utility used
for bootstrapping a project, creates all of the necessary project files,
while we need to make just a few small changes to get to our desired result.

To bootstrap a project, we run

```bash
activator new scala-play play-scala
```

First argument `scala-play` is the name we give to the application, and the
second argument `play-scala` tells the activator to bootstrap a Scala-flavored
Play application. This will generate a full blown Play application in Scala, with all the
goodness that comes with it. Please visit [official Play website](https://www.playframework.com/) for more information about
all the good stuff that Play framework provides out-of-the-box.

Among other things, it creates a controller and a corresponding view for it, named
`Home Controller` in `app/controllers/HomeController` which has the following
content:

```scala
package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
```

Similar to our [Rails example](https://github.com/daniloradenovic/helloworld-rest/tree/master/ruby-rails)
the controller calls the view and renders an HTML page, available at 
```bash
http://localhost:9000/
```
but we need it at 

```bash
http://localhost:8080/helloworld
```

Since we just want a plain-text "Hello World!", we change it like so

```scala
package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok("Hello World!")
  }

}
```
To change the path, we open the default `conf/routes` file

```play
# Routes
# This file defines all application routes (Higher priority routes first)
# ~~~~

# An example controller showing a sample home page
GET        /helloworld          controllers.HomeController.index
# An example controller showing how to use dependency injection
GET        /count               controllers.CountController.count
# An example controller showing how to write asynchronous code
GET        /message             controllers.AsyncController.message

# Map static resources from the /public folder to the /assets URL path
GET        /assets/*file        controllers.Assets.versioned(path="/public", file: Asset)
```

and change the first rule as follows

```diff
-GET     /                           controllers.HomeController.index
+GET     /helloworld                 controllers.HomeController.index
```

To start the application at the desired port (in our case 8080), we use
the activator again

```bash
activator "run 8080"
```

Play Framework has an excellent, up-to-date documentation [online](https://www.playframework.com/documentation/2.5.x/Home), as well
 as plenty of tutorials for various use cases. In addition to that, all
 Play enables writing applications in the same manner using both Java
 and Scala.


## Dependencies
* Java
* Activator