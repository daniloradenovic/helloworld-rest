class HelloWorldController < ApplicationController
  def helloworld
    render plain: "Hello World!"
  end
end
