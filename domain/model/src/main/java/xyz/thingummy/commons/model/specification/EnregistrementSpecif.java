package xyz.thingummy.commons.model.specification;

/**
 * Représente un enregistrement de notification généré par une Spécification.
 * <p>
 * Cette classe est une spécialisation de EnregistrementNotification pour les notifications issues d'une Spécification.
 * </p>
 *
 * @param <T> Le type de la référence.
 */
public class EnregistrementSpecif<T> extends EnregistrementNotification<T, Specification<T>> {

    public EnregistrementSpecif(Notification notification, Specification<T> specification, T reference) {
        super(notification, specification, reference);
    }

    @Override
    public Specification<T> getSource() {
        return super.getSource();
    }
}