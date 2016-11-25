# Python, Flask

We install the only required dependency - flask, a lightweight Python server

```bash
pip install flask
```

Create a file helloworld.py with these contents:

```python
from flask import Flask

app = Flask(__name__)

@app.route('/helloworld')
def index():
    return "Hello, World!"

if __name__ == '__main__':
    app.run(debug=True, port=8080)
```

And run it

```bash
python helloworld.py
```

In the spirit of Python, this is the smallest amount of code required
to create a simple REST service.

## Dependencies
* Python
* Flask

This example is taken from [Flask's homepage](http://flask.pocoo.org/)