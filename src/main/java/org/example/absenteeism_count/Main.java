package org.example.absenteeism_count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static HashMap<StudyGroup, List<String>> groups = new HashMap<>();

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Math", 2020, "Michael"));
        students.add(new Student("English", 2020, "Shamil"));
        students.add(new Student("English", 2024, "Johan"));
        students.add(new Student("Economics", 2024, "Robert"));
        students.add(new Student("Economics", 2025, "Bob"));
        students.add(new Student("Economics", 2025, "Bob"));

        System.out.println(getGroups(students));
    }

    private static HashMap<StudyGroup, List<String>> getGroups(List<Student> students) {
        for (Student student : students) {
            StudyGroup group = new StudyGroup(student.getFaculty(), student.getYear());

            groups.computeIfAbsent(group, k -> new ArrayList<>())
                        .add(student.getName());

        }
        return groups;
    }
}
