package com.livein.springbootrest.service;

import com.livein.springbootrest.model.JobPost;
import com.livein.springbootrest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repository;

    public void addJob(JobPost jobpost){

        repository.addJob(jobpost);
    }

    public List<JobPost> getAllJobs(){
        return repository.getAllJobs();
    }

    public JobPost getJob(int postid) {
        return repository.getJob(postid);
    }

    public void updateJob(JobPost job) {
        repository.updateJob(job);
    }

    public void deleteJob(int postid) {
        repository.deleteJob(postid);
    }
}
