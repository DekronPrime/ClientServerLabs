package org.example.services;

import org.example.entities.Abiturient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbiturientService {
    void insertDefaultAbiturients();

    void insertAbiturient(Abiturient abiturient);

    List<Abiturient> selectAllAbiturients();

    Abiturient findAbiturientById(Long id);

    List<Abiturient> filterAbiturientsByGivenFirstName(String firstName);

    List<Abiturient> filterAbiturientsByHigherAveragePoint(Double minAveragePoint);

    List<Abiturient> filterAbiturientsByHostelNeeds();

    void updateAbiturient(Abiturient abiturient);

    void deleteAbiturient(Abiturient abiturient);

    void deleteAbiturientById(Long id);
}
