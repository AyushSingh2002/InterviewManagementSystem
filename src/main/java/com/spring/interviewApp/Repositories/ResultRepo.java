package com.spring.interviewApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.interviewApp.Entities.CandidateInterviewLink;
import com.spring.interviewApp.Entities.ResultEntity;

public interface ResultRepo extends JpaRepository<ResultEntity, CandidateInterviewLink>
{

}
