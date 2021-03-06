# Ruby, Rails

Similar to the [Grails example](https://github.com/daniloradenovic/helloworld-rest/tree/master/groovy-grails), almost
 all of the code is generated by the Rails framework itself, by using:
 
 ```bash
rails new myapp
cd myapp
bin/rails generate controller HelloWorld helloworld
```

This will generate ALL the necessary project files, including Gemfile, Rakefile, 
as well as all the code necessary for starting a service, and a controller that looks like

```ruby
class HelloWorldController < ApplicationController
  def helloworld

  end
end
```

HelloWorldController located in `controllers/hello_world_controller.rb` 
is bound to a generated view in `views/hello_world/helloworld.html.erb`. By default,
[puma server](http://puma.io/) for ruby applications is listening on port `3000`. If we would
start the application with

```bash
bin/rails server
```
and navigate to 
```bash
http://localhost:3000/hello_world/helloworld
```

we would see an _HTML_ page with content

```html
<h1>Hello World!</h1>
```

However, we want to get
1. _Plain_ text returned as a response, not an HTML page
2. We want it to be accessible at `/helloworld`, not `/hello_world/helloworld`
3. We want the server running on port 8080

To address the first issue, we modify the above HelloWorldController as such

```ruby
class HelloWorldController < ApplicationController
  def helloworld
    render plain: "Hello World!"
  end
end
```
This will return plain text, instead of returning the whole .html page.

Second, we open the `config/routes.rb`

```ruby
Rails.application.routes.draw do
  get 'hello_world/helloworld'

  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
```

and add
```ruby
Rails.application.routes.draw do
  get 'hello_world/helloworld'

  get 'helloworld', to: 'hello_world#helloworld'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
```

This will redirect get requests to `/helloworld` to the `HelloWorldController`, which will in turn return the plain text `"Hello World!"`

Finally, we append the following to the `config/boot.rb`
 
 ```ruby
 require 'rails/commands/server'
 
 module Rails
   class Server
     alias :default_options_alias :default_options
 
     def default_options
       default_options_alias.merge!(:Port => 8080)
     end
   end
 end
 ```

Now we're ready to access `http://localhost:8080/helloworld`
and enjoy our favorite message :-).

## Dependencies
* Ruby
* Rails

This example, as well as many others can be found on the [official Ruby on Rails website](http://guides.rubyonrails.org/getting_started.html).