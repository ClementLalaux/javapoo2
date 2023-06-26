package org.example;

import org.example.entity.Etudiant;
import org.example.entity.Professeur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("personne");
    Scanner scanner;
    String choix;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createEtudiant();
                    break;
                case "2":
                    createProfesseur();
                    break;
                case "3":
                    listEtudiant();
                    break;
                case "4":
                    listProfesseur();
                    break;
            }
        }while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("1 - Ajouter un etudiant");
        System.out.println("2 - Ajouter un professeur");
        System.out.println("3 - Lister les etudiants");
        System.out.println("4 - Lister les professeurs");
        System.out.println("0 - EXIT");
    }

    private void createEtudiant(){

        Etudiant etudiant = new Etudiant();
        System.out.print("Merci de saisir le nom de l'etudiant : ");
        String nom = scanner.nextLine();
        System.out.print("Merci de saisir le prenom de l'etudiant : ");
        String prenom = scanner.nextLine();
        System.out.print("Merci de saisir la classe : ");
        String classe = scanner.nextLine();

        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setClasse(classe);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(etudiant);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
        em.close();
    }

    private void createProfesseur(){
        Professeur professeur = new Professeur();
        System.out.print("Merci de saisir le nom du professeur : ");
        String nom = scanner.nextLine();
        System.out.print("Merci de saisir le prenom du professeur : ");
        String prenom = scanner.nextLine();
        System.out.print("Merci de saisir la matiere : ");
        String matiere = scanner.nextLine();

        professeur.setNom(nom);
        professeur.setPrenom(prenom);
        professeur.setMatiere(matiere);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {
            em.persist(professeur);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
        em.close();
    }

    private void listEtudiant(){
        List<Etudiant> etudiants = new ArrayList<>();
        EntityManager em = emf.createEntityManager();

        etudiants = em.createQuery("select p from Etudiant p",Etudiant.class).getResultList();

        for (Etudiant l : etudiants){
            System.out.println(l.getNom());
            System.out.println(l.getClasse());
        }

        em.close();
    }

    private void listProfesseur(){
        List<Professeur> professeurs = new ArrayList<>();
        EntityManager em = emf.createEntityManager();

        professeurs = em.createQuery("select p from Professeur p",Professeur.class).getResultList();

        for (Professeur l : professeurs){
            System.out.println(l.getNom());
            System.out.println(l.getMatiere());
        }

        em.close();
    }
}
