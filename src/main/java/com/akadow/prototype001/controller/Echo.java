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

    @GetMapping("")
    public String first() {
        return "## Called echo";
    }//omitted @ResponseBody

    @GetMapping("custom/{command}")
    public @ResponseBody Map<String, String> customCommand(@PathVariable("command") String command) {
        Map<String, String> returnMap = new HashMap<>();
        switch (command) {
            case "dummy":
                return dummyService.createEcho();
            case "none":
                return Collections.singletonMap("key", "Not Matched.");
            default:
                return new HashMap<>();
        }
    }

}
