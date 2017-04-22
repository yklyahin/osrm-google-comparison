package com.lobotomist.geo.comparsion.Api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;

public class JsonClient {

    private Gson serializer = new Gson();
    private OkHttpClient client = new OkHttpClient();

    public JsonClient() {}

    public JsonClient(OkHttpClient client) {
        this.client = client;
    }

    public <T> T doRequest(String url, Class<T> type) throws IOException {
        Request request = new Request.Builder().url(url).build();
        return doRequest(request, type);
    }

    public <T> T doRequest(Request request, Class<T> type) throws IOException {
        Response response = client.newCall(request).execute();
        return serializer.fromJson(response.body().string(), type);
    }
}