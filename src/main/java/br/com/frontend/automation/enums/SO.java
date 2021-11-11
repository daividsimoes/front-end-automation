package br.com.frontend.automation.enums;

import lombok.Getter;

@Getter
public enum SO {

    WINDOWS("win"),
    LINUX("linux"),
    MAC("mac"),
    UNKNOWN("unknown");

    private String so;
    SO(String so) {

        this.so = so;
    }
}
