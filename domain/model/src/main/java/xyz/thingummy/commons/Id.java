/*
 * Copyright (c) 2023, Jérôme ROBERT
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package xyz.thingummy.commons;

import lombok.*;
import lombok.experimental.NonFinal;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;



@Value @NonFinal @EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Id<T extends Entity<T,? extends Id<T>>> extends ValueObject<Id<T>> {
    @NonNull
    /*
     *  The id of the entity as a UUID
     */
    UUID id;
    /*
     * The juncture of the entity as an object of type Long.
     * The juncture complements the immutable id of the entity with an indication of a point in time.
     */
    Long juncture;

    /**
     * Creates an instance of the Id class from a String representation of the id formed of a UUID and an optional juncture.
     * @param uuid the String representation of the id
     * @param clazz the class of the entity
     * @return an instance of the Id class
     * @param <U> actual type of the Id
     * @throws InstantiationException if the actual class of the Id entity does not meet the requirements
     */
    static protected <U extends Id<?>> @NonNull U of(@NonNull String uuid,@NonNull Class<U> clazz) throws  InstantiationException {
        final String[] crumbs = uuid.split(":");
        try {
            return clazz.getDeclaredConstructor(UUID.class,Long.class).
                    newInstance(UUID.fromString(uuid),(1==crumbs.length)?null:Long.parseLong(crumbs[1]));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new InstantiationException(e.fillInStackTrace().toString());
        }
    }

    /**
     * Returns whether the id is a plain ID or an ID with a juncture
     * @return true if the id is a plain ID, false otherwise
     */
    public boolean isPlainId() {
        return juncture == null;
    }

    /**
     * Returns whether the id is an ID with a juncture or a plain ID
     * @return true if the id is an ID with a juncture, false otherwise
     */
    public boolean isWithJuncture() {
        return !isPlainId();
    }

    /**
     * Returns the String representation of the id formed of a UUID and an optional juncture separated by a colon
     * @return the String representation of the id
     */
    public String asString() {
        return (isPlainId())?id.toString():"%s:%d".formatted(id.toString(), juncture);
    }

}
