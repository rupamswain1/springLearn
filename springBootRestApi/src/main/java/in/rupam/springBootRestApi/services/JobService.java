package in.rupam.springBootRestApi.services;

import in.rupam.springBootRestApi.models.JobPosts;
import in.rupam.springBootRestApi.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
        return repo.getAllJobs();
    }

    public JobPosts getPost(int id) {
        return repo.getJob(id);
    }

    public List<JobPosts> addJob(JobPosts jobPost) {
        return repo.addJob(jobPost);
    }

    public JobPosts updateJob(JobPosts jobPost) {
        repo.updateJob(jobPost);
        return repo.getJob(jobPost.getPostId());
    }

    public boolean deleteJob(int id) {
        try{
            repo.deleteJob(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
