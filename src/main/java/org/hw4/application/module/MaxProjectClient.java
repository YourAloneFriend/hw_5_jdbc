package org.hw4.application.module;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MaxProjectClient {
    private int id;
    private String name;
    private int projectCount;

    @Override
    public String toString() {
        return "MaxProjectWorker:" +
                "\n\tid = " + id +
                "\n\tname = " + name +
                "\n\tprojectCount = " + projectCount;
    }
}
