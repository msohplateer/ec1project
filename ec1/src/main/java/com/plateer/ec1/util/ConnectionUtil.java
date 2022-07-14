package com.plateer.ec1.util;

import com.plateer.ec1.payment.vo.InicisGetVrAcctNoReqVo;
import com.plateer.ec1.payment.vo.InicisGetVrAcctNoResVo;
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

    public InicisGetVrAcctNoResVo getInicisVrAcctNoHttpRequest(String url, String path, InicisGetVrAcctNoReqVo reqVo){
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .path(path)
                .encode()
                .build()
                .toUri();

        MultiValueMap mvMap = ConvertUtil.convertVoToMap(reqVo);

        RequestEntity requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(mvMap);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);
        InicisGetVrAcctNoResVo resVo = ConvertUtil.convertJsonToVo(response.getBody(), InicisGetVrAcctNoResVo.class);
        return resVo;
    }
}
