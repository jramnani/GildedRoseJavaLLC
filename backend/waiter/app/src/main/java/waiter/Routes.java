package waiter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Routes {

    public Map<String, Route> routes;

    public Routes() {
        this.routes = new HashMap<>();
    }

    public void addRoute(Route route) {
        this.routes.put(route.url, route);
    }

    public Route getRoute(String url) {
        return this.routes.get(url);
    }

    public boolean exists(String url) {
        return this.routes.containsKey(url);
    }

    public boolean dynamicallyExists(String url) {
        String partialDynamicUrl = getPartialDynamicUrl(url);

        for (String desiredUrl : this.routes.keySet()) {
            if (desiredUrl.contains(partialDynamicUrl)) {
                return true;
            }
        }
        return false;
    }

    public String getDynamicUrl(String url) {
        String partialDynamicUrl = getPartialDynamicUrl(url);
        for (String desiredUrl : this.routes.keySet()) {
            if (desiredUrl.contains(partialDynamicUrl)) {
                return desiredUrl;
            }
        }
        return url;
    }

    public String getUrlParameter(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }

    public Response handle(Request request, Route route) {

        Function<Request, Response> handler = route.handler;
        try {
            return handler.apply(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getPartialDynamicUrl(String url) {
        return url.substring(0, url.lastIndexOf('/')) + "/:";
    }
}
