package org.example.exam.controller;

import org.example.exam.service.user.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home-page")
class UserController {
    private final ProgramService programService;

    @Autowired
    public UserController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("programs", programService.findAll());
        return "home";
    }
}