package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.Ageable;
import waiter.Request;
import waiter.Response;
import waiter.ResponseBuilder;

import java.util.function.Function;

public class ItemsController {

    private final DataRepository itemsRepository;

    public ItemsController(Datasource<Ageable> hashMapDB) {
        this.itemsRepository = new ItemsRepository(hashMapDB);
    }

    final Function<Request, Response> okAllItemsHandler = request -> new ResponseBuilder()
            .newUp()
            .body(getJsonFormattedBody())
            .headers(Response.HeaderField.ContentType, "application/json")
            .build();

    final Function<Request, Response> okSingleItemHandler = request -> new ResponseBuilder()
            .newUp()
            .body(getJsonFormattedBodyWithId(request.getParameter()))
            .headers(Response.HeaderField.ContentType, "application/json")
            .build();

    private String getJsonFormattedBody() {
        return """
                {
                    "name": "hello world",
                    "price": "hello world"
                }
                """;
    }

    private String getJsonFormattedBodyWithId(String id) {
        Ageable item = itemsRepository.get(id);
        return String.format("""
                {
                    "name": "%s",
                    "price": "%f"
                }
                """, item.getName(), item.getPrice());
    }
}
