package com.spring.interviewApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.interviewApp.Entities.CandidateEntity;
import com.spring.interviewApp.Entities.InterviewEntity;
import com.spring.interviewApp.Entities.ResultEntity;
import com.spring.interviewApp.Services.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController 
{
  @Autowired
  InterviewService interviewService;

  @PostMapping("add-interview")
  public ResponseEntity<String> addInterview(@RequestBody InterviewEntity interview)
  {
    return interviewService.addInterview(interview);
  }

  @PutMapping("schedule-interview-by-id/{id}")
  public ResponseEntity<String> scheduleInterview(@PathVariable("id") Long id, @RequestBody List<CandidateEntity> candidates)
  {
    return interviewService.scheduleInterview(id, candidates);
  }

  @PutMapping("set-candidate-result/{interviewId}/{candidateId}")
  public ResponseEntity<ResultEntity> setResult(@PathVariable("interviewId") Long iId, @PathVariable("candidateId") Long cId, @RequestBody String status)
  {
    return interviewService.setResult(iId, cId, status);
  }

  @GetMapping("/get-all-interviews")
  public ResponseEntity<List<InterviewEntity>> getAllInterviews()
  {
    return interviewService.getAllInterviews();
  }
}
