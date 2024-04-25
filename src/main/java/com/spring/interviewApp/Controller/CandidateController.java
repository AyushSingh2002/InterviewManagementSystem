package com.spring.interviewApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.interviewApp.Entities.CandidateEntity;
import com.spring.interviewApp.Services.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController 
{
  @Autowired
  CandidateService candidateService;

  @PostMapping("/add-candidate")
  public ResponseEntity<String> addCandidate(@RequestBody CandidateEntity candidate)
  {
    return candidateService.addCandidate(candidate);
  }  

  @PutMapping("/add-resume/{id}")
  public ResponseEntity<CandidateEntity> addResume(@PathVariable("id") Long id, @RequestBody String resume)
  {
    return candidateService.addCandidateResume(id, resume);
  }

  @GetMapping("/get-all-candidates")
  public ResponseEntity<List<CandidateEntity>> getAllCandidates()
  {
    return candidateService.getAllCandidates();
  }

  @PutMapping("/update-by-id/{id}")
  public ResponseEntity<String> updateCandidate(@PathVariable("id") Long id, @RequestBody CandidateEntity updatedCandidate)
  {
    return candidateService.updateCandidateById(id, updatedCandidate);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public ResponseEntity<String> deleteCandidate(@PathVariable("id") Long id)
  {
    return candidateService.deleteById(id);
  }
}
