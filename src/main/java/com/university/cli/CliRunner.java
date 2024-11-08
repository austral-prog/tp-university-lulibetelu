package com.university.cli;

import com.university.cli.entities.CrudCourse;
import com.university.cli.entities.CrudEvaluation;
import com.university.cli.entities.CrudStudent;
import com.university.cli.exceptions.DuplicateIdException;
import com.university.cli.exceptions.EntityNotFoundException;
import com.university.course.Course;
import com.university.evaluation.Evaluation;
import com.university.evaluation.typesOfEval.FinalExam;
import com.university.evaluation.typesOfEval.OralExam;
import com.university.evaluation.typesOfEval.PracticalWork;
import com.university.evaluation.typesOfEval.WrittenExam;
import com.university.student.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CliRunner implements CLI {
    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {
            System.out.println("Select an entity: 1. Student, 2. Course, 3. Evaluation, 4. Exit program");
            int choice = 0;
            boolean correctChoice = false;
            while (!correctChoice) {
                try {
                    choice = scanner.nextInt();
                    correctChoice = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    System.out.println("Enter a number:");
                    scanner.nextLine();
                }
            }
            if (choice < 1 || choice > crudInterfaces.length + 1) {
                System.out.println("Invalid option.");
                continue;
            }

            if(choice != 4) {
                CRUDRepository<?> entity = crudInterfaces[choice - 1];
                System.out.println("Select operation: 1. Create, 2. Read, 3. Update, 4. Delete");
                boolean validNum = false;
                int operation = 0;
                while (!validNum) {
                    try {
                        operation = scanner.nextInt();
                        scanner.nextLine();
                        validNum = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        System.out.println("Enter a number:");
                        scanner.nextLine();
                    }
                }


                CrudStudent crudStudent = new CrudStudent();
                CrudCourse crudCourse = new CrudCourse();
                CrudEvaluation crudEvaluation = new CrudEvaluation();
                InputFormat inputFormat = new InputFormat();

                switch (operation) {
                    case 1:
                        if (entity.getIdentifier().equals("Student")) {
                            System.out.println("Student's name:");
                            String name = scanner.nextLine();
                            while (!inputFormat.nameFormat(name)) {
                                System.out.println("Enter valid name: ");
                                name = scanner.nextLine();
                            }

                            System.out.println("Student's mail:");
                            String mail = scanner.nextLine();
                            while (!inputFormat.emailFormat(mail)) {
                                System.out.println("Enter valid mail: ");
                                mail = scanner.nextLine();
                            }

                            System.out.println("Student's ID:");
                            int id;
                            Student student = null;
                            boolean correctID = false;
                            while(!correctID) {
                                try {
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    student = new Student(name, mail);
                                    student.setId(id);
                                    crudStudent.create(student);
                                    System.out.println("Student created successfully.");
                                    correctID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (DuplicateIdException e) {
                                    System.out.println("Evaluation creation failed: ID already exists.");
                                    System.out.println("Enter new ID: ");
                                    scanner.nextLine();
                                }
                            }

                            break;
                        }
                        else if (entity.getIdentifier().equals("Course")) {
                            System.out.println("Classroom number:");
                            String classroom = scanner.nextLine();
                            while (!inputFormat.classroomFormat(classroom)) {
                                System.out.println("Enter valid number: ");
                                classroom = scanner.nextLine();
                            }

                            System.out.println("Course's name:");
                            String subject = scanner.nextLine();
                            while (!inputFormat.nameFormat(subject)) {
                                System.out.println("Enter valid course: ");
                                subject = scanner.nextLine();
                            }

                            System.out.println("Teacher's name:");
                            String teacher = scanner.nextLine();
                            while (!inputFormat.nameFormat(teacher)) {
                                System.out.println("Enter valid name: ");
                                teacher = scanner.nextLine();
                            }

                            System.out.println("Course's ID:");
                            int id;
                            Course course = null;
                            boolean correctId = false;
                            while (!correctId) {
                                try {
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    course = new Course(classroom, subject, teacher);
                                    course.setId(id);
                                    crudCourse.create(course);
                                    System.out.println("Course created successfully.");
                                    correctId = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (DuplicateIdException e) {
                                    System.out.println("Course creation failed: ID already exists.");
                                    System.out.println("Enter new ID: ");
                                    scanner.nextLine();
                                }
                            }

                            break;
                        }
                        else if (entity.getIdentifier().equals("Evaluation")) {
                            System.out.println("An evaluation must have a student and a course.");
                            System.out.println("Enter student's ID:");
                            int studentID;
                            Student student = null;
                            boolean correctStudentID = false;
                            while (!correctStudentID) {
                                try {
                                    studentID = scanner.nextInt();
                                    scanner.nextLine();
                                    student = crudStudent.read(studentID);
                                    correctStudentID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Evaluation creation failed: ID already exists.");
                                    break;
                                }
                            }

                            if (!correctStudentID) {
                                break;
                            }

                            System.out.println("Enter course's ID:");

                            int courseID;
                            Course course = null;
                            boolean correctCourseID = false;
                            while (!correctCourseID) {
                                try {
                                    courseID = scanner.nextInt();
                                    scanner.nextLine();
                                    course = crudCourse.read(courseID);
                                    correctCourseID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Evaluation creation failed: ID already exists.");
                                    break;
                                }
                            }

                            if (!correctCourseID) {
                                break;
                            }

                            System.out.println("Evaluation name:");
                            String evalName = scanner.nextLine();
                            while (!inputFormat.nameFormat(evalName)) {
                                System.out.println("Enter valid name: ");
                                evalName = scanner.nextLine();
                            }

                            System.out.println("Select the evaluation's type:");
                            System.out.println("1. Final, 2. Practical Work, 3. Oral Exam, 4. Written Exam");
                            int type = 0;
                            try {
                                type = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Input must only have numerical characters.");
                                System.out.println("Enter a new number:");
                                scanner.nextLine();
                            }


                            Evaluation eval = null;
                            switch (type) {
                                case 1:
                                    eval = new FinalExam("Final", evalName);
                                    break;
                                case 2:
                                    eval = new PracticalWork("Practical Work", evalName);
                                    break;
                                case 3:
                                    eval = new OralExam("Oral Exam", evalName);
                                    break;
                                case 4:
                                    eval = new WrittenExam("Written Exam", evalName);
                                    break;
                                default:
                                    System.out.println("Enter a valid input:");

                            }

                            System.out.println("Evaluation ID:");
                            int evalID = 0;
                            try {
                                evalID = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("The ID can only have numerical characters.");
                                System.out.println("Enter a new ID:");
                                scanner.nextLine();
                            }


                            assert eval != null;
                            eval.setId(evalID);
                            assert student != null;
                            eval.setStudent(student);
                            assert course != null;
                            eval.setCourse(course);

                            boolean correctEvalID = false;
                            while (!correctEvalID) {
                                try {
                                    crudEvaluation.create(eval);
                                    System.out.println("Evaluation created successfully.");
                                    correctEvalID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (DuplicateIdException e) {
                                    System.out.println("Evaluation creation failed: ID already exists.");
                                    System.out.println("Enter new ID: ");
                                    scanner.nextLine();
                                }
                            }
                            break;
                        }
                    case 2:
                        if (entity.getIdentifier().equals("Student")) {
                            System.out.println("Student's ID:");
                            int id;

                            Student student = null;
                            boolean correctID = false;
                            while (!correctID) {
                                try {
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    student = crudStudent.read(id);
                                    correctID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Invalid student ID: ID does not exist.");
                                    break;
                                }
                            }
                            if (!correctID) {
                                break;
                            }
                            assert student != null;
                            System.out.println("Student information: ");
                            System.out.println("Name: " + student.getName());
                            System.out.println("Mail: " + student.getEmail());
                            break;
                        }
                        else if (entity.getIdentifier().equals("Course")) {
                            System.out.println("Course's Id:");
                            int id;

                            Course course = null;
                            boolean correctID = false;
                            while (!correctID) {
                                try {
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    course = crudCourse.read(id);
                                    correctID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Invalid course ID: ID does not exist.");
                                    break;
                                }
                            }
                            if (!correctID) {
                                break;
                            }
                            assert course != null;
                            System.out.println("Course information: ");
                            System.out.println("Classroom number: " + course.getClassroom());
                            System.out.println("Course name: " + course.getSubject());
                            System.out.println("Teacher's name: " + course.getTeacher());
                            break;

                        }
                        else if (entity.getIdentifier().equals("Evaluation")) {
                            System.out.println("Evaluation's ID:");
                            int id;

                            Evaluation evaluation = null;
                            boolean correctID = false;
                            while (!correctID) {
                                try {
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    evaluation = crudEvaluation.read(id);
                                    correctID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Invalid evaluation ID: ID does not exist.");
                                    break;
                                }
                            }
                            if (!correctID) {
                                break;
                            }
                            assert evaluation != null;
                            System.out.println("Evaluation information: ");
                            System.out.println("Student: " + evaluation.getStudent());
                            System.out.println("Course: " + evaluation.getCourse());
                            System.out.println("Evaluation type: " + evaluation.getEvaluationType());
                            System.out.println("Evaluation name: " + evaluation.getEvaluationName());
                            break;
                        }
                    case 3:
                        if (entity.getIdentifier().equals("Student")) {
                            System.out.println("Updated name:");
                            String name = scanner.nextLine();
                            while (!inputFormat.nameFormat(name)) {
                                System.out.println("Enter valid name: ");
                                name = scanner.nextLine();
                            }

                            System.out.println("Updated mail");
                            String mail = scanner.nextLine();
                            while (!inputFormat.emailFormat(mail)) {
                                System.out.println("Enter valid mail: ");
                                mail = scanner.nextLine();
                            }

                            System.out.println("Id:");
                            int id;

                            Student updatedStudent = new Student(name, mail);
                            boolean correctID = false;
                            while (!correctID) {
                                try {
                                    id = scanner.nextInt();
                                    scanner.nextLine();
                                    crudStudent.update(id, updatedStudent);
                                    correctID = true;
                                    System.out.println("Updated student information: " );
                                    System.out.println("Name: " + updatedStudent.getName());
                                    System.out.println("Email: " + updatedStudent.getEmail());
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Student update failed: ID does not exist.");
                                    break;
                                }
                            }
                            break;
                        }
                        else if (entity.getIdentifier().equals("Course")) {
                            System.out.println("Updated classroom:");
                            String classroom = scanner.nextLine();
                            while (!inputFormat.classroomFormat(classroom)) {
                                System.out.println("Enter valid number: ");
                                classroom = scanner.nextLine();
                            }

                            System.out.println("Updated course name:");
                            String subject = scanner.nextLine();
                            while (!inputFormat.nameFormat(subject)) {
                                System.out.println("Enter valid course: ");
                                subject = scanner.nextLine();
                            }

                            System.out.println("Updated teacher:");
                            String teacher = scanner.nextLine();
                            while (!inputFormat.nameFormat(teacher)) {
                                System.out.println("Enter valid name: ");
                                teacher = scanner.nextLine();
                            }

                            System.out.println("Id:");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            Course updatedCourse = new Course(classroom, subject, teacher);
                            boolean correctID = false;
                            while (!correctID) {
                                try {
                                    crudCourse.update(id, updatedCourse);
                                    correctID = true;
                                    System.out.println("Updated course information: ");
                                    System.out.println("Classroom: " + updatedCourse.getClassroom());
                                    System.out.println("Name: " +  updatedCourse.getSubject());
                                    System.out.println("Teacher: " + updatedCourse.getTeacher());
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Course update failed: ID does not exist.");
                                    break;
                                }
                            }
                            break;
                        }
                        else if (entity.getIdentifier().equals("Evaluation")) {
                            System.out.println("Updated student ID:");
                            int studentId;

                            Student student = null;
                            boolean correctStudentID = false;
                            while (!correctStudentID) {
                                try {
                                    studentId = scanner.nextInt();
                                    student = crudStudent.read(studentId);
                                    correctStudentID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Evaluation update failed: ID does not exist.");
                                    break;
                                }
                            }
                            if (!correctStudentID) {
                                break;
                            }

                            System.out.println("Updated Course ID:");
                            int courseId;

                            Course course = null;
                            boolean correctCourseID = false;
                            while (!correctCourseID) {
                                try {
                                    courseId = scanner.nextInt();
                                    scanner.nextLine();
                                    course = crudCourse.read(courseId);
                                    correctCourseID = true;
                                } catch (InputMismatchException e) {
                                    System.out.println("The ID can only have numerical characters.");
                                    System.out.println("Enter a new ID:");
                                    scanner.nextLine();
                                } catch (EntityNotFoundException e) {
                                    System.out.println("Evaluation update failed: ID does not exist.");
                                    break;
                                }
                            }
                            if (!correctCourseID) {
                                break;
                            }

                            System.out.println("Updated evaluation name:");
                            String evalName = scanner.nextLine();
                            while (!inputFormat.nameFormat(evalName)) {
                                System.out.println("Enter valid name: ");
                                evalName = scanner.nextLine();
                            }

                            System.out.println("Select new evaluation's type:");
                            System.out.println("1. Final, 2. Practical Work, 3. Oral Exam, 4. Written Exam");
                            int type = 0;
                            try {
                                type = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Input must only have numerical characters.");
                                System.out.println("Enter a new number:");
                                scanner.nextLine();
                            }

                            Evaluation eval = null;
                            switch (type) {
                                case 1:
                                    eval = new FinalExam("Final", evalName);
                                    break;
                                case 2:
                                    eval = new PracticalWork("Practical Work", evalName);
                                    break;
                                case 3:
                                    eval = new OralExam("Oral Exam", evalName);
                                    break;
                                case 4:
                                    eval = new WrittenExam("Written Exam", evalName);
                                    break;
                                default:
                                    System.out.println("Enter a valid input:");

                            }


                            System.out.println("Evaluation Id:");
                            int evalId = 0;
                            try {
                                evalId = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("The ID can only have numerical characters.");
                                System.out.println("Enter a new ID:");
                                scanner.nextLine();
                            }

                            assert eval != null;
                            eval.setId(evalId);
                            eval.setStudent(student);
                            student.addEvaluation(eval);
                            eval.setCourse(course);
                            course.addEval(eval);

                            try {
                                crudEvaluation.update(evalId, eval);
                                System.out.println("Updated evaluation information: ");
                                System.out.println("Course: " + course.getSubject());
                                System.out.println("Student: " + student.getName());
                                System.out.println("Name : " + eval.getEvaluationName());
                                System.out.println("Type: " + eval.getEvaluationType());
                            } catch (EntityNotFoundException e) {
                                System.out.println("Evaluation update failed: ID does not exist.");
                                break;
                            }
                            break;
                        }
                    case 4:
                        if (entity.getIdentifier().equals("Student")) {
                            System.out.println("Student's ID:");
                            int id;
                            try {
                                id = scanner.nextInt();
                                scanner.nextLine();
                                crudStudent.delete(id);
                                System.out.println("Student deleted successfully.");
                            } catch (InputMismatchException e) {
                                System.out.println("The ID can only have numerical characters.");
                                System.out.println("Enter a new ID:");
                                scanner.nextLine();
                            } catch (EntityNotFoundException e){
                                System.out.println("Invalid student ID: ID does not exist.");
                                break;
                            }
                            break;
                        }
                        else if (entity.getIdentifier().equals("Course")) {
                            System.out.println("Course's ID:");
                            int id;
                            try {
                                id = scanner.nextInt();
                                scanner.nextLine();
                                crudCourse.delete(id);
                                System.out.println("Course deleted successfully.");
                            } catch (InputMismatchException e) {
                                System.out.println("The ID can only have numerical characters.");
                                System.out.println("Enter a new ID:");
                                scanner.nextLine();
                            } catch (EntityNotFoundException e){
                                System.out.println("Invalid course ID: ID does not exist.");
                                break;
                            }
                            break;
                        }
                        else if (entity.getIdentifier().equals("Evaluation")) {
                            System.out.println("Evaluation's ID:");
                            int id;
                            try {
                                id = scanner.nextInt();
                                scanner.nextLine();
                                crudEvaluation.delete(id);
                                System.out.println("Evaluation deleted successfully.");
                            } catch (InputMismatchException e){
                                System.out.println("The ID can only have numerical characters.");
                                System.out.println("Enter a new ID:");
                                scanner.nextLine();
                            } catch (EntityNotFoundException e){
                                System.out.println("Invalid course ID: ID does not exist.");
                                break;
                            }
                            break;
                        }
                }
            }
            else{
                play = false;
            }
        }
    }
}


