package com.api.col_trendsback.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.col_trendsback.services.BigQueryService;
import com.api.col_trendsback.utils.QueryResponse;

@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "http://localhost:5173/")
public class GetDataController {
    @Autowired
    BigQueryService _bigQueryService;
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getData() {
        
        try {
            return ResponseEntity.status(HttpStatus.OK)
                .header(null)
                .body(_bigQueryService.executeQuery());

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

