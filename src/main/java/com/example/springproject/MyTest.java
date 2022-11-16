package com.example.springproject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springproject.domain.Issue;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
        String line = br.readLine();

        JSONArray jsonArray = JSON.parseArray(line);
        List<Issue> issues = new ArrayList<>();
        for (int i = 0 ; i < jsonArray.size() ; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Issue issue = new Issue();
            issue.setId(jsonObject.getIntValue("id"));
            issues.add(issue);
        }

        for (Issue issue : issues) {
            System.out.println(issue.getId());
        }
        System.out.println(issues.size());

        br.close();
    }

    public static void main(String[] args) throws IOException {

        System.out.println("此为选定仓库的各个issues的open issue的id");
        //API detail:
        //https://docs.github.com/en/rest/issues/issues#list-repository-issues
        getMethod("https://api.github.com/repos/DiUS/java-faker/issues?page=3&per_page=100");
        // page=3&per_page=100 即返回第三页，每页返回100个(最多100)
        //Username: DiUS
        //RepoName: java-faker
        //link: https://github.com/DiUS/java-faker
    }
}
