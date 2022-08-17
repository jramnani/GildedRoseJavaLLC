package com.gildedrose;

import com.gildedrose.items.Ageable;
import waiter.Request;
import waiter.Response;
import waiter.ResponseBuilder;

import java.util.Collection;
import java.util.function.Function;

public class ItemsController {

    private ItemsPresenter itemsPresenter;
    private DataRepository itemsRepository;

    public ItemsController(Datasource<Ageable> hashMapDB) {
        this.itemsRepository = new ItemsRepository(hashMapDB);
        this.itemsPresenter = new ItemsPresenter();
    }

    final Function<Request, Response> okAllItemsHandler = request -> {
        Collection<Ageable> items = itemsRepository.getAll();
        return new ResponseBuilder()
                .newUp()
                .body(itemsPresenter.allItemsJson(items))
                .headers(Response.HeaderField.ContentType, "application/json")
                .build();
    };

    final Function<Request, Response> okSingleItemHandler = request -> {
        Ageable item = itemsRepository.get(request.getParameter());
        if (itemNotFound(item)) {
            return new ResponseBuilder()
                    .newUp()
                    .status(Response.Status.NotFound)
                    .body("404, item was not found")
                    .build();
        }
        return new ResponseBuilder()
                .newUp()
                .body(itemsPresenter.singleItemJson(item))
                .headers(Response.HeaderField.ContentType, "application/json")
                .build();
    };

    final Function<Request, Response> okAllItemsUpdateHandler = request -> {
        itemsRepository.updateAll();
        Collection<Ageable> items = itemsRepository.getAll();
        return new ResponseBuilder()
                .newUp()
                .body(itemsPresenter.allItemsJson(items))
                .headers(Response.HeaderField.AccessControlAllowOrigin, "*")
                .headers(Response.HeaderField.ContentType, "application/json")
                .build();
    };

    private boolean itemNotFound(Ageable item) {
        return item == null;
    }

}
