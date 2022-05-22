package tasks.classwork21day;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import tasks.classwork20day.MyParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MyHttpClient {

    public void httpGet() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://api.nbp.pl/api/cenyzlota/");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    public void search(Search search) throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws");
        HttpPost request = new HttpPost(builder.build());
        request.setEntity(new StringEntity(MyParser.fromGSON2(search)));
        HttpResponse response = client.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));

    }
}
