package com.plateer.ec1.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class ConvertUtil {
    public static <T> MultiValueMap<String, String> convertVoToMap(T t){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.convertValue(t, new TypeReference<Map<String, String>>() {});
        MultiValueMap<String, String> mvMap = new LinkedMultiValueMap<>();
        mvMap.setAll(map);
        return mvMap;
    }

    public static <T> T convertJsonToVo(String str, Class<T> type){
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
}
