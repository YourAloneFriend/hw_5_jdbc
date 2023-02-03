package org.hw4.application.module;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class LongestProject {
    private int id;
    private int clientId;
    private int duration;

    @Override
    public String toString() {
        return "PrintProjectPrices:" +
                "\n\tid = " + id +
                "\n\tclientId = " + clientId +
                "\n\tduration = " + duration;
    }
}
