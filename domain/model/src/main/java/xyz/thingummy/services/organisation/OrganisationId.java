package xyz.thingummy.services.organisation;

import lombok.NonNull;
import lombok.Value;
import xyz.thingummy.commons.model.EntityId;

import java.util.UUID;


@Value
public class OrganisationId implements EntityId<Organisation> {
    @NonNull
    UUID id;


}


