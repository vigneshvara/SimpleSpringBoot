package com.example.demo.Service;

import com.example.demo.Dao.QuestionDao;
import com.example.demo.Entity.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Questions> getAllQuestion() {
        return questionDao.findAll();
    }

    public Questions addQuestion(Questions questions) {
        return questionDao.save(questions);
    }

    public void deleteQuestionById(Integer id) {
        questionDao.deleteById(id);
    }

    public List<Questions> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public void update(Questions questions) {
         questionDao.save(questions);
    }

    public Questions randomQuestion() {
        int random = (int)(Math.random()* getAllQuestion().size())+1;
        return questionDao.findAllById(random);
    }
}