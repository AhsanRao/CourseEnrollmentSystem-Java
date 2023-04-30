import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class ManagementSystem {
    private List<Course> courses;

    public ManagementSystem() {
        courses = new ArrayList<>();
    }

    public ManagementSystem(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void enrollInCourse(String courseName) {
        Course course = findCourseByName(courseName, courses);
        if (course == null) {
            System.out.println("Course not found: " + courseName);
        } else if (!course.isAvailable()) {
            System.out.println("Course is full: " + courseName);
        } else {
            course.enroll();
            System.out.println("Enrolled in course: " + courseName);
        }
    }

    public void displayEnrolledCourses() {
        int i = 1;
        for (Course course : courses) {
            if (course.getEnrolledStudents() > 0) {
                String timediff =  getEndTime(course.getTimeOfLecture() , course.getDuration());
                System.out.printf("%5d%s%-35s%-19s%-11s%s\n" , i , ")" , course.getName() , course.getDeliveryMode() , course.getDayOfLecture() , timediff);
                i++;
            }
        }
        if(i == 1){
            System.out.println("No enrolled courses");
        }
    }

    public void displayCourses() {
        int i = 1;
        for (Course course : courses) {
            String timediff =  getEndTime(course.getTimeOfLecture() , course.getDuration());
            System.out.printf("%5d%s%-35s%-19s%-11s%s\n" , i , ")" , course.getName() , course.getDeliveryMode(),course.getDayOfLecture() ,timediff);
            i++;
        }
    }

    public Map<Integer,String> getEnrolledCourses() {
        int i = 1;
        Map<Integer,String> enrolledCourses = new HashMap<>();
        for (Course course : courses) {
            if (course.getEnrolledStudents() > 0) {
                enrolledCourses.put(i,course.getName());
                i++;
            }
        }
        if(i == 1){
            System.out.println("No enrolled courses");
        }
        return enrolledCourses;
    }

    public void withdrawFromCourse(String courseName) {
        Course course = findCourseByName(courseName, courses);
        if (course == null) {
            System.out.println("Course not found: " + courseName);
        } else if (course.getEnrolledStudents() == 0) {
            System.out.println("Not enrolled in course: " + courseName);
        } else {
            course.withdraw();
            System.out.println("Withdrawn from course: " + courseName);
        }
    }

    public boolean hasEnrolledCourses() {
        for(Course course : courses) {
            if(course.getEnrolledStudents() > 0) {
                return true;
            }
        }
        return false;
    }

    public static Course findCourseByName(String courseName, List<Course> courses) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    public void LoadCourses() {
        try{
            courses = new ArrayList<>();
            File file = new File("course.csv");
            Scanner scanner = new Scanner(file);
            // Skip the header line
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] courseData = line.split(",");
                String courseName = courseData[0];
                int capacity = Integer.parseInt(courseData[1]);
                String year = courseData[2];
                String deliveryMode = courseData[3];
                String dayOfLecture = courseData[4];
                String timeOfLecture = courseData[5];
                double duration = Double.parseDouble(courseData[6]);
                Course course = new Course(courseName, capacity, year, deliveryMode, dayOfLecture, timeOfLecture, duration);
                courses.add(course);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void saveCourses(String fileName) {
        // Store the course details back to the CSV file
        fileName = fileName + ".csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Course Name,Capacity,Year,Delivery Mode,Day of Lecture,Time of Lecture,Duration,Enrolled Students");
            bw.newLine();
            for (Course course : courses) {
                bw.write(course.getName() + "," + course.getCapacity() + "," + course.getYear() + "," + course.getDeliveryMode()
                        + "," + course.getDayOfLecture() + "," + course.getTimeOfLecture() + "," + course.getDuration()
                        + "," + course.getEnrolledStudents());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<Integer,String> matchingCourses(String keyword){
        List<Course> matchingCourses = searchCourses(keyword, courses);
        if (matchingCourses.isEmpty()) {
            System.out.println("No courses found matching the keyword '" + keyword + "'.");
            return null;
        }
        Map<Integer,String> courseMap = new HashMap<>();
        int i = 1;
        System.out.println("\n----------------------------------------------------------------------------------------");
        System.out.println("> Select From the List:");
        System.out.println("----------------------------------------------------------------------------------------");
        for (Course course : matchingCourses) {
            String timediff = getEndTime(course.getTimeOfLecture(), course.getDuration());
            System.out.printf("%5d%s%-35s%-19s%s\n" , i , ")" , course.getName() , course.getDeliveryMode() , course.getDayOfLecture());
                courseMap.put(i,course.getName());
                i++;
        }
        return courseMap;
    }

    public String getEndTime(String startTime, double duration) {
        // Parse the start time string into hours and minutes
        String[] parts = startTime.split(":");
        int startHour = Integer.parseInt(parts[0]);
        int startMinute = Integer.parseInt(parts[1]);

        // Calculate the end time in minutes since midnight
        int endMinute = (int) ((startHour * 60 + startMinute) + duration * 60);

        // Convert the end time back to hours and minutes
        int endHour = endMinute / 60;
        int endMinuteOfHour = endMinute % 60;

        // Format the end time as a string in the same format as the start time
        return String.format("%02d:%02d-%02d:%02d", startHour, startMinute, endHour, endMinuteOfHour);
    }

    // Search for courses that match the keyword
    private static List<Course> searchCourses(String keyword, List<Course> courses) {
        List<Course> matchingCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getName().toLowerCase().contains(keyword) || course.getYear().toLowerCase().contains(keyword)
                    || course.getDeliveryMode().toLowerCase().contains(keyword)) {
                matchingCourses.add(course);
            }
        }
        return matchingCourses;
    }
}