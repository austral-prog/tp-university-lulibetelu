package com.university.cli;

public class InputFormat {
    public boolean nameFormat(String name){
        return name.matches("[a-zA-Z\\s'-]+");
    }
    public boolean emailFormat(String email){
        return email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
    }
    public boolean classroomFormat(String classroom){
        return classroom.matches(classroom);
    }

}
