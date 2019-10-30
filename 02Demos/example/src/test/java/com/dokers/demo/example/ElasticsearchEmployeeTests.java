package com.dokers.demo.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
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
//        client.index()

        final Map<String, Object> source = Maps.newHashMap();
        source.put("user", "kimchy");
        source.put("postDate", new Date());
        source.put("message", "trying out Elasticsearch");
        final IndexRequest indexRequest = new IndexRequest("employee");
        indexRequest.source(source);

        final IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(indexResponse, true));

    }
}
