package in.rupam.springBootRestApi.repository;

import in.rupam.springBootRestApi.models.JobPosts;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    public List<JobPosts> jobs = new ArrayList<>(Arrays.asList(
            new JobPosts(1, "React Dev", "Must have exp in React", 5,  List.of("JavaScript", "React", "html", "css")),
            new JobPosts(2, "React native Dev", "Must have exp in React Native", 5,  List.of("JavaScript", "React", "html", "css","React Native"))
    ));

    public List<JobPosts> getAllJobs(){
        return jobs;
    }

    public JobPosts getJob(int id) {
        JobPosts fetchJob = null;
        for(JobPosts job:jobs){
            if(job.getPostId() == id){
                fetchJob = job;
            }
        }
        return fetchJob;
    }

    public List<JobPosts> addJob(JobPosts jobPost) {
        jobs.add(jobPost);
        return jobs;
    }

    public void updateJob(JobPosts jobPost) {
        for(JobPosts job:jobs){
            if(job.getPostId() == jobPost.getPostId()){
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostDesc(jobPost.getPostProfile());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(int id) {
        jobs.remove(getJob(id));
    }
}
