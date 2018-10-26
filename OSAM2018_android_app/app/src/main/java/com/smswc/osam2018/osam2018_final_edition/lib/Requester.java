package com.smswc.osam2018.osam2018_final_edition.lib;

import android.os.AsyncTask;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Requester {

    private static final String DEFAULT_URL = "http://osamapp.run.goorm.io";

    private static String get(String url, String params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(DEFAULT_URL + url + "?" + params)
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "9555f1aa-ac75-4bde-8dd1-8c5efe090088")
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    private static String post(String url, String params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, params);
        Request request = new Request.Builder()
                .url(DEFAULT_URL + url)
                .post(body)
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "8a404fb1-fd28-4301-a264-59c6a69b18e1")
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    private static class PostAsyncTask extends AsyncTask<String, String, JsonElement> {

        @Override
        protected JsonElement doInBackground(String... strings) {
            String url = strings[0];
            String params = strings[1];

            try { return new JsonParser().parse(Requester.post(url, params)); } catch (IOException e) { e.printStackTrace(); return null; }
        }
    }

    private static class GetAsyncTask extends AsyncTask<String, String, JsonElement> {

        @Override
        protected JsonElement doInBackground(String... strings) {
            String url = strings[0];
            String params = strings[1];

            try { return new JsonParser().parse(Requester.get(url, params)); } catch (IOException e) { e.printStackTrace(); return null; }
        }
    }

    public static JsonElement sendRequest(String httpMethod, String url, String params) throws ExecutionException, InterruptedException {
        if(httpMethod.equals("get")) {
            return new GetAsyncTask().execute(url, params).get();
        }
        else if(httpMethod.equals("post")) {
            return new PostAsyncTask().execute(url, params).get();
        }
        else {
            return null;
        }

    }
}
