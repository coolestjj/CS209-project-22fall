package com.example.springproject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springproject.entity.Release;
import com.example.springproject.entity.ReleaseAndCommitNum;
import com.example.springproject.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/release")
public class ReleaseController {

  @Autowired
  private ReleaseService releaseService;

  @GetMapping("/store-releases")
  public String storeReleases(@RequestParam String url) throws IOException {
    List<Release> releases = getRawJson(url);
    if (releases.size() != 0) {
      releaseService.insertReleases(releases);
      return "Releases stored";
    }
    return "No Release";
  }

  @GetMapping("/get-releases")
  public int getReleases() {
    return releaseService.getReleases();
  }

  @GetMapping("/get-commits-preRelease")
  public List<ReleaseAndCommitNum> getCommitsBeforeReleases() {
    List<ReleaseAndCommitNum> initialList = releaseService.getCommitsBeforeReleases();
    List<ReleaseAndCommitNum> resultList = new ArrayList<>();
    for (int i = 0; i < initialList.size(); i++) {
      ReleaseAndCommitNum releaseAndCommitNum;
      if (i == 0) {
        releaseAndCommitNum = new ReleaseAndCommitNum();
        releaseAndCommitNum.setReleaseId(initialList.get(i).getReleaseId());
        releaseAndCommitNum.setCommitNum(initialList.get(i).getCommitNum());
      } else {
        releaseAndCommitNum = new ReleaseAndCommitNum();
        releaseAndCommitNum.setCommitNum(
            initialList.get(i).getCommitNum() - initialList.get(i - 1).getCommitNum());
        releaseAndCommitNum.setReleaseId(initialList.get(i).getReleaseId());
      }
      resultList.add(releaseAndCommitNum);
    }
    return resultList;
  }

  public List<Release> getRawJson(String url) throws IOException {
    int pageNum = 0;
    String rawJson = "";
    List<Release> releases = new ArrayList<>();

    while (!rawJson.equals("[]")) {
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
        Release release = new Release();
        release.setId(jsonObject.getIntValue("id"));
        release.setPublish_time(jsonObject.getTimestamp("published_at"));
        releases.add(release);
      }
    }
    System.out.println(releases.size());
    return releases;
  }
}
