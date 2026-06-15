import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        HashMap<Integer, Student> students = new HashMap<>();

        courses.add(new Course(101, "Java", 2));
        courses.add(new Course(102, "Python", 3));
        courses.add(new Course(103, "Database", 2));

        Student s1 = new Student(1, "Yash");
        students.put(1, s1);

        Admin admin = new Admin(99, "Admin");

        RegistrationService service = new RegistrationService();

        while (true) {

            try {

                System.out.println("\n===== College Course Registration System =====");
                System.out.println("1. Student");
                System.out.println("2. Admin");
                System.out.println("3. Exit");
                System.out.print("Enter Choice: ");

                int mainChoice = sc.nextInt();

                switch (mainChoice) {

                    case 1:

                        Person p1 = students.get(1);
                        p1.dashboard();

                        while (true) {

                            System.out.println("\n1. View Courses");
                            System.out.println("2. Register Course");
                            System.out.println("3. Drop Course");
                            System.out.println("4. View Registered Courses");
                            System.out.println("5. Back");

                            int ch = sc.nextInt();

                            if (ch == 5)
                                break;

                            switch (ch) {

                                case 1:
                                    service.showCourses(courses);
                                    break;

                                case 2:
                                    System.out.print("Enter Course ID: ");
                                    int cid = sc.nextInt();

                                    for (Course c : courses) {
                                        if (c.getCourseId() == cid) {
                                            service.registerCourse(s1, c);
                                        }
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter Course ID: ");
                                    int dropId = sc.nextInt();
                                    service.dropCourse(s1, dropId);
                                    break;

                                case 4:
                                    service.showRegisteredCourses(s1);
                                    break;

                                default:
                                    System.out.println("Invalid Choice");
                            }
                        }
                        break;

                    case 2:

                        Person p2 = admin;
                        p2.dashboard();

                        while (true) {

                            System.out.println("\n1. Add Course");
                            System.out.println("2. View Courses");
                            System.out.println("3. Back");

                            int ch = sc.nextInt();

                            if (ch == 3)
                                break;

                            switch (ch) {

                                case 1:
                                    System.out.print("Enter Course ID: ");
                                    int id = sc.nextInt();

                                    sc.nextLine();

                                    System.out.print("Enter Course Name: ");
                                    String name = sc.nextLine();

                                    System.out.print("Enter Seats: ");
                                    int seats = sc.nextInt();

                                    service.addCourse(courses,
                                            new Course(id, name, seats));
                                    break;

                                case 2:
                                    service.showCourses(courses);
                                    break;

                                default:
                                    System.out.println("Invalid Choice");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Thank You");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter Numbers Only.");
                sc.nextLine();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("--------------------------------");
            }
        }
    }
}