package xyz.thingummy.commons.model.notification;


import lombok.*;
import xyz.thingummy.commons.model.ValueObject;

import java.util.Optional;

/**
 * Represents a notification intended to provide feedback or information about specific events or conditions.
 * <p>
 * A notification encapsulates a key (potentially for localization), an optional default message, and the type of the notification.
 * The key is primarily used to retrieve localized messages from resource bundles, while the optional default message serves as a fallback.
 * The type of the notification indicates its nature and importance.
 * </p>
 */
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Notification implements ValueObject<Notification> {

   /**
     * The key used to retrieve the localized message. This key is essential and cannot be null.
     */
    @NonNull
    private final String key;

 /**
     * An optional default message provided as a fallback if the key isn't found in the resource bundle.
     */
    private final String defaultValue;

    /**
     * The type of the notification, indicating its nature and importance.
     */
    @NonNull
    private final TypeNotification type;

    /**
     * Static factory method to create a new Notification instance with the specified key and type.
     *
     * @param key  The key used to retrieve the localized message.
     * @param type The type of the notification.
     * @return A new Notification instance.
     */
    public static Notification of(String key, TypeNotification type) {
        return new Notification(key, null, type);
    }

    /**
     * Static factory method to create a new Notification instance with the specified key, default value, and type.
     *
     * @param key          The key used to retrieve the localized message.
     * @param defaultValue An optional default message if the key isn't found.
     * @param type         The type of the notification.
     * @return A new Notification instance.
     */
    public static Notification of(String key, String defaultValue, TypeNotification type) {
        return new Notification(key, defaultValue, type);
    }

 public Optional<String> getDefaultValue() {
  return Optional.of(defaultValue);
 }
}