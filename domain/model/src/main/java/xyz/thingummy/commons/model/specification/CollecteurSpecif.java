package xyz.thingummy.commons.model.specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Représente un collecteur pour les enregistrements de notifications générés par des Spécifications.
 */
public class CollecteurSpecif<T> {

    private final List<EnregistrementSpecif<T>> enregistrements = new ArrayList<>();

    public void ajouter(Notification notification, Specification<T> specification, T reference) {
        enregistrements.add(new EnregistrementSpecif<>(notification, specification, reference));
    }

    public List<EnregistrementSpecif<T>> getEnregistrements() {
        return Collections.unmodifiableList(enregistrements);
    }

    public boolean hasNotifications() {
        return !enregistrements.isEmpty();
    }

    public void vider() {
        enregistrements.clear();
    }
}