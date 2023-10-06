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

package xyz.thingummy.commons.model;

import java.util.UUID;

public interface Id_<T extends Entity<T, ? extends Id_<T>>> extends ValueObject<Id_<T>> {


    /**
     * Returns the id of the entity or aggregate root as a UUID
     *
     * @return the id of the entity or aggregate root
     */
    UUID getId();

    /**
     * Returns whether the id is a plain ID or an ID with a juncture
     *
     * @return true if the id is a plain ID, false otherwise
     */
    default boolean isPlainId() {
        return !isWithJuncture();
    }

    /**
     * Returns whether the id is an ID with a juncture or a plain ID
     *
     * @return true if the id is an ID with a juncture, false otherwise
     */
    boolean isWithJuncture();

    /**
     * Returns the String representation of the id formed of a UUID and an optional juncture separated by a colon
     *
     * @return the String representation of the id
     */
    String asString();
}
