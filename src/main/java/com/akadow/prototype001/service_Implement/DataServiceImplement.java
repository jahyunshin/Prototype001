package com.akadow.prototype001.service_Implement;

import com.akadow.prototype001.service.DataService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataServiceImplement implements DataService {
    public Map<String, String> chorusMap() {
        return new HashMap<>() {{
            put("1", "개미는 아무 말도 하지 않지만");
            put("2", "땀을 뻘뻘 흘리면서");
            put("3", "매일 매일을 살아가길 위해");
            put("4", "열심히 일하네");
        }};
    }
}
