package com.akadow.prototype001.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/echo")
public class Echo {

    @GetMapping("")
    public @ResponseBody String first() {
        return "## Called echo";
    }

    @PostMapping("custom/{command}")
    public @ResponseBody String customCommand(@PathVariable("command") String command) {
        return "## Called : " + command;
    }
}
