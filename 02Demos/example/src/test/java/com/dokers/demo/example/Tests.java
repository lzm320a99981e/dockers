package com.dokers.demo.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
