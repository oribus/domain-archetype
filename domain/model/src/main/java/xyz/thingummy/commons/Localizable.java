package xyz.thingummy.commons;

import java.util.Optional;

/**
 * Represents an entity or value object that can be localized.
 * <p>
 * Entities or value objects implementing this interface have a key which can be used for localization or identification.
 * They also have an optional default message that serves as a fallback for localization.
 * </p>
 */
public interface Localizable {
    String getKey();
    Optional<String> getDefaultMessage();

}