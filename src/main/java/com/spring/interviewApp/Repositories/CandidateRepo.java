package com.spring.interviewApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.interviewApp.Entities.CandidateEntity;

public interface CandidateRepo extends JpaRepository<CandidateEntity, Long> 
{
  
}
