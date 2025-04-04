package org.example.absenteeism_count;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends StudyGroup {
    String name;

    public Student(String faculty, int year, String name) {
        super(faculty, year);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
