package com.txacon.hex.arch.domain.domain.values;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@EqualsAndHashCode
public class Email implements Serializable {

    @Getter
    private final String userMailbox;
    @Getter
    private final String domain;

    public Email(final String userMailbox, final String domain) {
        if (userMailbox == null || domain == null) {
            this.userMailbox = null;
            this.domain = null;
        }
        else {
            this.userMailbox = userMailbox.toLowerCase();
            this.domain = domain.toLowerCase();
        }
    }


    public String toString() {
        return userMailbox + "@" + domain;
    }

    // Util Static Method

    /**
     * Accept raw mail and return Email object
     * @param email String email representation
     * @return Email object
     */
    public static Email of(String email){
        if (email == null) return null;
        String[] emailParts = email.split("@");
        if (emailParts.length != 2) return null;
        return new Email(emailParts[0], emailParts[1]);
    }

}
