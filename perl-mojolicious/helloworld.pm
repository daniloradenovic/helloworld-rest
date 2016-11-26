#!/usr/bin/perl
use Mojolicious::Lite;

get '/helloworld' => sub {
        shift->render(text => "Hello World!");
    };

app->start;

