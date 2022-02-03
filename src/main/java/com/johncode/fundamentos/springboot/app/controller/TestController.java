package com.johncode.fundamentos.springboot.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public ResponseEntity<String> testResponse() {
        return new ResponseEntity<>("hello world from TestController", HttpStatus.OK);
    }

}
