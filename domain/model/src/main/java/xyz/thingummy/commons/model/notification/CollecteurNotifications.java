package xyz.thingummy.commons.model.notification;

import xyz.thingummy.commons.model.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a set of
 * @param <T>
 */
public class CollecteurNotifications<T> {

    private final List<EnregistrementNotification<T>> entries = new ArrayList<>();

    /**
     * Ajoute une entrée de notification au collecteur.
     *
     * @param notification La notification à ajouter.
     * @param specification La spécification qui a généré la notification.
     * @param evaluatedObject L'objet qui était en cours d'évaluation.
     */
    public void ajouter(Notification notification, Specification<T> specification, T evaluatedObject) {
        entries.add(new EnregistrementNotification<>(notification, specification, evaluatedObject));
    }

    /**
     * Récupère une liste non modifiable de toutes les entrées de notification collectées.
     *
     * @return Une liste non modifiable d'entrées de notification.
     */
    List<EnregistrementNotification<T>> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    /**
     * Vérifie si le collecteur a des entrées de notification.
     *
     * @return Vrai s'il y a des entrées de notification, faux sinon.
     */
    public boolean hasNotifications() {
        return !entries.isEmpty();
    }

    /**
     * Efface toutes les entrées de notification du collecteur.
     */
    public void vider() {
        entries.clear();
    }
}





