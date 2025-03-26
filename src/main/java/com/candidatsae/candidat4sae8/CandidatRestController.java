package com.candidatsae.candidat4sae8;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestController {

    private String title = "Hello from candidat MS SAE6";

    @Autowired
    private CandidatService candidatService;


    @GetMapping("/{id}/favorite-jobs")
    public List<Job> getFavoriteJobs(@PathVariable int id) {
        return candidatService.getFavoriteJobs(id);
    }


    @PostMapping("/{id}/favorite-jobs/{jobId}")
    public ResponseEntity<String> saveFavoriteJob(@PathVariable int id, @PathVariable
    int jobId) {
        Job job = candidatService.getJobById(jobId);
        if (job != null) {
            candidatService.saveFavoriteJob(id, jobId);
            return ResponseEntity.status(HttpStatus.OK).body("Job saved as favorite successfully.");
        } else {
            // Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job not found with ID: " + jobId);
        }
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return candidatService.getallJobs();
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable("id") int id) {
        return candidatService.getJobById(id);
    }

    @RequestMapping("/hello")
    public String sayHello() {
        return title;
    }


    @PostMapping
    public Candidat saveCandidat(@RequestBody Candidat candidat) {
        return candidatService.saveCandidat(candidat);
    }


    @GetMapping
    public List<Candidat> getCandidats() {
        return candidatService.getAllCandidats();
    }


    @GetMapping("/{id}")
    public Candidat getCandidatById(@PathVariable int id) {
        return candidatService.getCandidatById(id);
    }

    @PutMapping
    public Candidat updateCandidat(@RequestBody Candidat candidat) {
          return candidatService.updateCandidat(candidat);
    }



    @DeleteMapping("/{id}")
    public Candidat deleteCandidat(@PathVariable int id) {
        return candidatService.deleteCandidat(id);
    }
}
