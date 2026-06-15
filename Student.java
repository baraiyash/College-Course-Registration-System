import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Course> registeredCourses;
    private final int MAX_COURSES = 5;

    public Student(int id, String name) {
        super(id, name);
        registeredCourses = new ArrayList<>();
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public int getMaxCourses() {
        return MAX_COURSES;
    }

    public int getTotalCourses() {
        return registeredCourses.size();
    }

    public void displayProfile() {

        System.out.println("\n===== Student Profile =====");
        System.out.println("Student ID : " + getId());
        System.out.println("Student Name : " + getName());
        System.out.println("Total Registered Courses : "
                + registeredCourses.size());
    }

    @Override
    public void dashboard() {
        System.out.println("\n===== Student Dashboard =====");
        System.out.println("Welcome, " + getName());
    }
}