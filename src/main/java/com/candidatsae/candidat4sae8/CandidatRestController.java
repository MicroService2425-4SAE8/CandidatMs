package com.candidatsae.candidat4sae8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestController {

    private String title = "Hello from candidat MS SAE6";

    @Autowired
    private CandidatService candidatService;


    @RequestMapping("/hello")
    public String sayHello() {
        return title;
    }



    @PreAuthorize("hasRole('user')")
    @PostMapping(value = "/user")
    public Candidat saveCandidat(@RequestBody Candidat candidat) {
        return candidatService.saveCandidat(candidat);
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping(value = "/admin")
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
