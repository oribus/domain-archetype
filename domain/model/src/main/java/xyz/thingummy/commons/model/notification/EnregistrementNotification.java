package xyz.thingummy.commons.model.notification;

/**
 * Représente un enregistrement de notification.
 * <p>
 * Chaque enregistrement encapsule une Notification, la source qui l'a générée, et la référence associée.
 * </p>
 *
 * @param <T> Le type de la référence.
 * @param <S> Le type de la source.
 */
public class EnregistrementNotification<T, S> {
    private final Notification notification;
    private final S source;
    private final T reference;

    public EnregistrementNotification(Notification notification, S source, T reference) {
        this.notification = notification;
        this.source = source;
        this.reference = reference;
    }

    public Notification getNotification() {
        return notification;
    }

    public S getSource() {
        return source;
    }

    public T getReference() {
        return reference;
    }
}