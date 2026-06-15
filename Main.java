import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        HashMap<Integer, Student> students = new HashMap<>();

        // Default Courses
        courses.add(new Course(101, "Java", 2));
        courses.add(new Course(102, "Python", 3));
        courses.add(new Course(103, "Database", 2));

        // Default Students
        students.put(1, new Student(1, "Yash"));
        students.put(2, new Student(2, "Rahul"));
        students.put(3, new Student(3, "Priya"));

        Admin admin = new Admin(99, "Admin");

        RegistrationService service = new RegistrationService();

        while (true) {

            try {

                System.out.println("\n===== College Course Registration System =====");
                System.out.println("1. Student Login");
                System.out.println("2. Admin Panel");
                System.out.println("3. Exit");

                System.out.print("Enter Choice: ");

                int mainChoice = sc.nextInt();

                switch (mainChoice) {

                    // =====================================
                    // STUDENT LOGIN
                    // =====================================
                    case 1:

                        System.out.print(
                                "Enter Student ID: ");

                        int studentId = sc.nextInt();

                        Student currentStudent = students.get(studentId);

                        if (currentStudent == null) {

                            System.out.println(
                                    "Student Not Found.");

                            break;
                        }

                        Person p1 = currentStudent;
                        p1.dashboard();

                        while (true) {

                            System.out.println(
                                    "\n===== Student Menu =====");

                            System.out.println(
                                    "1. View Courses");

                            System.out.println(
                                    "2. Search Course");

                            System.out.println(
                                    "3. Register Course");

                            System.out.println(
                                    "4. Drop Course");

                            System.out.println(
                                    "5. View Registered Courses");

                            System.out.println(
                                    "6. View Profile Summary");

                            System.out.println(
                                    "7. Logout");

                            System.out.print(
                                    "Enter Choice: ");

                            int ch = sc.nextInt();

                            if (ch == 7) {

                                System.out.println(
                                        "Logged Out Successfully.");

                                break;
                            }

                            switch (ch) {

                                case 1:

                                    service.showCourses(
                                            courses);

                                    break;

                                case 2:

                                    sc.nextLine();

                                    System.out.print(
                                            "Enter Course Name: ");

                                    String keyword = sc.nextLine();

                                    service.searchCourse(
                                            courses,
                                            keyword);

                                    break;

                                case 3:

                                    System.out.print(
                                            "Enter Course ID: ");

                                    int cid = sc.nextInt();

                                    boolean found = false;

                                    for (Course c : courses) {

                                        if (c.getCourseId() == cid) {

                                            service.registerCourse(
                                                    currentStudent,
                                                    c);

                                            found = true;

                                            break;
                                        }
                                    }

                                    if (!found) {

                                        System.out.println(
                                                "Course Not Found.");
                                    }

                                    break;

                                case 4:

                                    System.out.print(
                                            "Enter Course ID to Drop: ");

                                    int dropId = sc.nextInt();

                                    service.dropCourse(
                                            currentStudent,
                                            dropId);

                                    break;

                                case 5:

                                    service.showRegisteredCourses(
                                            currentStudent);

                                    break;

                                case 6:

                                    currentStudent.displayProfile();

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid Choice.");
                            }
                        }

                        break;

                    // =====================================
                    // ADMIN PANEL
                    // =====================================
                    case 2:

                        Person p2 = admin;
                        p2.dashboard();

                        while (true) {

                            System.out.println(
                                    "\n===== Admin Menu =====");

                            System.out.println(
                                    "1. Add Student");

                            System.out.println(
                                    "2. View Students");

                            System.out.println(
                                    "3. Add Course");

                            System.out.println(
                                    "4. Remove Course");

                            System.out.println(
                                    "5. View Courses");

                            System.out.println(
                                    "6. Back");

                            System.out.print(
                                    "Enter Choice: ");

                            int ch = sc.nextInt();

                            if (ch == 6)
                                break;

                            switch (ch) {

                                case 1:

                                    System.out.print(
                                            "Enter Student ID: ");

                                    int sid = sc.nextInt();

                                    sc.nextLine();

                                    System.out.print(
                                            "Enter Student Name: ");

                                    String sname = sc.nextLine();

                                    service.addStudent(
                                            students,
                                            new Student(
                                                    sid,
                                                    sname));

                                    break;

                                case 2:

                                    service.viewStudents(
                                            students);

                                    break;

                                case 3:

                                    System.out.print(
                                            "Enter Course ID: ");

                                    int id = sc.nextInt();

                                    sc.nextLine();

                                    System.out.print(
                                            "Enter Course Name: ");

                                    String cname = sc.nextLine();

                                    System.out.print(
                                            "Enter Seats: ");

                                    int seats = sc.nextInt();

                                    service.addCourse(
                                            courses,
                                            new Course(
                                                    id,
                                                    cname,
                                                    seats));

                                    break;

                                case 4:

                                    System.out.print(
                                            "Enter Course ID: ");

                                    int removeId = sc.nextInt();

                                    service.removeCourse(
                                            courses,
                                            removeId);

                                    break;

                                case 5:

                                    service.showCourses(
                                            courses);

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid Choice.");
                            }
                        }

                        break;

                    // =====================================
                    // EXIT
                    // =====================================
                    case 3:

                        System.out.println(
                                "Thank You");

                        System.exit(0);

                    default:

                        System.out.println(
                                "Invalid Choice.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Enter Numbers Only.");

                sc.nextLine();

            } catch (Exception e) {

                System.out.println(
                        e.getMessage());

            } finally {

                System.out.println(
                        "--------------------------------");
            }
        }
    }
}