package waiter;

import java.util.Objects;

public record Request(String url, String method, String protocol, String headers, String body) {

    private static String parameter = "";

    public enum Method {
        GET("GET"),
        HEAD("HEAD"),
        POST("POST"),
        OPTIONS("OPTIONS"),
        PUT("PUT")
        ;

        public final String asString;

        Method(final String requestMethod) {
            this.asString = requestMethod;
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public void setParameter(String parameter) {
        Request.parameter = parameter;
    }

    public String getParameter() {
        return Request.parameter;
    }

    public boolean methodIsOptions() {
        return Objects.equals(method, Method.OPTIONS.asString);
    }
}