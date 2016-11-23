# Groovy, Grails, Gradle

Although it might seem like a lot of files/code for a simple
rest service, everything except one line is generated automatically.

All that needs to be done is

```commandline
grails create-app myapp
cd myapp
grails
create-controller helloworld
```

This will generate ALL the necessary project files, including gradle.build and .gitignore files,
as well as all the code necessary for starting a service, and a controller that looks like

```groovy
package groovy.grails

class HelloworldController {

    def index() {
        
    }
}
```

Now we just add
```groovy
package groovy.grails

class HelloworldController {

    def index() {
        render "Hello World!"
    }
}
```

Navigate to [localhost:8080/helloworld](localhost:8080/helloworld) et voilà, a simple REST service is done!

This tutorial was taken from the very well documented Grails [getting started guide](http://docs.grails.org/latest/guide/gettingStarted.html).