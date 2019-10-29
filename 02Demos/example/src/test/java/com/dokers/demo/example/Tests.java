package com.dokers.demo.example;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tests {

    @Test
    void test() {
        // https://www.bilibili.com/video/av66639463/?p=23
        String urlTemplate = "https://www.bilibili.com/video/av66639463/?p=%s";
        List<String> urls = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            urls.add(String.format(urlTemplate, i));
        }
        System.out.println(String.join(" ", urls));
    }

    @Test
    void testJsoup() throws IOException {
        final String baseUrl = "https://www.example.com";
        String body = Jsoup.connect(baseUrl + "/categories").execute().body();
        Elements elements = Jsoup.parse(body).body().select("ul#categoriesListSection>li>div>h5>a");
        List<Category> categories = elements.stream().map(item -> {
            String href = item.attr("href");
            String name = item.select("strong").text();
            Integer videoCount = Integer.valueOf(item.select("span").text().replaceAll("[^\\d]+", ""));
            return Category.builder().url(baseUrl + href).name(name).videoCount(videoCount).build();
        }).collect(Collectors.toList());
//        Category category = categories.stream().filter(item -> item.getName().equals("Japanese")).collect(Collectors.toList()).get(0);
    }

    @Test
    void testCategory() throws IOException {
        final String baseUrl = "https://www.example.com";
        final String categoryUrl = "https://www.example.com/video?c=111";
        Element body = Jsoup.connect(categoryUrl).execute().parse().body();
        List<Video> videos = body.select("ul#videoCategory>li.videoBox").stream().map(item -> {
            String id = item.attr("id");
            String vkey = item.attr("_vkey");
            Elements a = item.select("div.phimage a");
            String url = baseUrl + a.attr("href");
            String title = a.attr("title");
            String imgUrl = a.select("img").attr("data-thumb_url");
            String duration = item.select("div.phimage var.duration").text();
            String views = item.select("span.views var").text();
            int rating = Integer.parseInt(item.select("div.rating-container div.value").text().replace("%", ""));
            String added = item.select("var.added").text();

            return Video.builder().id(id).vkey(vkey).url(url).title(title).imgUrl(imgUrl).duration(duration).views(views).rating(rating).added(added).build();
        }).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(videos, true));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Category {
        private String name;
        private int videoCount;
        private String url;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Video {
        // ID
        private String id;
        // 标题
        private String title;
        // 观看次数
        private String views;
        // 评分
        private int rating;
        // 以添加时间
        private String added;
        // 地址
        private String url;
        private String vkey;
        private String imgUrl;
        private String duration;
    }
}
