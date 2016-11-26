# Go

This one comes really close to Python and JavaScript, nodejs
examples in terms of lines of code needed to
create a simple REST service.

This piece of code is everything that is needed:

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


## Dependencies
* Golang