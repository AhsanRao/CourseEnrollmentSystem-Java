public class Course {
    private String name;
    private int capacity;
    private String year;
    private String deliveryMode;
    private String dayOfLecture;
    private String timeOfLecture;
    private double duration;
    private int enrolledStudents;

    public Course(String name, int capacity, String year, String deliveryMode, String dayOfLecture, String timeOfLecture, double duration) {
        this.name = name;
        this.capacity = capacity;
        this.year = year;
        this.deliveryMode = deliveryMode;
        this.dayOfLecture = dayOfLecture;
        this.timeOfLecture = timeOfLecture;
        this.duration = duration;
        this.enrolledStudents = 0;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getYear() {
        return year;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public String getDayOfLecture() {
        return dayOfLecture;
    }

    public String getTimeOfLecture() {
        return timeOfLecture;
    }

    public double getDuration() {
        return duration;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enroll() {
        enrolledStudents++;
    }

    public void withdraw() {
        enrolledStudents--;
    }

    public void display() {
        System.out.println("Course name: " + name);
        System.out.println("Capacity: " + capacity);
        System.out.println("Year: " + year);
        System.out.println("Delivery mode: " + deliveryMode);
        System.out.println("Day of lecture: " + dayOfLecture);
        System.out.println("Time of lecture: " + timeOfLecture);
        System.out.println("Duration: " + duration);
        System.out.println("Enrolled students: " + enrolledStudents);
    }

    public boolean isAvailable() {
        return enrolledStudents < capacity;
    }
}