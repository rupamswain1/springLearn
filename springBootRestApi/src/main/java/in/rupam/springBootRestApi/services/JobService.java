package in.rupam.springBootRestApi.services;

import in.rupam.springBootRestApi.models.JobPosts;
import in.rupam.springBootRestApi.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    private JobRepo repo;

    public JobRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(JobRepo repo) {
        this.repo = repo;
    }

    public List<JobPosts> getAllPosts() {
        return repo.findAll();
    }

    public JobPosts getPost(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<JobPosts> addJob(JobPosts jobPost) {
       repo.save(jobPost);
       return repo.findAll();
    }

    public JobPosts updateJob(JobPosts jobPost) {
        repo.save(jobPost);
        return repo.findById(jobPost.getPostId()).orElse(null);
    }

    public boolean deleteJob(int id) {
        try{
            repo.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void loadData() {
        List<JobPosts> jobs = Arrays.asList(
            new JobPosts(1, "React Dev", "Must have exp in React", 5,  List.of("JavaScript", "React", "html", "css")),
            new JobPosts(2, "React native Dev", "Must have exp in React Native", 5,  List.of("JavaScript", "React", "html", "css","React Native"))
         );
        repo.saveAll(jobs);
    }
}
