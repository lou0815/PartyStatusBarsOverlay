package com.lou0815.PartyStatusBarsOverlay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BarType {
    HP("Hp"),
    PRAY("Pray"),
    SPEC("Spec"),
    RUN("Run");

    private final String name;

    @Override
    public String toString() {
        return getName();
    }
}
