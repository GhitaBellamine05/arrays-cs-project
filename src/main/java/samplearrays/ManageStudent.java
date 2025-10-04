package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int adultCounter = 0;
        for (Student student : students) {
            if (student.isAdult()) {
                adultCounter++;
            }
        }
        return adultCounter;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double sum = 0;
        int counter = 0;
        for (Student student : students) {
            // Ignore the students whose grade is not initialized
            if (student.getGrade() == -1) {
                continue;
            } else {
                sum += student.getGrade();
                counter++;
            }
        }
        if (counter == 0) {
            return Double.NaN;
        }
        return sum / counter;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static Student[] sortByGradeDesc(Student[] students) {
        // Here we must pay attention to student whose grade attribute is = -1 which means that the grade i snot initialized
        // Count how many students have grades
        int gradedCount = 0;
        for (Student s : students) {
            if (s.getGrade() != -1) gradedCount++;
        }

        // Create new array only for students with grades
        Student[] newArray = new Student[gradedCount];
        int i = 0;
        for (Student s : students) {
            if (s.getGrade() != -1) {
                newArray[i++] = s;
            }
        }

        Arrays.sort(newArray, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s2.getGrade() - s1.getGrade();
            }
        });

        return newArray;
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student student : students) {
            if (student.getGrade() >= 15) {
                System.out.println(student.getName());
            }

        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }


    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equals(students[j].getName())) {
                    return true;
                }
            }
        }
        return false;
    }


    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudentArray = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudentArray[i] = students[i];
        }
        newStudentArray[students.length] = newStudent;
        return newStudentArray;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        // Note that i changed the Student class by giving the grade a sentinel value = -1 in the constructors that doesn't initialize the grade attribute
        // and that's in order to distinguish between the grade 0 and the 0 giving to the non initialized value by default in java

        Student[] arr = new Student[5];
        arr[0] = new Student(1, "Ghita");
        arr[1] = new Student(2, "Ahmed", 18);
        arr[2] = new Student(3, "Rayan", 19, 14);
        arr[3] = new Student(4, "Samia", 16, 18);
        arr[4] = new Student(5, "Malak", 17);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("============================================");
        System.out.println("Total created: " + Student.getNumStudent());
        System.out.println("============================================");
        // 2) Oldest
        Student oldest = findOldest(arr);
        System.out.println("Oldest Student :" + oldest);

        // 3) Count adults
        System.out.println("============================================");
        System.out.println("There are " + countAdults(arr) + " adults in this group of students");

        // 4) Average grade
        System.out.println("============================================");
        System.out.println("The average is : " + averageGrade(arr));


        // 5) Find by name
        System.out.println("============================================");
        System.out.println("Is there any student with the name 'Ghita' ?  ");
        Student specificStudent1 = findStudentByName(arr, "Ghita");
        if (specificStudent1 == null) System.out.println("No ");
        else System.out.println("Yes ");
        System.out.println("Is there any student with the name 'Dina' ?  ");
        Student specificStudent2 = findStudentByName(arr, "Dina");
        if (specificStudent2 == null) System.out.println("No ");
        else System.out.println("Yes ");

        // 6) Sort by grade desc
        // sort function
        System.out.println("============================================");
        System.out.println("\n== Sorted by grade (desc) ==");
        System.out.println("I considered here just the students with an initialized grade attribute. ");
        for (Student s : sortByGradeDesc(arr)) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("============================================");
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        System.out.println("============================================");
        System.out.println("\nUpdated id=4? " + updateGrade(arr, 4, 20));

        // 9) Duplicate names
        System.out.println("============================================");
        System.out.println("Does the students array contains duplicate names ? " + hasDuplicateNames(arr));

        // 10) Append new student
        System.out.println("============================================");
        System.out.println("The new students list after adding a new student ");
        Student[] newarray = appendStudent(arr, new Student(6, "Mustapha", 20, 18));
        for (Student s : newarray) System.out.println(s);

        System.out.println("============================================");
        System.out.println("=============School================");

        //11) Create and initialize a 2D array representing the school
        Student[][] school = new Student[2][3];
        school[0] = new Student[]{
                new Student(1, "Ali", 12, 16),
                new Student(2, "Salma", 13, 12),
                new Student(3, "Dalia", 12, 10)
        };
        school[1] = new Student[]{
                new Student(7, "Radia", 16, 16),
                new Student(8, "Samia", 17, 18),
                new Student(9, "Fatima", 16, 8)
        };
        int j = 1;
        for (Student[] classroom : school) {
            System.out.println("Class " + j + ":");
            for (Student student : classroom) {
                System.out.println("  - " + student.getName());
            }
            System.out.println();
            j++;
        }
        // top student
        int i = 1;
        for (Student[] classroom : school) {
            Student topStudent = classroom[0]; // Start with first student

            for (Student student : classroom) {
                if (student.getGrade() > topStudent.getGrade()) {
                    topStudent = student;
                }
            }

            System.out.println("Top student in Class " + i + ": " +
                    topStudent.getName() + " (Grade: " + topStudent.getGrade() + ")");
            i++;
        }



    }
}

