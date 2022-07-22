package com.gildedrose;

import waiter.EchoServer;
import waiter.RequestParser;
import waiter.Router;
import waiter.Routes;
import waiter.Route;
import waiter.Request;
import waiter.Response;
import waiter.ResponseBuilder;
import waiter.Awaitable.Listener;
import waiter.Protocol.HttProtocol;
import waiter.Reportable.Communicator;
import waiter.Threadable.ThreadGenerator;
import waiter.Transportable.Messenger;

import java.util.function.Function;

public class Runner {

    public static void main(String[] args) {
        int port = 5000;
        Listener listener = new Listener();
        Routes routes = constructRoutes();
        HttProtocol protocol = new HttProtocol(
                new RequestParser(),
                new Router(routes)
        );
        Messenger messenger = new Messenger(protocol);
        ThreadGenerator threadGenerator = new ThreadGenerator();
        EchoServer echoServer = new EchoServer(
                new Communicator(threadGenerator, listener, messenger)
        );
        echoServer.start(port);
    }

    private static Routes constructRoutes() {
        Routes routes = new Routes();

        routes.addRoute(
                new Route("/inventory", new Request.Method[]{Request.Method.GET}, okInventoryHandler)
        );

        return routes;
    }

    private static final Function<Request, Response> okInventoryHandler = request -> new ResponseBuilder()
                .newUp()
                .body(getJsonFormattedBody())
                .headers(Response.HeaderField.ContentType, "application/json")
                .build();

    private static String getJsonFormattedBody() {
        return """
                {
                    'name': 'hello world',
                    'price': 'hello world'
                }
                """;
    }

}