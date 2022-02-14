package com.akadow.prototype001.controller;

import com.akadow.prototype001.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value="/rest")
public class Rest {

    private DummyService dummyService;

    @Autowired
    void setDummyService(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping("")
    public ResponseEntity<String> first() {
        return ResponseEntity.ok("## Called rest");
    }

    @GetMapping("custom/{command}")
    public @ResponseBody ResponseEntity<Map<String, String>> customCommand(@PathVariable("command") String command) {
        Map<String, String> returnMap;
        switch (command) {
            case "dummy":
                returnMap = dummyService.createRest();
                break;
            default:
                returnMap = Collections.singletonMap("key", "Not Matched.");
        }

        return ResponseEntity.ok(returnMap);
    }

}
