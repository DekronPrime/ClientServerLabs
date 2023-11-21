package org.example;

import jakarta.persistence.*;
import org.example.entities.Abiturient;

import java.util.List;
import java.util.NoSuchElementException;

public class AbiturientDAO {
    private static EntityManagerFactory emf;

    public AbiturientDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    void insert(Abiturient abiturient) {
        try (EntityManager entityManager = getEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(abiturient);
            entityManager.getTransaction().commit();
        } catch (IllegalStateException | EntityExistsException | RollbackException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    List<Abiturient> select() {
        try (EntityManager entityManager = getEntityManager()){
            return entityManager.createQuery("from Abiturient", Abiturient.class).getResultList();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    List<Abiturient> filterAbiturientsByGivenFirstname(String firstname) {
        try (EntityManager entityManager = getEntityManager()){
            Query query = entityManager.createQuery("from Abiturient where firstName = :firstname", Abiturient.class);
            query.setParameter("firstname", firstname);
            return query.getResultList();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    List<Abiturient> filterAbiturientsByHigherAveragePoint(double minAveragePoint) {
        try (EntityManager entityManager = getEntityManager()){
            Query query = entityManager.createQuery("from Abiturient where averagePoint > :minAveragePoint", Abiturient.class);
            query.setParameter("minAveragePoint", minAveragePoint);
            return query.getResultList();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    List<Abiturient> filterAbiturientsByHostelNeeds() {
        try (EntityManager entityManager = getEntityManager()){
            Query query = entityManager.createQuery("from Abiturient where needHostel = :value", Abiturient.class);
            query.setParameter("value", true);
            return query.getResultList();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    Abiturient findById(long id) {
        try (EntityManager entityManager = getEntityManager()){
            return entityManager.find(Abiturient.class, id);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    void update(Abiturient abiturient) {
        try (EntityManager entityManager = getEntityManager()){
            entityManager.getTransaction().begin();
            Abiturient abiturientToUpdate = findById(abiturient.getID());
            if (abiturientToUpdate != null) {
                abiturientToUpdate.setLastName(abiturient.getLastName());
                abiturientToUpdate.setFirstName(abiturient.getFirstName());
                abiturientToUpdate.setFatherName(abiturient.getFatherName());
                abiturientToUpdate.setEmail(abiturient.getEmail());
                abiturientToUpdate.setPhone(abiturient.getPhone());
                abiturientToUpdate.setAveragePoint(abiturient.getAveragePoint());
                abiturientToUpdate.setAddress(abiturient.getAddress());
                abiturientToUpdate.setNeedHostel(abiturient.isNeedHostel());
                entityManager.merge(abiturientToUpdate);
            }
            else
                throw new NoSuchElementException("Abiturient with id = " + abiturient.getID() + " is not exists");
            entityManager.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IllegalStateException | RollbackException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    void delete(Abiturient abiturient) {
        try (EntityManager entityManager = getEntityManager()){
            entityManager.getTransaction().begin();
            Abiturient abiturientToDelete = entityManager.find(Abiturient.class, abiturient.getID());
            if(abiturientToDelete != null)
                entityManager.remove(abiturientToDelete);
            else
                throw new NoSuchElementException("Abiturient is not exists");
            entityManager.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IllegalStateException | RollbackException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    void deleteById(long id) {
        try (EntityManager entityManager = getEntityManager()){
            entityManager.getTransaction().begin();
            Abiturient abiturientToDelete = entityManager.find(Abiturient.class, id);
            if(abiturientToDelete != null)
                entityManager.remove(abiturientToDelete);
            else
                throw new NoSuchElementException("Abiturient with id = " + id + " is not exists");
            entityManager.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IllegalStateException | RollbackException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}