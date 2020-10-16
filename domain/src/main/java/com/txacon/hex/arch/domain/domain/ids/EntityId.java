package com.txacon.hex.arch.domain.domain.ids;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@EqualsAndHashCode
abstract class EntityId {

    @Getter
    public final UUID idValue;

    protected EntityId() {
        this.idValue = randomUUID();
    }

    protected EntityId(UUID idValue) {
        this.idValue = idValue;
    }

    public EntityId(String idValueStr) {
        this(UUID.fromString(idValueStr));
    }

    public String toString() {
        return idValue.toString();
    }

}
