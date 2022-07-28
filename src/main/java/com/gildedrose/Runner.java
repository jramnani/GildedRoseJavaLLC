package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.Ageable;
import com.gildedrose.items.MapRepository;
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

import java.util.Map;
import java.util.function.Function;

public class Runner {
    static DataRepository mapRepository;

    public static void main(String[] args) {
        int port = 5000;
        GildedRose gRose = constructInventory();
        mapRepository = new MapRepository(gRose.getInventory());
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

    private static GildedRose constructInventory() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured", 3, 6) };

        return new GildedRose(items);
    }
    private static Routes constructRoutes() {
        Routes routes = new Routes();

        routes.addRoute(
                new Route("/inventory", new Request.Method[]{Request.Method.GET}, okAllItemsHandler)
        );

        routes.addRoute(
                new Route("/inventory/:id", new Request.Method[]{Request.Method.GET}, okSingleItemHandler)
        );

        return routes;
    }

    private static final Function<Request, Response> okAllItemsHandler = request -> new ResponseBuilder()
            .newUp()
            .body(getJsonFormattedBody())
            .headers(Response.HeaderField.ContentType, "application/json")
            .build();

    private static final Function<Request, Response> okSingleItemHandler = request -> new ResponseBuilder()
            .newUp()
            .body(getJsonFormattedBodyWithId(request.getParameter()))
            .headers(Response.HeaderField.ContentType, "application/json")
            .build();

    private static String getJsonFormattedBody() {
        return """
                {
                    "name": "hello world",
                    "price": "hello world"
                }
                """;
    }

    private static String getJsonFormattedBodyWithId(String id) {
        Ageable item = mapRepository.get(id);
        return String.format("""
                {
                    "name": "%s",
                    "price": "%d"
                }
                """, item.getName(), item.getPrice());
    }

}
