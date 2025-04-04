package org.example.absenteeism_count;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudyGroup {
    String faculty;
    Integer year;

    public StudyGroup(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return faculty + " (" + year + ")";
    }
}
