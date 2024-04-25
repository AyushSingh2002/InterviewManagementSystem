package com.spring.interviewApp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.interviewApp.Entities.CandidateEntity;
import com.spring.interviewApp.Entities.CandidateInterviewLink;
import com.spring.interviewApp.Entities.InterviewEntity;
import com.spring.interviewApp.Entities.ResultEntity;
import com.spring.interviewApp.Repositories.InterviewRepo;
import com.spring.interviewApp.Repositories.ResultRepo;

@Service
public class InterviewService 
{
  @Autowired
  InterviewRepo interviewRepo;

  @Autowired
  ResultRepo resultRepo;

  public ResponseEntity<String> addInterview(InterviewEntity interview)
  {
    interviewRepo.save(interview);
    return new ResponseEntity<>("Interview added to database!", HttpStatus.OK);
  }

  public ResponseEntity<String> scheduleInterview(Long id, List<CandidateEntity> candidates)
  {
    Optional<InterviewEntity> optionalInterview = interviewRepo.findById(id);
    if(optionalInterview.isPresent())
    {
      InterviewEntity interview = optionalInterview.get();
      interview.setCandidates(candidates);
      interviewRepo.save(interview);
      for(CandidateEntity candidate : candidates)
      {
        ResultEntity result = new ResultEntity();
        result.setCandidateID(candidate.getId());
        result.setInterviewID(id);
        resultRepo.save(result);
      }
      return new ResponseEntity<>("Interview for the candidate list has been scheduled!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Requested details not found! Interview ID : " + id, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<ResultEntity> setResult(Long interviewId, Long candiateId, String status)
  {
    CandidateInterviewLink obj = new CandidateInterviewLink();
    obj.setCandidateID(candiateId);
    obj.setInterviewID(interviewId);
    Optional<ResultEntity> optionalResult = resultRepo.findById(obj);
    ResultEntity result = new ResultEntity();
    if(optionalResult.isPresent())
    {
      result = optionalResult.get();
      result.setResult(status);
    }
    else
    {
      result = new ResultEntity(candiateId, interviewId, status);
    }
    resultRepo.save(result);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  public ResponseEntity<List<InterviewEntity>> getAllInterviews()
  {
    List<InterviewEntity> interviews = interviewRepo.findAll();
    return new ResponseEntity<>(interviews, HttpStatus.OK);
  }
}
