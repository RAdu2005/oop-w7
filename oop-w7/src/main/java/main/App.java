package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Gifu!\nFor which university do you want to implement the system?");
        String university = sc.nextLine();

        Gifu gifu = new Gifu(university);
        
        boolean run = true;
        while(run){
            System.out.println("1) Create a new course, 2) Create a new student, 3) List the courses, 4) List the students, 5) Add a student to the course, 6) Give the course grades, 7) List the students in the course, 8) List the student's grades, 9) List all grades of all students in the courses, 0) End the program");

            int option = Integer.parseInt(sc.nextLine());

            switch(option){
                case 1: {
                    System.out.println("Enter the name of the course:");
                    String name = sc.nextLine();

                    System.out.println("Enter the course ID:");
                    String id = sc.nextLine();

                    System.out.println("Enter the maximum number of students:");
                    int maxNumberOfStudents = Integer.parseInt(sc.nextLine());

                    Course course = new Course(name, id, maxNumberOfStudents);
                    gifu.addCourse(course);
                    break;
                } case 2: {
                    System.out.println("Enter the student name:");
                    String name = sc.nextLine();

                    System.out.println("Enter the student number:");
                    String id = sc.nextLine();

                    Student student = new Student(name, id);
                    gifu.addStudent(student);
                    break;
                } case 3: {
                    gifu.listCourses();
                    break;
                } case 4: {
                    gifu.listStudents();
                    break;
                } case 5: {
                    gifu.listCourses();
                    System.out.println("To which course do you want to enroll a student? Provide the number of the course:");
                    int courseId = Integer.parseInt(sc.nextLine());

                    gifu.listStudents();
                    System.out.println("Which student do you want to enroll? Provide the number of the student:");
                    int studentId = Integer.parseInt(sc.nextLine());

                    gifu.enrollStudent(gifu.getStudent(studentId), gifu.getCourse(courseId));
                    break;
                } case 6: {
                    gifu.listCourses();
                    System.out.println("Which course do you want to grade? Provide the number of the course:");
                    int courseId = Integer.parseInt(sc.nextLine());

                    ArrayList<Enrollment> returnEnrollments = gifu.getEnrollments(gifu.getCourse(courseId));
                    for(Enrollment x : returnEnrollments){
                        System.out.println("Give grade to the student " + x.getStudent().getInformation());
                        int grade = Integer.parseInt(sc.nextLine());
                        x.gradeCourse(grade);
                    }
                    break;
                } case 7: {
                    gifu.listCourses();
                    System.out.println("Which course do you want to grade? Provide the number of the course:");
                    int courseId = Integer.parseInt(sc.nextLine());

                    ArrayList<Enrollment> returnEnrollments = gifu.getEnrollments(gifu.getCourse(courseId));
                    for(Enrollment x : returnEnrollments){
                        System.out.println(x.getStudent().getInformation() + ", grade: " + x.getGrade());
                    }
                    break;
                } case 8: {
                    gifu.listStudents();
                    System.out.println("Which student's grades you want to see? Provide the number of the student:");
                    int studentId = Integer.parseInt(sc.nextLine());

                    System.out.println("Student " + gifu.getStudent(studentId).getInformation() + " grades:");
                    ArrayList<Enrollment> returnEnrollments = gifu.getEnrollments(gifu.getStudent(studentId));
                    for(Enrollment x: returnEnrollments){
                        System.out.println(x.getCourse().getInformation() + ", grade: " + x.getGrade());
                    }
                    break;
                } case 9: {
                    try{
                        int i = 0;
                        while(true){
                            System.out.println(gifu.getCourse(i).getInformation());
                            ArrayList<Enrollment> returnEnrollments = gifu.getEnrollments(gifu.getCourse(i));
                            for(Enrollment x : returnEnrollments){
                                System.out.println(x.getStudent().getInformation() + ", grade: " + x.getGrade());
                            }
                            i++;
                        }
                    }catch(Exception E){}
                    break;
                } case 0: {
                    System.out.println("Thank you for using the program.");
                    run = false;
                    continue;
                }
            }
        }
    }
}
