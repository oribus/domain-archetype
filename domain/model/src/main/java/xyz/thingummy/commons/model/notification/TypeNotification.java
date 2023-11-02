package xyz.thingummy.commons.model.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import xyz.thingummy.commons.Localizable;

import java.util.Optional;

/**
 * Enumeration representing the different types of notifications with localization properties.
 * <p>
 * Each type in this enumeration corresponds to a specific kind of notification, ranging from simple confirmations to critical alerts.
 * The primary purpose of these types is to categorize notifications based on their nature and importance.
 * </p>
 * <p>
 * Additionally, each type has associated localization properties:
 * <ul>
 *     <li><b>key:</b> A unique identifier used to retrieve the localized message for this type from resource bundles.</li>
 *     <li><b>defaultMessage:</b> An optional default message that can be used as a fallback when the key doesn't yield a localized message.</li>
 * </ul>
 * These properties ensure that each type can be presented in a localized manner, catering to different languages or regional preferences.
 * </p>
 */

@AllArgsConstructor
@Getter
public enum TypeNotification implements Localizable {
    CONFIRMATION("confirmation.key", "Default confirmation message"),
    INFORMATION("information.key", "Default informational message"),
    AVERTISSEMENT("avertissement.key", "Default warning message"),
    ERREUR("erreur.key", "Default error message"),
    CRITIQUE("critique.key", "Default critical message");

    @NonNull
    private final String key;
    private final String defaultMessage;

    TypeNotification(String key) {
        this(key,null);
    }
    @Override
    public Optional<String> getDefaultMessage() {
        return Optional.ofNullable(defaultMessage);
    }

    }
}
