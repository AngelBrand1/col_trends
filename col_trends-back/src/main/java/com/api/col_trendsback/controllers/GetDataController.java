package com.api.col_trendsback.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.col_trendsback.services.BigQueryService;
import com.api.col_trendsback.utils.QueryParameters;

@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "http://localhost:9000/")
public class GetDataController {
    @Autowired
    BigQueryService _bigQueryService;
                
    @PostMapping("/execute")
    @ResponseBody
    public ResponseEntity<String> createQuery(@RequestBody QueryParameters queryParameters) {
        String query = _bigQueryService.buildQuery(queryParameters);
        try {
            return ResponseEntity.status(HttpStatus.OK)
                .header(null)
                .body(_bigQueryService.executeQuery(query));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

