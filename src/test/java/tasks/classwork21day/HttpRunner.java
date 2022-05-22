package tasks.classwork21day;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpRunner {
    public static void main(String[] args) throws URISyntaxException, IOException {

        MyHttpClient httpClient = new MyHttpClient();
        //httpClient.httpGet();

        Search search = new Search("alberto", true);
        httpClient.search(search);

    }
}
