package framework.http_server_in_jdk;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHTTPClient {
    public static class ParameterStringBuilder {
        public static String getParamsString(Map<String, String> params)
                throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        }
    }

    public static void login(CookieManager cookieManager) throws IOException {
        URL url = new URL("http://localhost:8000/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("user", "junzhai");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);


        int status = con.getResponseCode();
        String cookiesHeader = con.getHeaderField("Set-Cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);

        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
        con.disconnect();
        System.out.println("login in: " + status);
    }

    public static void talk(CookieManager cookieManager) throws IOException {
        URL url = new URL("http://localhost:8000/test");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");

        con.setRequestMethod("POST");

        con.setRequestProperty("Cookie",
                StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));

        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val-2");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);


        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println(content);
    }

    public static void main(String[] args) throws IOException {
        CookieManager cookieManager = new CookieManager();
        login(cookieManager);
        talk(cookieManager);
    }
}