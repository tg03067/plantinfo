package com.green.webclientPlant.folklore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.webclientPlant.folklore.model.PlantFolkloreEntity;
import com.green.webclientPlant.folklore.model.PlantFolkloreGetReq;
import io.netty.channel.ChannelOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class WebClientPlantFolkloreService {
    private final WebClient webClient;
    private final String key;
    private final WebClientPlantFolkloreMapper mapper;

    @Autowired
    public WebClientPlantFolkloreService(@Value("${properties.key}") String key, WebClientPlantFolkloreMapper mapper) {
        this.mapper = mapper;
        HttpClient tcpClient = HttpClient.create().
                option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        ExchangeStrategies es = ExchangeStrategies.builder().
                codecs(config -> config.defaultCodecs().maxInMemorySize(-1)).
                build();
        this.webClient = WebClient.builder().
                exchangeStrategies(es).
                clientConnector(new ReactorClientHttpConnector(tcpClient)).
                defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
                build();
        this.key = key;
    }

    public List<PlantFolkloreEntity> getPlant(PlantFolkloreGetReq p) {
        System.out.println(p);
        String json = null;
        String uriString = String.format("http://openapi.nature.go.kr/openapi/service/rest/PlantService/folkSearch?serviceKey=%s&_type=%s&numOfRows=%s&pageNo=%s",
                this.key, p.getType(), p.getNumOfRows(), p.getPageNo());
        try {
            json = webClient.get().
                    uri(new URI(uriString)).
                    retrieve().
                    bodyToMono(String.class).
                    block();
            log.info("Response JSON: {}", json);
        } catch ( Exception e){
            e.printStackTrace();
            log.error("Unexpected error", e);
        }

        ObjectMapper om = new ObjectMapper().
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<PlantFolkloreEntity> testList = null;

        try{
            JsonNode node = om.readTree(json);
            testList = om.convertValue(node.at("/response/body/items/item"),
                    new TypeReference<List<PlantFolkloreEntity>>(){});
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return testList != null ? testList : Collections.emptyList();
    }

    public int insFolklorePlant(PlantFolkloreGetReq p) {
        List<PlantFolkloreEntity> list = getPlant(p);
        int result = 0;
        result = mapper.insFolklorePlant(list);
        return result;
    }
}
