package in.rupam.springBootRestApi;

import in.rupam.springBootRestApi.models.JobPosts;
import in.rupam.springBootRestApi.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    private JobService service;

    public JobService getService() {
        return service;
    }
    @Autowired
    public void setService(JobService service) {
        this.service = service;
    }

    @GetMapping("jobPosts")
    public List<JobPosts> hello(){
        return service.getAllPosts();
    }

    @GetMapping("jobPost/{id}")
    public JobPosts getJob(@PathVariable("id") int id){
        return service.getPost(id);
    }

    @PostMapping("jobPost")
    public List<JobPosts> addJob(@RequestBody JobPosts jobPost){
        return service.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPosts updateJob(@RequestBody JobPosts jobPost){
        return service.updateJob(jobPost);
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable("id") int id){
        boolean deleted = service.deleteJob(id);
        if(deleted){
            return "Delete Success";
        }
        return "Delete Failed";
    }
}
