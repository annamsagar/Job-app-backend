package com.livein.springbootrest;


import com.livein.springbootrest.model.JobPost;
import com.livein.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postid}")
    public JobPost getJob(@PathVariable("postid")int postid){
        return service.getJob(postid);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost job){
        service.addJob(job);
        return service.getJob(job.getPostid());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job){
        service.updateJob(job);
        return service.getJob(job.getPostid());
    }

    @DeleteMapping("jobPost/{postid}")
    public String deleteJob(@PathVariable("postid")int postid){
        service.deleteJob(postid);
        return "success";
    }
}
