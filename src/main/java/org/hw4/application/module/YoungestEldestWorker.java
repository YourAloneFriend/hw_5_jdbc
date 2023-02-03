package org.hw4.application.module;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class YoungestEldestWorker {
    private int id;
    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;
    private String type;

    @Override
    public String toString() {
        return "MaxSalaryWorker:" +
                "\n\tid = " + id +
                "\n\tname = " + name +
                "\n\tbirthday = " + birthday +
                "\n\tlevel = " + level +
                "\n\tsalary = " + salary +
                "\n\ttype = " + type;
    }
}
