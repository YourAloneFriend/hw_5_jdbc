package org.hw4.application.module;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class ProjectPrices {
    private int projectId;
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private double cost;

    @Override
    public String toString() {
        return "PrintProjectPrices:" +
                "\n\tprojectId = " + projectId +
                "\n\tclientId = " + clientId +
                "\n\tstartDate = " + startDate +
                "\n\tfinishDate = " + finishDate +
                "\n\tcost = " + cost;
    }
}
