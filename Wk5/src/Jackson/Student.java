package Jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Student {

    // Define the Course class with Jackson annotations
    public static class Course {
        @JsonProperty("course_name")
        private String courseName;
        @JsonProperty("course_code")
        private String courseCode;
        @JsonProperty("credits")
        private int credits;

        // Default constructor needed for deserialization
        public Course() {}

        // Constructor with JsonCreator annotation to map JSON properties
        @JsonCreator
        public Course(@JsonProperty("course_name") String courseName,
                      @JsonProperty("course_code") String courseCode,
                      @JsonProperty("credits") int credits) {
            this.courseName = courseName;
            this.courseCode = courseCode;
            this.credits = credits;
        }

        // Getters and setters
        public String getCourseName() {
            return courseName;
        }
        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
        public String getCourseCode() {
            return courseCode;
        }
        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }
        public int getCredits() {
            return credits;
        }
        public void setCredits(int credits) {
            this.credits = credits;
        }

        // Override toString() for pretty printing
        @Override
        public String toString() {
            return "Course{" +
                    "courseName='" + courseName + '\'' +
                    ", courseCode='" + courseCode + '\'' +
                    ", credits=" + credits +
                    '}';
        }
    }

    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Create a Course instance
            Course course = new Course("Data Structures", "CS201", 4);

            // 1. Serialization: Convert the Course object to a JSON string
            String courseJson = mapper.writeValueAsString(course);
            System.out.println("Serialized JSON:");
            System.out.println(courseJson);
            System.out.println();

            // 2. JSON Tree Manipulation: Parse the JSON string into a JsonNode
            JsonNode rootNode = mapper.readTree(courseJson);

            // Modify the JSON: change "credits" from 4 to 5
            if (rootNode instanceof ObjectNode) {
                ((ObjectNode) rootNode).put("credits", 5);
            }

            // Print the modified JSON in a pretty format
            String modifiedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            System.out.println("Modified JSON:");
            System.out.println(modifiedJson);
            System.out.println();

            // 3. Deserialization: Convert the modified JSON back into a Course object
            Course updatedCourse = mapper.readValue(rootNode.toString(), Course.class);
            System.out.println("Deserialized Course Object:");
            System.out.println(updatedCourse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}