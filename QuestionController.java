package com.example.demo.Controller;

import com.example.demo.Entity.Questions;
import com.example.demo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestion")
    public List<Questions> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Questions> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Questions questions){
        questionService.addQuestion(questions);
        return "success";
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String deleteQuestionById(@PathVariable Integer id){
        questionService.deleteQuestionById(id);
        return "deleted";
    }

    @PostMapping("update")
    public String update(Questions questions){
        questionService.update(questions);
        return "updated";
    }

    @GetMapping("randomQuestion")
    public Questions randomQuestion(){
        return questionService.randomQuestion();
    }
}
