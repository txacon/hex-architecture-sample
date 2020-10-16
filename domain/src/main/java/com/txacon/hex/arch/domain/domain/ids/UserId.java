package com.txacon.hex.arch.domain.domain.ids;

import java.io.Serializable;
import java.util.UUID;


public class UserId extends EntityId implements Serializable {

    public UserId() {
        super();
    }

    public UserId(UUID idValue) {
        super(idValue);
    }

    public UserId(String idValueStr) {
        super(idValueStr);
    }
}
