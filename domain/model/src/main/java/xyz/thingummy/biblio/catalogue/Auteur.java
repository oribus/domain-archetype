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
package xyz.thingummy.biblio.catalogue;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import xyz.thingummy.commons.model.AggregateRoot;

import java.util.Date;

@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@RequiredArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
public abstract class Auteur implements AggregateRoot<Auteur, AuteurId> {
    @NonNull
    @Setter(AccessLevel.PROTECTED)
    private AuteurId id;
    @NonNull
    @NotBlank
    @Setter(AccessLevel.PUBLIC)
    private String firstName;
    @NonNull
    @NotBlank
    @Setter(AccessLevel.PUBLIC)
    private String lastName;
    @Setter(AccessLevel.PUBLIC)
    private Date dateOfBirth;


}



