# Perl, Mojolicious Lite

Perl is known for being concise and writing lots
of functionality in a few lines of code. This example 
is no different. The only dependency is [Mojolicious Lite](http://mojolicious.org/perldoc/Mojolicious/Lite),
a lightweight REST framework.

First we install the dependency:

```bash
sudo cpan Mojolicious::Lite
```

Then we create a script helloworld.pm with the following
contents

```perl5
#!/usr/bin/perl
use Mojolicious::Lite;

get '/helloworld' => sub {
        shift->render(text => "Hello World!");
    };

app->start;
```
make it executable
```bash
chmod a+x helloworld.pm
```

and run it

```bash
./helloworld.pm daemon -m production -l http://localhost:8080
```

That's it :-)

## Dependencies
* Perl
* Mojolicious Lite