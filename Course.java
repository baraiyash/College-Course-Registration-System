public class Course {

    private int courseId;
    private String courseName;
    private int seats;

    public Course(int courseId, String courseName, int seats) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.seats = seats;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getSeats() {
        return seats;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void decreaseSeat() {
        seats--;
    }

    public void increaseSeat() {
        seats++;
    }

    public void display() {
        System.out.println(
                courseId + " - " +
                        courseName + " | Seats Available: " + seats);
    }
}