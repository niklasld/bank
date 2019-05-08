package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DijkstraController {
    @GetMapping("/dijkstra")
    public String getDijkstra() {
        return "dijkstra";
    }
}
