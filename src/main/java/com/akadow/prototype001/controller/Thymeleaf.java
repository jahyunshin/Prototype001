package com.akadow.prototype001.controller;

import com.akadow.prototype001.service.DummyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping(value="page")
public class Thymeleaf {

    public DummyService dummyService;

    @Autowired
    public void setDummyService(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping("sample")
    public String sample(Model model) {
        model.addAllAttributes(dummyService.createThymeleaf());
        log.info("dummyService.createThymeleaf() : " + dummyService.createThymeleaf());
        return "sample";
    }

}
