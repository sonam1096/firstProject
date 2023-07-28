package project;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    int courseId;
    String courseName;
    String semester;

    Course(int courseId, String courseName, String semester) {
	this.courseId = courseId;
	this.courseName = courseName;
	this.semester = semester;
    }

    public int getCourseId() {
	return courseId;
    }

    public void setCourseId(int courseId) {
	this.courseId = courseId;
    }

    public String getCourseName() {
	return courseName;
    }

    public void setCourseName(String courseName) {
	this.courseName = courseName;
    }

    public String getSemester() {
	return semester;
    }

    public void setSemester(String semester) {
	this.semester = semester;
    }

    @Override
    public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", semester=" + semester + "]";
    }

}

class Student {
    int studentId;
    String studentName;
    ArrayList<Course> coursesEnroll;

    Student(int studentId, String studentName) {
	this.studentId = studentId;
	this.studentName = studentName;
	this.coursesEnroll = new ArrayList<>();
    }

    public int getStudentId() {
	return studentId;
    }

    public void setStudentId(int studentId) {
	this.studentId = studentId;
    }

    public String getStudentName() {
	return studentName;
    }

    public void setStudentName(String studentName) {
	this.studentName = studentName;
    }

    public ArrayList<Course> getcoursesEnroll() {
	return coursesEnroll;
    }

    public void setcoursesEnroll(ArrayList<Course> coursesEnroll) {
	this.coursesEnroll = coursesEnroll;
    }

    @Override
    public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", coursesEnroll=" + coursesEnroll
		+ "]";
    }

}

public class StudentRoaster {

    // public static List<Course> courseList = new ArrayList<>();

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> studentRoster = new ArrayList<>();
	int nextStudentId = 1;

	while (true) {
	    System.out.println("\n----- Student Roster Management System -----");
	    System.out.println("1. Add a new student to the roster.");
	    System.out.println("2. Enroll a student in a course.");
	    System.out.println("3. Display the list of courses a student is enrolled in.");
	    System.out.println(
		    "4. Display the list of all students in the roster along with their ID and enrolled courses.");
	    System.out.println("5. Remove a student from the roster using the given ID.");
	    System.out.println("6. Exit the program.");
	    System.out.print("Enter your choice: ");

	    int ch = sc.nextInt();
	    sc.nextLine();

	    switch (ch) {
	    case 1:
		System.out.print("Enter the student name: ");
		String studentName = sc.nextLine();
		Student newStudent = new Student(nextStudentId, studentName);
		studentRoster.add(newStudent);
		System.out.println("Student name;" + studentName + "student Id:" + nextStudentId);
		nextStudentId++;
		System.out.println("Student added ");
		break;
	    case 2:
		System.out.println("Name of courses :");
		System.out.println("1.BE ");
		System.out.println("2.BBA");
		System.out.println("3.BCA");
		System.out.println("4.BCom");
		System.out.println("5.BBM");
		System.out.println("6.BA");
		System.out.print("Enter the student ID: ");
		int studIdEnroll = sc.nextInt();
		sc.nextLine();

		Student studEnroll = null;
		for (Student student : studentRoster) {
		    if (student.studentId == studIdEnroll) {
			studEnroll = student;
			break;
		    }
		}

		if (studEnroll == null) {
		    System.out.println("Student with ID " + studIdEnroll + " not found.");
		} else {
		    System.out.print("Enter the course ID: ");
		    int courseId = sc.nextInt();
		    sc.nextLine();
		    System.out.print("Enter the course name: ");
		    String courseName = sc.nextLine();

		    System.out.print("Enter the semester: ");
		    String semester = sc.nextLine();

		    Course course = new Course(courseId, courseName, semester);
		    studEnroll.coursesEnroll.add(course);
		    System.out.println("Student enrolled in the course successfully!");
		}
		break;
	    case 3:
		System.out.print("Enter the student ID: ");
		int studIdDis = sc.nextInt();
		sc.nextLine();

		Student studCourse = null;
		for (Student student : studentRoster) {
		    if (student.studentId == studIdDis) {
			studCourse = student;
			break;
		    }
		}

		if (studCourse == null) {
		    System.out.println("Student with ID " + studIdDis + " not found.");
		} else {
		    System.out.println("Courses enrolled by Student " + studCourse.studentName + ":");
		    for (Course course : studCourse.coursesEnroll) {
			System.out.println("Course ID: " + course.courseId + ", Course Name: " + course.courseName
				+ ", Semester: " + course.semester);
		    }
		}
		break;
	    case 4:
		System.out.println("List of all students and their enrolled courses:");
		for (Student student : studentRoster) {
		    System.out.println("Student ID: " + student.studentId + ", Student Name: " + student.studentName);
		    if (student.coursesEnroll.isEmpty()) {
			System.out.println("  No courses enrolled.");
		    } else {
			for (Course course : student.coursesEnroll) {
			    System.out.println("  Course ID: " + course.courseId + ", Course Name: " + course.courseName
				    + ", Semester: " + course.semester);
			}
		    }
		}
		break;
	    case 5:
		System.out.print("Enter the student ID to remove: ");
		int removeId = sc.nextInt();
		sc.nextLine();
		Student studRemove = null;
		for (Student student : studentRoster) {
		    if (student.studentId == removeId) {
			studRemove = student;
			break;
		    }
		}

		if (studRemove == null) {
		    System.out.println("Student not found.");
		} else {
		    studentRoster.remove(studRemove);
		    System.out.println("Student removed");
		}
		break;
	    case 6:
		System.out.println("Exiting the program.");
		sc.close();
		System.exit(0);

	    default:
		System.out.println(" Please enter a valid option.");
	    }
	}
    }

}
