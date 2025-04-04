package org.example.absenteeism_count;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudyGroup {
    String faculty;
    int year;

    public StudyGroup(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return faculty + " (" + year + ")";
    }

    @Override
    public boolean equals(Object key) {
        if (this == key) return true;
        if (key == null || getClass() != key.getClass()) return false;
        StudyGroup that = (StudyGroup) key;
        return year == that.year && faculty.equals(that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

}