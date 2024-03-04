package main;

import java.util.ArrayList;

public class Gifu {
   private String university;
   private ArrayList<Course> courses = new ArrayList<>();
   private ArrayList<Student> students = new ArrayList<>();
   private ArrayList<Enrollment> enrollments = new ArrayList<>();

   public Gifu(String university){
        this.university = university;
   }
   
   public void addCourse(Course course){
        courses.add(course);
   }

   public Course getCourse(int id){
        return courses.get(id);
   }

   public ArrayList<Course> getCourses(){
        return courses;
   }

   public void listCourses(){
        int i = 0;
        for(Course x : courses){
            System.out.println(Integer.toString(i) + ") " + x.getInformation());
        }
   }

   public void addStudent(Student student){
        students.add(student);
   }

   public Student getStudent(int id){
        return students.get(id);
   }

   public void listStudents(){
        int i = 0;
        for(Student x : students){
            System.out.println(Integer.toString(i) + ") " + x.getInformation());
        }
   }

   public void enrollStudent(Student student, Course course){
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
   }

   public ArrayList<Enrollment> getEnrollments(Course course){
    ArrayList<Enrollment> returnEnrollments = new ArrayList<>();

        for(Enrollment x : enrollments){
            if(x.getCourse() == course){
                returnEnrollments.add(x);
            }
        }

        return returnEnrollments;
   }

   public ArrayList<Enrollment> getEnrollments(Student student){
        ArrayList<Enrollment> returnEnrollments = new ArrayList<>();    

        System.out.println("Student " + student.getInformation() + " grades:");
        for(Enrollment x : enrollments){
            if(x.getStudent() == student){
                returnEnrollments.add(x);
            }
        }

        return returnEnrollments;
   }
}
