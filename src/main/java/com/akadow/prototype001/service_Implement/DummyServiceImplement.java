package com.akadow.prototype001.service_Implement;

import com.akadow.prototype001.service.DummyService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DummyServiceImplement implements DummyService {

    public Map<String, String> createEcho() {
        return new HashMap<>() {{
            put("exampleKey1", "개미는 뚠뚠");
            put("exampleKey2", "오늘도 뚠뚠");
            put("exampleKey3", "열심히 일을 하네. 뚠뚠.");
        }};
    }

    public Map<String, String> createRest() {
        return new HashMap<>() {{
            put("exampleKey1", "한치 앞도 뚠뚠");
            put("exampleKey2", "모르는 뚠뚠");
            put("exampleKey3", "험한 이 세상. 뚠뚠.");
        }};
    }

    public Map<String, String> createThymeleaf() {
        return new HashMap<>() {{
            put("name", "이름입니다.");
        }};
    }
}
