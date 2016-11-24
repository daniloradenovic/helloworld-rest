# JavaScript, nodejs

This is probably one of the simplest and shortest, from-scratch examples
of a "Hello World!" service so far. Basic node project generation with all the required dependencies
 looks like

```bash
npm init
npm install express --save
npm install body-parser --save
```

The whole server setup is about 10 lines of code

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

The only thing left is a `routes/routes.js` file that holds information
on mappings

```javascript
var appRouter = function (app) {
    app.get("/helloworld", function (req, res) {
        res.send("Hello World!");
    });
}

module.exports = appRouter;
```

And that's all! A VERY lightweight server that does exactly what it needs
to do, in just a couple of lines of code.

## Dependencies
* nodejs

This example was taken from [here](https://www.thepolyglotdeveloper.com/2015/10/create-a-simple-restful-api-with-node-js/)