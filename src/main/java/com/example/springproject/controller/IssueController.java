package com.example.springproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springproject.mapper.IssueMapper;
import com.example.springproject.entity.Issue;
import com.example.springproject.service.IssueService;
import com.example.springproject.service.impl.IssueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

//    @Autowired
//    private IssueMapper issueMapper;

    @Autowired
    private IssueService issueService;

    @GetMapping("/store-issues")
    public int storeIssues(@RequestParam String url) throws IOException {
        System.out.println(url);
        issueService.insertIssues(getRawJson(url));
        return 1;
    }

    @GetMapping("/get-open-issues")
    public ArrayList<Integer> getOpenIssues() {
        List<Issue> issues;
        issues = issueService.getIssueByState("open");

        ArrayList<Integer> issueIds = new ArrayList<>();
        for (Issue issue : issues) {
            issueIds.add(issue.getId());
        }
        System.err.println("issueIds length: " + issueIds.size());
        return issueIds;
    }

    @GetMapping("/get-close-issues")
    public ArrayList<Integer> getCloseIssues() {
        List<Issue> issues;
        issues = issueService.getIssueByState("closed");

        ArrayList<Integer> issueIds = new ArrayList<>();
        for (Issue issue : issues) {
            issueIds.add(issue.getId());
        }
        System.err.println("issueIds length: " + issueIds.size());
        return issueIds;
    }

    public List<Issue> getRawJson(String url) throws IOException {

        int pageNum = 0;
        String rawJson = "";
        List<Issue> issues = new ArrayList<>();

        while(!rawJson.equals("[]")) {
            pageNum++;
            String urlWithPage = url + "&page=" + pageNum;

            URL restURL = new URL(urlWithPage);

            HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

            conn.setRequestMethod("GET"); // POST GET PUT DELETE
            conn.setRequestProperty("Accept", "vnd.github+json");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            rawJson = br.readLine();
            br.close();
            JSONArray jsonArray = JSON.parseArray(rawJson);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Issue issue = new Issue();
                issue.setId(jsonObject.getIntValue("id"));
                issue.setState(jsonObject.getString("state"));
                issues.add(issue);
            }
        }
        System.out.println(issues.size());
        return issues;
    }

//    public static void main(String[] args) throws IOException {
//        getRawJson("https://api.github.com/repos/DiUS/java-faker/issues?per_page=100");
//    }
}
