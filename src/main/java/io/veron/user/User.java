package io.veron.user;

import io.veron.validator.Validator;

public abstract class User {

    private final Validator validator;

    public User(Validator validator) {
        this.validator = validator;
    }

    protected boolean isValid() {
        return validator.validate();
    }
}
