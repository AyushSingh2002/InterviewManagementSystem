package com.spring.interviewApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.interviewApp.Entities.ResultEntity;
import com.spring.interviewApp.Services.CandidateService;

@RestController
@RequestMapping("/result")
public class ResultController 
{
  @Autowired
  CandidateService candidateService;

  @GetMapping("/get-candidate-result/{candidateId}/{interviewId}")
  public ResponseEntity<ResultEntity> getCandidateResult(@PathVariable("candidateId") Long cId, @PathVariable("interviewId") Long iId)
  {
    return candidateService.getCandidateResult(cId, iId);
  }
}
