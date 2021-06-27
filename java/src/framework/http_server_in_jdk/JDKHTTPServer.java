package framework.http_server_in_jdk;


import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;


class JDKHTTPServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);
        server.createContext("/login", new LoginHandler());
        server.createContext("/test", new MyHttpHandler());
        server.setExecutor(null);
        server.start();
    }

    static class LoginHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            if ("POST".equals(httpExchange.getRequestMethod())) {
                StringBuilder stringBuilder = new StringBuilder();

                InputStream inputStream = httpExchange.getRequestBody();
                if (inputStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                        stringBuilder.append(charBuffer, 0, bytesRead);
                    }
                }

                String content = stringBuilder.toString();

                Headers headers = httpExchange.getResponseHeaders();
                headers.add("Set-Cookie", "jsessionid=xxxxxx");
                httpExchange.sendResponseHeaders(200, 0);

                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.flush();
                outputStream.close();
            }
        }
    }


    private static class MyHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String requestParamValue = null;
            if ("GET".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handleGetRequest(httpExchange);
            } else if ("POST".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handlePostRequest(httpExchange);
            }

            handleResponse(httpExchange, requestParamValue);
        }

        private String handleGetRequest(HttpExchange httpExchange) {
            return httpExchange.
                    getRequestURI()
                    .toString()
                    .split("\\?")[1]
                    .split("=")[1];
        }

        private String handlePostRequest(HttpExchange httpExchange) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                InputStream inputStream = httpExchange.getRequestBody();
                if (inputStream != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    char[] charBuffer = new char[128];
                    int bytesRead = -1;
                    while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                        stringBuilder.append(charBuffer, 0, bytesRead);
                    }
                }
            } catch (IOException ex) {
            }

            Headers headers = httpExchange.getRequestHeaders();
            String c = headers.getFirst("Cookie");
            return stringBuilder.toString();
        }

        private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html>").
                    append("<body>").
                    append("<h1>").
                    append("Hello ")
                    .append(requestParamValue)
                    .append("</h1>")
                    .append("</body>")
                    .append("</html>");

            // encode HTML content
//            String htmlResponse = StringEscapeUtils.escapeHtml4(htmlBuilder.toString());
            String htmlResponse = htmlBuilder.toString();

            // this line is a must
            httpExchange.sendResponseHeaders(200, htmlResponse.length());

            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(htmlResponse.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
