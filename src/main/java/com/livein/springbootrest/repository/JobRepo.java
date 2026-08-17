package com.livein.springbootrest.repository;

import com.livein.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile, String postDesc);
}
