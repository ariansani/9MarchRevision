package com.example.MarchRevision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/weather")
public class WeatherController {

    @GetMapping
    public String getWeather(
        @RequestParam(defaultValue = "singapore") String city,
        @RequestParam(defaultValue = "metric") String units,
        Model model
    )
    {
        model.addAttribute("city", city);
        model.addAttribute("units", units);
        return "weather";
    }

    
}
