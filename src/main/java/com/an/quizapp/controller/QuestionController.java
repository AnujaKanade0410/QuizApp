package com.an.quizapp.controller;

import com.an.quizapp.entities.Questions;
import com.an.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Questions> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){

        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Questions question){

        return questionService.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Integer id){

        return questionService.deleteQuestion(id);
    }

    @PutMapping("updateQuestion")
    public String updateQuestion(@RequestBody Questions question){

        return questionService.updateQuestion(question);
    }
}