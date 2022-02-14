package com.akadow.prototype001.service_Implement;

import com.akadow.prototype001.service.DataService;
import com.akadow.prototype001.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DeleteServiceImplement implements DeleteService {

    private DataService dataService;

    @Autowired
    private void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public Map<String, String> excludedChorusMap(String key) {
        return Optional.ofNullable(dataService.chorusMap())
                .map(map -> {
                    map.remove(key);
                    return map;
                }).orElseGet(HashMap::new);
    }
}
