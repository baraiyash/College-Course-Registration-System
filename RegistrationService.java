import java.util.ArrayList;
import java.util.Iterator;

public class RegistrationService {

    public void showCourses(ArrayList<Course> courses) {
        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            c.display();
        }
    }

    public void registerCourse(Student s, Course c)
            throws CourseFullException, AlreadyRegisteredException {

        for (Course x : s.getRegisteredCourses()) {
            if (x.getCourseId() == c.getCourseId()) {
                throw new AlreadyRegisteredException("Already Registered!");
            }
        }

        if (c.getSeats() <= 0) {
            throw new CourseFullException("Course Full!");
        }

        s.getRegisteredCourses().add(c);
        c.decreaseSeat();

        System.out.println("Course Registered Successfully.");
    }

    public void dropCourse(Student s, int id) {

        Iterator<Course> it = s.getRegisteredCourses().iterator();

        while (it.hasNext()) {
            Course c = it.next();

            if (c.getCourseId() == id) {
                c.increaseSeat();
                it.remove();
                System.out.println("Course Dropped Successfully.");
                return;
            }
        }

        System.out.println("Course Not Found.");
    }

    public void showRegisteredCourses(Student s) {

        if (s.getRegisteredCourses().isEmpty()) {
            System.out.println("No Registered Courses.");
            return;
        }

        System.out.println("\nRegistered Courses:");

        for (Course c : s.getRegisteredCourses()) {
            System.out.println(c.getCourseName());
        }
    }

    public void addCourse(ArrayList<Course> courses, Course c) {
        courses.add(c);
        System.out.println("Course Added Successfully.");
    }
}