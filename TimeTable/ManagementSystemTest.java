import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ManagementSystemTest {
    private ManagementSystem courseManager;
    private List<Course> courses;

    @BeforeEach
    public void setup() {
        courses = new ArrayList<>();
        courses.add(new Course("Math", 30, "2020","Online", "Monday", "10:00", 2));
        courses.add(new Course("Science", 20,"2021", "In-person", "Wednesday", "14:00", 1));
       // courses.add(new Course("History", 25, "Hybrid", "Friday", "9:00", 3));
        courseManager = new ManagementSystem(courses);
    }

//    @Test
//    public void testEnrollInCourse() {
//        // Test enrolling in a valid course
//        courseManager.enrollInCourse("Math");
//        Assertions.assertEquals(1, courseManager.getEnrolledCourses().get(0).getEnrolledStudents());
//
//        // Test enrolling in a full course
//        courseManager.enrollInCourse("English");
//        courseManager.enrollInCourse("English");
//        Assertions.assertEquals(2, courseManager.getCourses().get(1).getEnrolledStudents());
//        courseManager.enrollInCourse("English");
//        Assertions.assertEquals(2, courseManager.getCourses().get(1).getEnrolledStudents());
//
//        // Test enrolling in a non-existent course
//        courseManager.enrollInCourse("History");
//        Assertions.assertEquals("Course not found: History", systemOut().getHistory());
//    }

//    @Test
//    public void testDisplayEnrolledCourses() {
//        // Test displaying enrolled courses
//        courseManager.enrollInCourse("Math");
//        courseManager.enrollInCourse("English");
//        assertEquals("    1) Math                              Online            Monday              14:30              \n" +
//                "    2) English                           In-person         Wednesday           11:30              \n",
//                systemOut().courseManager.displayEnrolledCourses());
//
//        // Test displaying no enrolled courses
//        Assertions.assertDoesNotThrow(() -> courseManager.displayEnrolledCourses());
//        Assertions.assertEquals("No enrolled courses\n", courses);
//    }

//    @Test
//    public void testDisplayCourses() {
//        // Test displaying all courses
//        Assertions.assertDoesNotThrow(() -> courseManager.displayCourses());
//        Assertions.assertEquals("    1) Math                              Online            Monday              14:30              \n" +
//                "    2) English                           In-person         Wednesday           11:30              \n", systemOut().getHistory());
//    }
//
//    private static TextFromStandardOutputStream systemOut() {
//        return new TextFromStandardOutputStream();
//    }
//
//    @Test
//    public void testEnrollInCourse() {
//        courseManager.enrollInCourse("Math");
//        Assertions.assertEquals(1, courseManager.getEnrolledCourses().size());
//        Assertions.assertEquals("Math", courseManager.getEnrolledCourses().get(1));
//        courseManager.enrollInCourse("Science");
//        Assertions.assertEquals(2, courseManager.getEnrolledCourses().size());
//        Assertions.assertEquals("Science", courseManager.getEnrolledCourses().get(2));
//    }
//
//    @Test
//    public void testEnrollInNonexistentCourse() {
//        courseManager.enrollInCourse("English");
//        Assertions.assertEquals(0, courseManager.getEnrolledCourses().size());
//        Assertions.assertEquals("Course not found: English", systemOut());
//    }
//
//    @Test
//    public void testEnrollInFullCourse() {
//        courseManager.enrollInCourse("History");
//        courseManager.enrollInCourse("History");
//        courseManager.enrollInCourse("History");
//        Assertions.assertEquals(3, courseManager.findCourseByName("History", courses).getEnrolledStudents());
//        courseManager.enrollInCourse("History");
//        Assertions.assertEquals(3, courseManager.findCourseByName("History", courses).getEnrolledStudents());
//        Assertions.assertEquals("Course is full: History", systemOut());
//    }
//
//    @Test
//    public void testDisplayEnrolledCourses() {
//        Assertions.assertEquals("No enrolled courses\n", systemOut());
//        courseManager.enrollInCourse("Math");
//        courseManager.enrollInCourse("Science");
//        Assertions.assertEquals("   1) Math                                Online              Monday          12:00\n" +
//                "   2) Science                             In-person           Wednesday       15:00\n", systemOut());
//    }
//
//    @Test
//    public void testDisplayCourses() {
//        Assertions.assertEquals("   1) Math                                Online              Monday          12:00\n" +
//                "   2) Science                             In-person           Wednesday       15:00\n" +
//                "   3) History                             Hybrid              Friday          12:00\n", systemOut());
//    }
//
//    @Test
//    public void testWithdrawFromCourse() {
//        courseManager.enrollInCourse("Math");
//        courseManager.withdrawFromCourse("Math");
//        Assertions.assertEquals(0, courseManager.getEnrolledCourses().size());
//        Assertions.assertEquals(0, courseManager.findCourseByName("Math", courses).getEnrolledStudents());
//        Assertions.assertEquals("Withdrawn from course: Math\n", systemOut());
//    }
//
//    @Test
//    public void testWithdrawFromNonexistentCourse() {
//        courseManager.withdrawFromCourse("English");
//        Assertions.assertEquals("Course not found: English\n", System.out(courses));
//    }
////
//    @Test
//    public void testGetEndTime() {
//        String startTime = "09:00";
//        double duration = 1.5;
//        String expectedEndTime = "09:00-10:30";
//        String actualEndTime = MyClass.getEndTime(startTime, duration);
//        assertEquals(expectedEndTime, actualEndTime);
//    }
//
//    @Test
//    public void testLoadCourses() {
//        try {
//            List<Course> expectedCourses = new ArrayList<>();
//            expectedCourses.add(new Course("CS101", 50, "2023", "In-person", "Monday", "10:00", 1.5));
//            expectedCourses.add(new Course("CS102", 40, "2023", "Online", "Tuesday", "12:00", 2.0));
//            expectedCourses.add(new Course("CS103", 30, "2024", "Hybrid", "Wednesday", "14:00", 1.0));
//            expectedCourses.add(new Course("CS104", 60, "2024", "In-person", "Thursday", "16:00", 1.5));
//
//            MyClass myClass = new MyClass();
//            myClass.LoadCourses();
//
//            List<Course> actualCourses = myClass.getCourses();
//
//            assertEquals(expectedCourses.size(), actualCourses.size());
//
//            for (int i = 0; i < expectedCourses.size(); i++) {
//                Course expectedCourse = expectedCourses.get(i);
//                Course actualCourse = actualCourses.get(i);
//                assertEquals(expectedCourse.getName(), actualCourse.getName());
//                assertEquals(expectedCourse.getCapacity(), actualCourse.getCapacity());
//                assertEquals(expectedCourse.getYear(), actualCourse.getYear());
//                assertEquals(expectedCourse.getDeliveryMode(), actualCourse.getDeliveryMode());
//                assertEquals(expectedCourse.getDayOfLecture(), actualCourse.getDayOfLecture());
//                assertEquals(expectedCourse.getTimeOfLecture(), actualCourse.getTimeOfLecture());
//                assertEquals(expectedCourse.getDuration(), actualCourse.getDuration(), 0.001);
//            }
//        } catch (FileNotFoundException e) {
//            fail("course.csv not found");
//        }
//    }
//
//    @Test
//    public void testMatchingCourses() {
//        courses.add(course1);
//        courses.add(course2);
//        courses.add(course3);
//
//        // Test with keyword that matches one course
//        Map<Integer, String> expected1 = new HashMap<>();
//        expected1.put(1, "Course 1");
//        Map<Integer, String> result1 = CourseManager.matchingCourses("Course");
//        assertEquals(expected1, result1);
//
//        // Test with keyword that matches multiple courses
//        Map<Integer, String> expected2 = new HashMap<>();
//        expected2.put(1, "Course 1");
//        expected2.put(2, "Course 2");
//        Map<Integer, String> result2 = CourseManager.matchingCourses("202");
//        assertEquals(expected2, result2);
//
//        // Test with keyword that doesn't match any courses
//        Map<Integer, String> result3 = CourseManager.matchingCourses("Basket Weaving");
//        assertNull(result3);
//    }
//
//    @Test
//    public void testSearchCourses() {
//        courses.add(course1);
//        courses.add(course2);
//        courses.add(course3);
//
//        // Test with keyword that matches one course
//        List<Course> expected1 = new ArrayList<>();
//        expected1.add(course2);
//        List<Course> result1 = CourseManager.searchCourses("Tuesday", courses);
//        assertEquals(expected1, result1);
//
//        // Test with keyword that matches multiple courses
//        List<Course> expected2 = new ArrayList<>();
//        expected2.add(course1);
//        expected2.add(course3);
//        List<Course> result2 = CourseManager.searchCourses("2023", courses);
//        assertEquals(expected2, result2);
//
//        // Test with keyword that doesn't match any courses
//        List<Course> expected3 = new ArrayList<>();
//        List<Course> result3 = CourseManager.searchCourses("Friday", courses);
//        assertEquals(expected3, result3);
//    }
}