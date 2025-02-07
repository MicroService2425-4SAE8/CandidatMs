package com.candidatsae.candidat4sae8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService implements ICandidat {

    @Autowired
    private CandidatRepository candidatRepository;

    @Override
    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }



    @Override
    public Candidat deleteCandidat(int id) {
         Optional<Candidat> candidatOptional = candidatRepository.findById(id);

        if (candidatOptional.isPresent()) {
            Candidat candidat = candidatOptional.get();
            candidatRepository.delete(candidat);
            return candidat;
        } else {
            throw new IllegalArgumentException("Candidat with id " + id + " not found.");
        }
    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        if (candidatRepository.existsById(candidat.getId())) {
            return candidatRepository.save(candidat);  // Save the updated Candidat, ID remains unchanged
        } else {
            throw new IllegalArgumentException("Candidat with id " + candidat.getId() + " not found.");
        }
    }

    @Override
    public Candidat getCandidatById(int id) {
        Optional<Candidat> candidatOptional = candidatRepository.findById(id);
        return candidatOptional.orElseThrow(() -> new IllegalArgumentException("Candidat with id " + id + " not found."));
    }

    @Override
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }
}
