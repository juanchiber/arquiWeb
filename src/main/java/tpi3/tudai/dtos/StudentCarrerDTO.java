package tpi3.tudai.dtos;

import lombok.Getter;
import lombok.Setter;
import tpi3.tudai.entities.StudentCarrer;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class StudentCarrerDTO {
    private Integer id_Estudiante;
    private Integer id_Carrera;


    public StudentCarrerDTO(){

    }
    public StudentCarrerDTO(Integer id_Estudiante, Integer id_carrera){
       this.id_Estudiante=id_Estudiante;
       this.id_Carrera=id_carrera;
    }

    public StudentCarrerDTO(StudentCarrer sc){
      this.id_Carrera= sc.getCarrera().getId();
      this.id_Estudiante=sc.getEstudiante().getId();
    }

}
