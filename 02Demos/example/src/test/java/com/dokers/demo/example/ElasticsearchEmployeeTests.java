package com.dokers.demo.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class ElasticsearchEmployeeTests {

    @Autowired
    private RestHighLevelClient client;

    @Test
    void testIndexApi() throws IOException {
        final Map<String, Object> source = Maps.newHashMap();
        source.put("user", "kimchy");
        source.put("postDate", new Date());
        source.put("message", "trying out Elasticsearch");
        final IndexRequest indexRequest = new IndexRequest("employees", "doc");
        indexRequest.source(source);

        final IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(indexResponse, true));
    }

    @Test
    void testGetApi() throws IOException {
        final GetRequest request = new GetRequest("employees", "doc", "DEREG24B_76fhNV5LOAE");
        final GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response, true));
    }
}
