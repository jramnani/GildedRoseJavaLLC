package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.Ageable;
import com.gildedrose.items.DefaultItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import waiter.Request;
import waiter.Response;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemsControllerTest {

    ArrayList<Ageable> mockedDB;
    ItemsController itemsController;

    @BeforeEach
    void setUp() {
        mockedDB = new ArrayList<>();
        itemsController = new ItemsController(new ItemsDataSourceMock<>(mockedDB));
        mockedDB.add(new DefaultItem(new Item("FlavorTown", 3, 14)));
    }

    @Test
    void returnsOkResponse_WhenSingleItemIsRetrieved() {
        Request request = new Request("/inventory", Request.Method.GET.asString, "foo", "foo", "foo");
        request.setParameter("1");

        Response response = itemsController.okSingleItemHandler.apply(request);

        assertEquals(Response.Status.OK, response.getStatus());
        assertTrue(response.getBody().contains("FlavorTown"));
    }

    @Test
    void returnsOkResponse_WhenAllItemsAreRetrieved() {
        Request request = new Request("/inventory", Request.Method.GET.asString, "foo", "foo", "foo");

        Response response = itemsController.okAllItemsHandler.apply(request);

        assertEquals(Response.Status.OK, response.getStatus());
        assertTrue(response.getBody().contains("FlavorTown"));
    }

    @Test
    void returnsNotFoundResponse_WhenSingleItemIsNotFound() {
        Request request = new Request("/inventory", Request.Method.GET.asString, "foo", "foo", "foo");
        request.setParameter("2");

        Response response = itemsController.okSingleItemHandler.apply(request);

        assertEquals(Response.Status.NotFound, response.getStatus());
    }

    @Test
    void okAllItemsUpdateHandler_ShouldAgeAllItemsInDB() {
        Request request = new Request("/inventory/update", Request.Method.POST.asString, "foo", "foo", "foo");
        Ageable item = mockedDB.get(0);

        itemsController.okAllItemsUpdateHandler.apply(request);


        assertEquals(13, item.getQuality());
        assertEquals(2, item.getSellIn());
    }
}
