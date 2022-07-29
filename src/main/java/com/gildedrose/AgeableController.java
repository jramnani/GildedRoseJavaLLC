package com.gildedrose;

import com.gildedrose.items.Ageable;
import waiter.Request;
import waiter.Response;
import waiter.ResponseBuilder;

import java.util.function.Function;

public class AgeableController {

    private final DataRepository ageableRepository;

    public AgeableController() {
        this.ageableRepository = new AgeableRepository();
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
        Ageable item = ageableRepository.get(id);
        return String.format("""
                {
                    "name": "%s",
                    "price": "%f"
                }
                """, item.getName(), item.getPrice());
    }
}
