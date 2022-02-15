package com.akadow.prototype001.controller;

import com.akadow.prototype001.service.DeleteService;
import com.akadow.prototype001.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest")
public class Rest {

    private DeleteService deleteService;
    private DummyService dummyService;

    @Autowired
    private void setDeleteService(DeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @Autowired
    private void setDummyService(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    private Map<String, String> notMatchedMap = Collections.singletonMap("key", "Not Matched.");

    @GetMapping("")
    private ResponseEntity<String> first() {
        return ResponseEntity.ok("## Called rest");
    }

    @GetMapping("custom/{command}")
    private @ResponseBody ResponseEntity<Map<String, String>> customCommand(@PathVariable("command") String command) {
        Map<String, String> returnMap;
        switch (command) {
            case "dummy":
                returnMap = dummyService.createRest();
                break;
            default:
                returnMap = notMatchedMap;
        }

        return ResponseEntity.ok(returnMap);
    }

    @DeleteMapping("delete/{command}/{key}")
    private Map<String, String> delete(@PathVariable("command") String command, @PathVariable("key") String key) {
        switch (command) {
            case "excludedChorusMap":
                return deleteService.excludedChorusMap(key);
            default:
                return notMatchedMap;
        }
    }

}
