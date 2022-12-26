package org.example;

import java.util.*;

public class App
{

    public static List<Student> prepareStudents() {
        List<Student> studList = new ArrayList<Student>();
        for (int i = 1; i < 10; i++) {
            studList.add(new Student(i, "name"+(byte)(Math.random()*10), (byte)(20+(Math.random()*10))));
        }
        return studList;
    }

    public static List<StudentLombok> prepareStudentsLb() {
        List<StudentLombok> studList = new ArrayList<StudentLombok>();
        for (int i = 1; i < 10; i++) {
            studList.add(new StudentLombok(i, "name"+(byte)(Math.random()*10), (byte)(20+(Math.random()*10))));
        }
        return studList;
    }

    public static void printStudentsList(List<Student> studList){
        System.out.println("Список студентов: Id Name Age");
        for (Student student: studList) {
            System.out.println(student.getId()+" "+student.getName()+" "+student.getAge());
        }
    }

    public static void printStudentsListLb(List<StudentLombok> studList){
        System.out.println("Список студентов: Id Name Age");
        for (StudentLombok student: studList) {
            System.out.println(student.getId()+" "+student.getName()+" "+student.getAge());
        }
    }

    public static void sumAgeByName(List<Student> studList) {
        System.out.print("Введите имя студента для которых посчитать суммарный возраст: ");
        Scanner input = new Scanner(System.in);
        String student_name = input.next();

        int age_sum = 0;
        for (Student student: studList) {
            if (student.getName().equals(student_name)) {
                age_sum += student.getAge();
            }
        }

        if (age_sum  > 0) {
            System.out.println("Суммарный возраст для имени " + student_name + " равняется: " + age_sum + ".");
        } else {
            System.out.println("Не найден студент с указанным именем.");
        }
    }

    public static void searchStudentByIndex(List<Student> studList) {
        System.out.print("Введите возраст студента: ");
        Scanner input = new Scanner(System.in);
        int student_age = input.nextInt();
        Student found = null;

        for (Student student: studList) {
            if (student.getAge() > student_age) {
                found = student;
            }
        }

        if (found == null) {
            System.out.println("Не найден ни один студент с возрастом больше заданного.");
        } else {
            System.out.println("Студент с именем " + found.getName() + " имеет возраст: " + found.getAge() + ", что является больше заданного.");
        }
    }

    public static HashSet<String> getStudentsSet(List<Student> studList) {
        HashSet<String> studHash = new HashSet<String>();
        for (Student student: studList) {
            studHash.add(student.getName());
        }
        return studHash;
    }

    public static void printStudentsSet(HashSet<String> studHash){
        System.out.println("Список студентов в SET:");
        for (String hash : studHash) {
            System.out.println(hash);
        }
    }

    public static HashMap<Integer, String> convertListToMap(List<Student> studList) {
        HashMap<Integer, String> studMap = new HashMap<Integer, String>();
        for (Student student: studList) {
            studMap.put(student.getId(), student.getName());
        }
        return studMap;
    }

    public static void printMap(HashMap<Integer, String> studMap){
        System.out.println("Список студентов в studMap:");
        studMap.forEach((k,v) -> System.out.println("key: " + k + " value: " + v));
    }

    public static HashMap<Byte, List<Student>> convertListToMapByAge(List<Student> studList) {
        HashMap<Byte, List<Student>> studMap = new HashMap<Byte, List<Student>>();
        List<Student> studListTemp;
        for (Student student: studList) {
            studListTemp = studMap.get(student.getAge());
            if (studListTemp == null) {
                studListTemp = new ArrayList<Student>();
            }
            studListTemp.add(student);
            studMap.put(student.getAge(), studListTemp);
        }
        return studMap;
    }

    public static void printMapByAge(HashMap<Byte, List<Student>> studMap){
        System.out.println("Список студентов в studMap:");
        for(Map.Entry<Byte, List<Student>> entry : studMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " +  entry.getValue());
        }

    }
    public static void main( String[] args )
    {
        List<Student> studList = prepareStudents();
        printStudentsList(studList);
        sumAgeByName(studList);
        searchStudentByIndex(studList);
        HashSet<String> studHash = getStudentsSet(studList);
        printStudentsSet(studHash);
        HashMap<Integer, String> studMap = convertListToMap(studList);
        printMap(studMap);
        HashMap<Byte, List<Student>> studMapByAge = convertListToMapByAge(studList);
        printMapByAge(studMapByAge);

        List<StudentLombok> studListLb = prepareStudentsLb();
        printStudentsListLb(studListLb);
    }
}
