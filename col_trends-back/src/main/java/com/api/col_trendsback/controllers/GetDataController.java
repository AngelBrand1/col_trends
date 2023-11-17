package com.api.col_trendsback.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.col_trendsback.services.BigQueryService;

@RestController
@RequestMapping("/api/data")
public class GetDataController {
    @Autowired
    BigQueryService _bigQueryService;
    @GetMapping
    public String getData() {
        String res;
        try {
            res =_bigQueryService.executeQuery();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            res = null;
        }
        return res;
    }
}

