package com.an.quizapp.services;

import com.an.quizapp.dao.QuestionDao;
import com.an.quizapp.entities.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Questions> getAllQuestions() {
        return questionDao.findAll();
    }
    public List<Questions> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Questions question) {
        questionDao.save(question);
        return "success";
    }

    public String deleteQuestion(Integer id) {
        questionDao.deleteById(id);
        return "deleted";
    }

    public String updateQuestion(Questions question) {
        Optional<Questions> questionObjUpdate=questionDao.findById(question.getId());
        if(questionObjUpdate.isPresent()){
            Questions questionObj=setAllProperties(questionObjUpdate.get(),question);
            questionDao.save(questionObj);
        }
        return "updated";
    }

    private Questions setAllProperties(Questions oldQuestionObj,Questions newQuestionObj) {
        return new Questions().builder()
                .id(oldQuestionObj.getId())
                .questionTitle(newQuestionObj.getQuestionTitle())
                .difficultyLevel(newQuestionObj.getDifficultyLevel())
                .option1(newQuestionObj.getOption1())
                .option2(newQuestionObj.getOption2())
                .option3(newQuestionObj.getOption3())
                .option4(newQuestionObj.getOption4())
                .rightAnswer(newQuestionObj.getRightAnswer())
                .category(newQuestionObj.getCategory()).build();

    }
}
