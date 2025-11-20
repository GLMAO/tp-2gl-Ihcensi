package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {
    private List<ICours> listeCours = new ArrayList<>();

    // Liste pour stocker les observateurs
    private List<Observer> observateurs = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        this.observateurs.add(o);
    }

    @Override
    public void detach(Observer o) {
        this.observateurs.remove(o);
    }
    
   @Override
    public void notifyObservers(String message) {
        for (Observer observateur : this.observateurs) {
            observateur.update(message);
        }
    }

    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        // TODO: C'est ici qu'il faudrait notifier les étudiants (Observer pattern)
        String notificationMessage = "INFO: Le cours " + cours.getDescription() + " a été ajouté à l'emploi du temps.";
        notifyObservers(notificationMessage);
    }

    public void modifierCours(ICours cours, String message) {
        // Logique de modification...
        System.out.println("Cours modifié : " + message);
        // TODO: Notifier les observateurs ici aussi
        String notificationMessage = "ALERTE: Le cours " + cours.getDescription() + " a été modifié. Détail: " + message;
        notifyObservers(notificationMessage);
    }

    public void setChangement(String string) {
        // TODO Auto-generated method stub
        // Ajouter la logique de notification
        System.out.println("Changement d'état détecté dans l'emploi du temps. Notification...");
    
        // Notifier tous les observateurs avec le message reçu
        notifyObservers(string);
    }
}