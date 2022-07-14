package com.plateer.ec1.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Configuration
@Slf4j
public class ConnectionUtil {

    public static <T> String httpRequest(String url, String path, T o){
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .path(path)
                .encode()
                .build()
                .toUri();

        MultiValueMap mvMap = ConvertUtil.convertVoToMap(o);

        RequestEntity requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(mvMap);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        return response.getBody();
    }
}
