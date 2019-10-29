//package com.dokers.demo.example.configuration;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//@Configuration
//@EnableConfigurationProperties(ElasticsearchProperties.class)
//public class ElasticsearchConfiguration1 {
//
//    @Autowired
//    private ElasticsearchProperties properties;
//
//    @Bean
//    public TransportClient transportClient() throws UnknownHostException {
//
//        final Settings.Builder builder = Settings.builder().put("cluster.name", properties.getClusterName());
//        properties.getProperties().forEach(builder::put);
//        final Settings settings = builder.build();
//
//        final String clusterNodes = properties.getClusterNodes();
//        final String[] hostWithPort = clusterNodes.split(":");
//        final TransportAddress address = new TransportAddress(InetAddress.getByName(hostWithPort[0]), Integer.valueOf(hostWithPort[1]));
//
//        return new PreBuiltXPackTransportClient(settings).addTransportAddress(address);
//    }
//}
