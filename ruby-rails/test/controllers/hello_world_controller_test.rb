require 'test_helper'

class HelloWorldControllerTest < ActionDispatch::IntegrationTest
  test "should get helloworld" do
    get hello_world_helloworld_url
    assert_response :success
  end

end
