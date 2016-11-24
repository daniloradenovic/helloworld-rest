Rails.application.routes.draw do
  get 'hello_world/helloworld'

  get 'helloworld', to: 'hello_world#helloworld'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
