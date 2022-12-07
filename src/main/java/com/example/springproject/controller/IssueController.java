package com.example.springproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springproject.entity.Issue;
import com.example.springproject.service.IssueService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/store-issues")
    public String storeIssues(@RequestParam String url) throws IOException {
        List<Issue> issues = getRawJson(url);
        if (issues.size() != 0) {
            issueService.insertIssues(issues);
            return "Issues stored";
        }
        return "No issue";
    }

    @GetMapping("/get-open-issues")
    public int getOpenIssues() {
        return issueService.getIssueByState("open");
    }

    @GetMapping("/get-close-issues")
    public int getCloseIssues() {
        return issueService.getIssueByState("closed");
    }

    @GetMapping("/get-solveTime-avg")
    public double getSolveTimeAVG() {
        return issueService.getSolveTimeAVG();
    }

    @GetMapping("/get-solveTime-max")
    public double getSolveTimeMAX() {
        return issueService.getSolveTimeMAX();
    }

    @GetMapping("/get-solveTime-stddev")
    public double getSolveTimeSTDDEV() {
        return issueService.getSolveTimeSTDDEV();
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
            // Bearer后面为授权用的github token，请改成自己用的
            conn.setRequestProperty("authorization", "Bearer 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");
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
                issue.setCreate_date(jsonObject.getSqlDate("created_at"));
                issue.setClose_date(jsonObject.getSqlDate("closed_at"));
                issues.add(issue);
            }
        }
        System.out.println(issues.size());
        return issues;
    }
}
