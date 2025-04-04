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
        students.add(new Student("English", 2020, "Johan"));
        students.add(new Student("Economics", 2024, "Robert"));
        students.add(new Student("Economics", 2025, "Bob"));
        students.add(new Student("Economics", 2025, "Bob"));

        getGroups(students).forEach((group, names) -> {
            System.out.println(group + ": " + names + "\n");
        });

        addNewStudent("Economics", 2023, "Bober");
        deleteStudent("English", 2020, "Shamil");

        showGroupedStudents(groups);
        findStudentsByStudyGroup("Economics", 2025);
    }

    private static HashMap<StudyGroup, List<String>> getGroups(List<Student> students) {
        for (Student student : students) {
            StudyGroup group = new StudyGroup(student.getFaculty(), student.getYear());
            addStudentService(group, student.getName());
        }
        return groups;
    }

    private static void addNewStudent(String faculty, int year, String name) {
        StudyGroup group = new StudyGroup(faculty, year);
        addStudentService(group, name);
    }

    private static void deleteStudent(String faculty, int year, String name) {
        StudyGroup group = new StudyGroup(faculty, year);
        List<String> students = groups.get(group);
        if (students != null) {
            students.remove(name);
        } else {
            System.out.println("Student " + name + " not found");
        }

        if (students.isEmpty()) {
            groups.remove(group);
        }

    }

    private static void findStudentsByStudyGroup(String faculty, int year) {
        StudyGroup group = new StudyGroup(faculty, year);
        List<String> students = groups.get(group);
        showStudentsInGroupService(group, students);
    }

    private static void showGroupedStudents(HashMap<StudyGroup, List<String>> groups) {
        groups.forEach((group, students) -> {
            showStudentsInGroupService(group, students);
        });
    }

    private static void addStudentService(StudyGroup group, String name) {
        groups.computeIfAbsent(group,  groupKey -> new ArrayList<>())
                .add(name);
    }

    private static void showStudentsInGroupService(StudyGroup group, List<String> students) {
        System.out.println("Group: " + group);
        students.forEach(student -> System.out.println(" - " + student));
    }
}
