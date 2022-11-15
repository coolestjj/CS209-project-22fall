package com.example.springproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyTest {

    /**
     * @description Print the raw json
     * @author Jiajun Li
     * @param url
     * @throws IOException
     */
    public static void getMethod(String url) throws IOException {
        URL restURL = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

        conn.setRequestMethod("GET"); // POST GET PUT DELETE
        conn.setRequestProperty("Accept", "vnd.github+json");

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {

        //API detail:
        //https://docs.github.com/en/rest/issues/issues#list-repository-issues
        getMethod("https://api.github.com/repos/DiUS/java-faker/issues");
        //Username: DiUS
        //RepoName: java-faker
        //link: https://github.com/DiUS/java-faker
    }
}
