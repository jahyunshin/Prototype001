package com.akadow.prototype001.controller;

import com.akadow.prototype001.service.DummyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="echo")
public class Echo {

    final private DummyService dummyService;

    private Echo(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    private final Map<String, String> notMatchedMap = Collections.singletonMap("key", "Not Matched.");

    @GetMapping("")
    private String first() {
        return "## Called echo";
    }//omitted @ResponseBody

    @GetMapping("custom/{command}")
    private @ResponseBody Map<String, String> customCommand(@PathVariable("command") String command) {
        switch (command) {
            case "dummy":
                return dummyService.createEcho();
            case "none":
                return notMatchedMap;
            default:
                return new HashMap<>();
        }
    }

}
