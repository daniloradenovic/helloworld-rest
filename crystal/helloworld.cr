require "http/server"

server = HTTP::Server.new(8080) do |context|
  if context.request.path == "/helloworld"
    context.response.content_type = "text/plain"
    context.response.print "Hello world!"
  end
end

puts "Listening on http://localhost:8080"
server.listen