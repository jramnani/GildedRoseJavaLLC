package com.gildedrose;

import waiter.EchoServer;
import waiter.RequestParser;
import waiter.Router;
import waiter.Routes;
import waiter.Route;
import waiter.Request;
import waiter.Awaitable.Listener;
import waiter.Protocol.HttProtocol;
import waiter.Reportable.Communicator;
import waiter.Threadable.ThreadGenerator;
import waiter.Transportable.Messenger;

public class Runner {

    static AgeableController ageableController;

    public static void main(String[] args) {
        int port = 5000;
        ageableController = new AgeableController();
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
                new Route("/inventory", new Request.Method[]{Request.Method.GET}, ageableController.okAllItemsHandler)
        );

        routes.addRoute(
                new Route("/inventory/:id", new Request.Method[]{Request.Method.GET}, ageableController.okSingleItemHandler)
        );

        return routes;
    }


}
