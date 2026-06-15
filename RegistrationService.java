import java.util.*;

public class RegistrationService {

    // ==============================
    // VIEW ALL COURSES
    // ==============================
    public void showCourses(ArrayList<Course> courses) {

        if (courses.isEmpty()) {
            System.out.println("No Courses Available.");
            return;
        }

        System.out.println("\n===== Available Courses =====");

        for (Course c : courses) {
            c.display();
        }
    }

    // ==============================
    // SEARCH COURSE
    // ==============================
    public void searchCourse(ArrayList<Course> courses, String keyword) {

        boolean found = false;

        for (Course c : courses) {

            if (c.getCourseName().equalsIgnoreCase(keyword)) {

                System.out.println("\nCourse Found:");
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Course Not Found.");
        }
    }

    // ==============================
    // REGISTER COURSE
    // ==============================
    public void registerCourse(Student s, Course c)
            throws CourseFullException,
            AlreadyRegisteredException,
            CourseLimitExceededException {

        if (s.getRegisteredCourses().size() >= s.getMaxCourses()) {

            throw new CourseLimitExceededException(
                    "Maximum Course Limit Reached!");
        }

        for (Course x : s.getRegisteredCourses()) {

            if (x.getCourseId() == c.getCourseId()) {

                throw new AlreadyRegisteredException(
                        "Already Registered!");
            }
        }

        if (c.getSeats() <= 0) {

            throw new CourseFullException(
                    "Course Full!");
        }

        s.getRegisteredCourses().add(c);

        c.decreaseSeat();

        System.out.println(
                "Course Registered Successfully.");
    }

    // ==============================
    // DROP COURSE
    // ==============================
    public void dropCourse(Student s, int courseId) {

        Iterator<Course> it = s.getRegisteredCourses().iterator();

        while (it.hasNext()) {

            Course c = it.next();

            if (c.getCourseId() == courseId) {

                c.increaseSeat();

                it.remove();

                System.out.println(
                        "Course Dropped Successfully.");

                return;
            }
        }

        System.out.println(
                "Course Not Found.");
    }

    // ==============================
    // SHOW REGISTERED COURSES
    // ==============================
    public void showRegisteredCourses(Student s) {

        if (s.getRegisteredCourses().isEmpty()) {

            System.out.println(
                    "No Registered Courses.");

            return;
        }

        System.out.println(
                "\n===== Registered Courses =====");

        for (Course c : s.getRegisteredCourses()) {

            System.out.println(
                    c.getCourseName());
        }
    }

    // ==============================
    // ADD COURSE
    // ==============================
    public void addCourse(
            ArrayList<Course> courses,
            Course c) {

        courses.add(c);

        System.out.println(
                "Course Added Successfully.");
    }

    // ==============================
    // REMOVE COURSE
    // ==============================
    public void removeCourse(
            ArrayList<Course> courses,
            int courseId) {

        Iterator<Course> it = courses.iterator();

        while (it.hasNext()) {

            Course c = it.next();

            if (c.getCourseId() == courseId) {

                it.remove();

                System.out.println(
                        "Course Removed Successfully.");

                return;
            }
        }

        System.out.println(
                "Course Not Found.");
    }

    // ==============================
    // UPDATE COURSE
    // ==============================
    public void updateCourse(
            ArrayList<Course> courses,
            int courseId,
            String newName,
            int newSeats) {

        for (Course c : courses) {

            if (c.getCourseId() == courseId) {

                c.setCourseName(newName);

                c.setSeats(newSeats);

                System.out.println(
                        "Course Updated Successfully.");

                return;
            }
        }

        System.out.println(
                "Course Not Found.");
    }

    // ==============================
    // ADD STUDENT
    // ==============================
    public void addStudent(
            HashMap<Integer, Student> students,
            Student s) {

        students.put(s.id, s);

        System.out.println(
                "Student Added Successfully.");
    }

    // ==============================
    // VIEW STUDENTS
    // ==============================
    public void viewStudents(
            HashMap<Integer, Student> students) {

        if (students.isEmpty()) {

            System.out.println(
                    "No Students Found.");

            return;
        }

        System.out.println(
                "\n===== Students =====");

        for (Student s : students.values()) {

            System.out.println(
                    "ID : " + s.id +
                            " | Name : " + s.name);
        }
    }

    // ==============================
    // VIEW STUDENT REGISTRATIONS
    // ==============================
    public void viewStudentRegistrations(
            Student s) {

        System.out.println(
                "\nStudent : " + s.name);

        if (s.getRegisteredCourses().isEmpty()) {

            System.out.println(
                    "No Courses Registered.");

            return;
        }

        for (Course c : s.getRegisteredCourses()) {

            System.out.println(
                    c.getCourseName());
        }
    }

    // ==============================
    // COURSE SEAT REPORT
    // ==============================
    public void seatAvailabilityReport(
            ArrayList<Course> courses) {

        System.out.println(
                "\n===== Seat Availability Report =====");

        for (Course c : courses) {

            System.out.println(
                    c.getCourseId()
                            + " | "
                            + c.getCourseName()
                            + " | Seats : "
                            + c.getSeats());
        }
    }

    // ==============================
    // SORT BY NAME
    // ==============================
    public void sortCoursesByName(
            ArrayList<Course> courses) {

        Collections.sort(
                courses,
                Comparator.comparing(
                        Course::getCourseName));

        System.out.println(
                "Courses Sorted By Name.");
    }

    // ==============================
    // SORT BY SEATS
    // ==============================
    public void sortCoursesBySeats(
            ArrayList<Course> courses) {

        Collections.sort(
                courses,
                Comparator.comparingInt(
                        Course::getSeats));

        System.out.println(
                "Courses Sorted By Seats.");
    }
}