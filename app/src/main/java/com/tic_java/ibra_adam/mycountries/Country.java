package com.tic_java.ibra_adam.mycountries;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by IbraD00 & Adm94 on 28/04/2016.
 */
public class Country {
    private final OkHttpClient client = new OkHttpClient();
    protected static CountryType[] data;
    private final Gson gson = new Gson();

    public CountryType[] run() throws Exception {
        Request request = new Request.Builder()
                .url("https://restcountries-v1.p.mashape.com/all")
                .header("X-Mashape-Key", "BD4xOiVqPumshYypkX11bqtcVsiap1h1abZjsnShGKIuzED3cY")
                .addHeader("Accept", "application/json;")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                Reader stream = response.body().charStream();

                Country.data = gson.fromJson(stream, CountryType[].class);
            }
        });

        return Country.data;
    }

    static class CountryType {
        String name;
        String capital;
    }
}
