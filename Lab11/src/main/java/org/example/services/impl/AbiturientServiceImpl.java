package org.example.services.impl;

import org.example.entities.Abiturient;
import org.example.repositories.AbiturientRepo;
import org.example.services.AbiturientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AbiturientServiceImpl implements AbiturientService {
    private AbiturientRepo abiturientRepo;

    public AbiturientServiceImpl(AbiturientRepo abiturientRepo) {
        this.abiturientRepo = abiturientRepo;
    }

    private static List<Abiturient> createAndInitializeAbiturients() {
        Abiturient abiturient1 = new Abiturient("Newton","Isaac","Isaac","newtonis@gmail.com","85 647 2878",10.4,"1st St., England",true);
        Abiturient abiturient2 = new Abiturient("Einstein","Albert","Hermann","alberton@gmail.com","74 254 3314",10.9,"2nd St., Germany",false);
        Abiturient abiturient3 = new Abiturient("Tesla","Nikola","Milutin","tenicol@gmail.com","25 823 5686",9.4, "3rd St., Austria", true);
        Abiturient abiturient4 = new Abiturient("Edison","Thomas","Samuel","edisomas@gmail.com","59 365 1338",10.0,"4th St., USA",false);
        Abiturient abiturient5 = new Abiturient("Galilei","Galileo","Vincenzo","galilelio@gmail.com","46 172 6438",9.1,"5th St., Italy",false);

        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add(abiturient1);
        abiturients.add(abiturient2);
        abiturients.add(abiturient3);
        abiturients.add(abiturient4);
        abiturients.add(abiturient5);

        return abiturients;
    }

    @Override
    public void insertDefaultAbiturients() {
        List<Abiturient> abiturients = createAndInitializeAbiturients();
        abiturientRepo.saveAll(abiturients);
    }

    @Override
    public void insertAbiturient(Abiturient abiturient) {
        abiturientRepo.save(abiturient);
    }

    @Override
    public List<Abiturient> selectAllAbiturients() {
        return abiturientRepo.findAll(Sort.by("ID"));
    }

    @Override
    public Abiturient findAbiturientById(Long id) {
        return abiturientRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Abiturient> filterAbiturientsByGivenFirstName(String firstName) {
        return abiturientRepo.findByFirstNameIsIgnoreCase(firstName);
    }

    @Override
    public List<Abiturient> filterAbiturientsByHigherAveragePoint(Double minAveragePoint) {
        return abiturientRepo.findByAveragePointIsGreaterThan(minAveragePoint);
    }

    @Override
    public List<Abiturient> filterAbiturientsByHostelNeeds() {
        return abiturientRepo.findByNeedHostelIsTrue();
    }

    private static Abiturient setUpFields(Abiturient abiturientToChange, Abiturient changedAbiturient) {
        abiturientToChange.setLastName(changedAbiturient.getLastName());
        abiturientToChange.setFirstName(changedAbiturient.getFirstName());
        abiturientToChange.setFatherName(changedAbiturient.getFatherName());
        abiturientToChange.setEmail(changedAbiturient.getEmail());
        abiturientToChange.setPhone(changedAbiturient.getPhone());
        abiturientToChange.setAveragePoint(changedAbiturient.getAveragePoint());
        abiturientToChange.setAddress(changedAbiturient.getAddress());
        abiturientToChange.setNeedHostel(changedAbiturient.isNeedHostel());
        return abiturientToChange;
    }

    @Override
    public void updateAbiturient(Abiturient abiturient) {
        Optional<Abiturient> abiturientOptional = abiturientRepo.findById(abiturient.getID());
        if (abiturientOptional.isPresent()) {
            Abiturient abiturientToUpdate = abiturientOptional.get();
            Abiturient updatedAbiturient = setUpFields(abiturientToUpdate, abiturient);
            abiturientRepo.save(updatedAbiturient);
        }
    }

    @Override
    public void deleteAbiturient(Abiturient abiturient) {
        abiturientRepo.delete(abiturient);
    }

    @Override
    public void deleteAbiturientById(Long id) {
        abiturientRepo.deleteById(id);
    }
}