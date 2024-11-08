package com.university.cli;

import com.university.cli.entities.CrudCourse;
import com.university.cli.entities.CrudEvaluation;
import com.university.cli.entities.CrudStudent;

public class Main {
    public static void main(String[] args){
        CrudStudent crudStudent = new CrudStudent();
        CrudCourse crudCourse = new CrudCourse();
        CrudEvaluation crudEvaluation = new CrudEvaluation();
        CRUDRepository<?>[] crudInterfaces = {crudStudent, crudCourse, crudEvaluation};
        CliRunner cliRunner = new CliRunner();
        cliRunner.runCLI(crudInterfaces);
    }
}
