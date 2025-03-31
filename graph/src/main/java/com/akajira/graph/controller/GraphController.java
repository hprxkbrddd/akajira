package com.akajira.graph.controller;

import com.akajira.graph.dto.GraphDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/akajira/graph")
public class GraphController {

    @GetMapping("/user/{id}")
    public ResponseEntity<List<GraphDto>> getTasksOfUser(@PathVariable Long id){
        // жбжбжбжбжбжбжб
    }
}
