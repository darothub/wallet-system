package com.example.walletsystem.asset.infrastructure.config;

import com.example.walletsystem.asset.infrastructure.respomse.CoinCapApiAssetDTO;
import com.example.walletsystem.asset.infrastructure.respomse.CoinCapApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CoinCapApiClient {

    private final RestTemplate restTemplate;

    @Value("${coincap.api.base}")
    private String API_BASE_URL;

    @Value("${coincap.api.key}")
    private String apiKey;

    public CoinCapApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, BigDecimal> getAssetPrice() {
        HashMap<String, BigDecimal> priceMap = new HashMap<>();
        URI uri = UriComponentsBuilder
                .fromUri(URI.create(API_BASE_URL))
                .queryParam("apiKey", apiKey)
                .build()
                .toUri();
        try {
            CoinCapApiResponse response = restTemplate.getForObject(uri, CoinCapApiResponse.class);
            if (response != null && response.data() != null) {
                for (CoinCapApiAssetDTO asset : response.data()) {
                    priceMap.putIfAbsent(asset.symbol(), asset.priceUsd().setScale(2, RoundingMode.HALF_UP));
                    log.info(asset.symbol() + " - $" + asset.priceUsd().setScale(2, RoundingMode.HALF_UP));
                }
            } else {
                log.error("No data found.");
            }
        } catch (RestClientException | NullPointerException e) {
            log.error(e.getMessage());
            return null;
        }
        return priceMap;
    }
}