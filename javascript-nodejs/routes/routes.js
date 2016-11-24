var appRouter = function (app) {
    app.get("/helloworld", function (req, res) {
        res.send("Hello World!");
    });
}

module.exports = appRouter;