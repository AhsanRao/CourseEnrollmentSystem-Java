# Course Enrollment Management Program
This is a console-based program written in Java for course enrollment management. It allows students to search for a course by keyword, enroll in a course, display all their enrolled courses, withdraw from a course, and exit the program. The program reads course information from a CSV file and outputs the new CSV file with updated student enrollment numbers.

# Installation
1. Clone the repository to your local machine
2. Open the project in your preferred IDE
3. Run the program

# Usage
Upon running the program, the user will be presented with a menu of options:

1. Search for a course by keyword
2. Enroll in a course
3. Display all enrolled courses
4. Withdraw from a course
5. Exit the program

# Search for a course by keyword
The user can search for a course by entering a keyword (e.g., "programming"). The program will list all courses that match the keyword (case-insensitive). The user can then choose a course from the list.

# Enroll in a course
Once the user has selected a course, the program will add it to the user's list of enrolled courses.

# Display all enrolled courses
The user can choose to display all the courses they have enrolled in.

# Withdraw from a course
The user can choose to withdraw from a course they have enrolled in.

# Exit the program
The user can choose to exit the program. The program keep records after termination.

# CSV file format
The program reads course information from a CSV file with the following format:

    Course name,Capacity,Year,Delivery mode,Day of lecture,Time of lecture,Duration of lecture (hour)
    Java programming,120,Year 1,Face-to-face,Wednesday,11:30,2
    Programming skills,500,Year 1,Face-to-face,Tuesday,8:30,1
    Advanced Python programming,40,Year 2,Face-to-face,Friday,16:00,1.5

The program outputs the new CSV file with updated enrollment counts.

# Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.