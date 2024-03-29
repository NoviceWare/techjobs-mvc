package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model, @RequestParam String searchType, String searchTerm) {
        ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "All Jobs");
        model.addAttribute("column", searchType);
        model.addAttribute("jobs", jobs);
        return "search";
    }
}
