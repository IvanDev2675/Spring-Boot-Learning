package com.CRUDALUMNOS.CRUDALUMNOS.controllers;

import com.CRUDALUMNOS.CRUDALUMNOS.domain.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/alumno")
public class AlumnoControllers {

    private List<Alumno> alumnos = new ArrayList(Arrays.asList(
            new Alumno(1,"Ivan","Ivan@gmail.com","22","Ingenieria de Software"),
            new Alumno(2,"Jaimer","jaimer@gmail.com","23","Matematicas"),
            new Alumno(3,"Nicolas","Nisosa@hotmail.com","25","Fuerzas militares"),
            new Alumno(4,"Carolina","Caro@outlook.com","42","Comerciante")

    ));

    @GetMapping
    public List<Alumno> getAlumno() {
        return alumnos;

        }

@GetMapping("/{id}")
      public Alumno getAlumnoById(@PathVariable int id){
        for(Alumno c : alumnos){
             if(c.getID()==id){
                 return c;
             }
        }

               return null;
      }

    /**
     *Crea un nuevo alumno en el sistema
     * @param newAlumno
     * @return el nuevo alumno agregado a la lista
     */
       @PostMapping
      public Alumno agregarAlumno(@RequestBody Alumno newAlumno) {
if(newAlumno.getNombre()==null || newAlumno.getEmail()==null || newAlumno.getEdad()==null || newAlumno.getCurso()==null){
    return null;
}
int newid = newAlumno.getID();
if(newid == 0 ) {
    newid = alumnos.size() + 1;
    newAlumno.setID(newid);
}
alumnos.add(newAlumno);
         return newAlumno;


       }

    /**
     * Actualiza todos los datos de un alumno existente
     * @param newAlumno Datos actualizados del alumno
     * @return  El alumno actualizado o null si no existe
     */
    @PutMapping
public Alumno putAlumno(@RequestBody Alumno newAlumno) {
        for(Alumno c : alumnos){
            if(c.getID()==newAlumno.getID()) {

                c.setNombre(newAlumno.getNombre());
                c.setEmail(newAlumno.getEmail());
                c.setEdad(newAlumno.getEdad());
                c.setCurso(newAlumno.getCurso());
                return c;
            }
        }
        return null;
}

    /**
     * Elimina un alumno por su ID
     * @param id ID del alumno a eliminar
     * @return El alumno eliminado o null si no existe
     */
    @DeleteMapping("/{id}")
public Alumno deleteAlumno(@PathVariable int id) {
         for(Alumno c : alumnos){
             if(c.getID()==id) {
                 alumnos.remove(c);
                 return c;
             }
         }
return null;
}
    /**
     * Actualiza parcialmente los datos de un alumno
     * @param newAlumno Datos a actualizar (solo campos no nulos)
     * @return El alumno actualizado o null si no existe
     */
@PatchMapping
public Alumno patchAlumno(@RequestBody Alumno newAlumno) {
        for(Alumno c : alumnos){

            if(c.getID()==newAlumno.getID()) {

                if(newAlumno.getNombre() != null ){
                    c.setNombre(newAlumno.getNombre());
                }
                    if(newAlumno.getEmail() != null ){
                        c.setEmail(newAlumno.getEmail());
                    }
                        if(newAlumno.getEdad() != null ){
                            c.setEdad(newAlumno.getEdad());
                        }

                        if(newAlumno.getCurso() != null ){
                            c.setCurso(newAlumno.getCurso());
                        }
return c;
            }
        }
return null;
}



    }







