package com.spring.interviewApp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.interviewApp.Entities.CandidateEntity;
import com.spring.interviewApp.Entities.CandidateInterviewLink;
import com.spring.interviewApp.Entities.ResultEntity;
import com.spring.interviewApp.Repositories.CandidateRepo;
import com.spring.interviewApp.Repositories.InterviewRepo;
import com.spring.interviewApp.Repositories.ResultRepo;

@Service
public class CandidateService 
{
  @Autowired
  CandidateRepo candidateRepo;

  @Autowired
  InterviewRepo interviewRepo;

  @Autowired
  ResultRepo resultRepo;

  public ResponseEntity<String> addCandidate(CandidateEntity candidate)
  {
    candidateRepo.save(candidate);
    return new ResponseEntity<>("Candidate added to database!", HttpStatus.OK);
  }

  public ResponseEntity<List<CandidateEntity>> getAllCandidates()
  {
    List<CandidateEntity> candidates = candidateRepo.findAll();
    return new ResponseEntity<>(candidates, HttpStatus.OK);
  }

  public ResponseEntity<String> updateCandidateById(Long id, CandidateEntity updatedCandidate)
  {
    Optional<CandidateEntity> optionalCandidate = candidateRepo.findById(id);
    if(optionalCandidate.isPresent())
    {
      CandidateEntity candidate = optionalCandidate.get();
      candidate.setName(updatedCandidate.getName());
      candidate.setContact(updatedCandidate.getContact());
      candidate.setResume(updatedCandidate.getResume());
      candidate.setInterviews(updatedCandidate.getInterviews());
      candidateRepo.save(candidate);
      return new ResponseEntity<>("Candidate details updated successfully!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Candidate not found! Candidate ID : " + id, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<String> deleteById(Long id)
  {
    Optional<CandidateEntity> optionalCandidate = candidateRepo.findById(id);
    if(optionalCandidate.isPresent())
    {
      candidateRepo.deleteById(id);
      return new ResponseEntity<>("Candidate details removed sucessfully!", HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>("Candidate not found! Candidate ID : " + id, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<ResultEntity> getCandidateResult(Long candidateId, Long interviewId)
  {
    CandidateInterviewLink obj = new CandidateInterviewLink();
    obj.setCandidateID(candidateId);
    obj.setInterviewID(interviewId);
    Optional<ResultEntity> optionalResult = resultRepo.findById(obj);
    if(optionalResult.isPresent())
    {
      return new ResponseEntity<>(optionalResult.get(), HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  public ResponseEntity<CandidateEntity> addCandidateResume(Long id, String resume)
  {
    Optional<CandidateEntity> optionalCandidate = candidateRepo.findById(id);
    if(optionalCandidate.isPresent())
    {
      CandidateEntity candidate = optionalCandidate.get();
      candidate.setResume(resume);
      candidateRepo.save(candidate);
      return new ResponseEntity<>(candidate, HttpStatus.OK);
    }
    else
    {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }
}
