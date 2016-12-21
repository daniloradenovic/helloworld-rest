# Crystal lang

Crystal lang is a "A compiled language with Ruby like syntax and type inference." Although it is not 
yet production ready, creating and running our "Hello World!" REST example is pretty easy.

All the code needed for our example is this:

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

We save it as a `helloworld.cr` file. It has no external dependencies, so the only thing we 
need to run this code is Crystal itself. We download and install Crystal (on Debian/Ubuntu) using:

```bash
curl https://dist.crystal-lang.org/apt/setup.sh | sudo bash
sudo apt-get install crystal
```

An interesting concept in Crystal is that compiling and running code is done with the
same command:

```bash
crystal helloworld.cr
```

Visit Crystal's [home page](https://crystal-lang.org/) for API and Docs.