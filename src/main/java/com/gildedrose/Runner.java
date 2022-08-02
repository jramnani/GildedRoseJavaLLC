package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
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

import java.util.HashMap;

public class Runner {

    static ItemsController itemsController;

    public static void main(String[] args) {
        int port = 5000;
        itemsController = new ItemsController(new ItemsDataSource<>(populateHashMapDB()));
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
                new Route("/inventory", new Request.Method[]{Request.Method.GET}, itemsController.okAllItemsHandler)
        );

        routes.addRoute(
                new Route("/inventory/:id", new Request.Method[]{Request.Method.GET}, itemsController.okSingleItemHandler)
        );

        return routes;
    }


    //Only here for the inlined DB (Hashmap)
    private static HashMap<String, Item> populateHashMapDB() {
        HashMap<String, Item> hashMapDB = new HashMap<>();
        int id = 0;
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

        for (Item item : items) {
            hashMapDB.put(String.valueOf(id++), item);
        }

        return hashMapDB;
    }

}
