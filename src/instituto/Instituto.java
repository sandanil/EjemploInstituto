/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.util.ArrayList;

/**
 *
 * @author DaniL
 */
public class Instituto {
    public static ArrayList<Persona> personas = new ArrayList<Persona>();
    
    public static void rellenarDatos(){
        for (int i=0; i < 100; i++){
            Alumno a = new Alumno();
            a.setNombre("Alumno "+(i+1));
            a.setEdad((int) (Math.random()*15));
            personas.add(a);
        }
        for (int i=0; i < 10; i++){
            Profesor p = new Profesor();
            p.setNombre("Profesor "+(i+1));
            p.setEdad((int) (Math.random()*65));
            p.setEspecialidad("Especialidad: "+(i+1));
            personas.add(p);
        }
        for (int i=0; i < 5; i++){
            Interino in = new Interino();
            in.setNombre("Profesor Interino "+(i+1));
            in.setEdad((int) (Math.random()*30));
            in.setEspecialidad("Especialidad Prof. Int. "+(i+1));
            in.setPuntos((int) (Math.random()*10));
            personas.add(in);
        }
    }
//----------------------------------------------------------------------------------------------------    
    public static void mostrarProfesorMasViejo(){
        Persona viejo = personas.get(0);
        for (int i=0; i < personas.size(); i++){
            if(personas.get(i).getEdad() > viejo.getEdad() && personas.get(i) instanceof Profesor) {
                viejo = personas.get(i);
            }
        }
        System.out.println("El profesor de mayor edad es: "+viejo.getNombre());
    }
//----------------------------------------------------------------------------------------------------    
    public static void cambiarEspecialidad(Profesor p, String nuevaesp){
        p.setEspecialidad(nuevaesp);
        System.out.println("Especialidad del profesor "+p.getNombre()+" cambiada correctamente a: "+nuevaesp);
    }
//----------------------------------------------------------------------------------------------------    
    public static void mostrarAlumnoMasJoven(){
        Persona joven = personas.get(0);
        for (int i=0; i < personas.size(); i++){
            if(personas.get(i).getEdad() < joven.getEdad() && personas.get(i) instanceof Alumno){
                joven = personas.get(i);
            }
        }
        System.out.println("El alumno de menor edad es: "+joven.getNombre());
    }
//----------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------    
    public static void main(String[] args) {
        rellenarDatos();
        mostrarProfesorMasViejo();
        mostrarAlumnoMasJoven();
        int n = 111;
        String esp = "Matemáticas";
        if (personas.get(n) instanceof Profesor){
            Profesor p = (Profesor) personas.get(n);
            cambiarEspecialidad(p, esp);
        }
        else {
            System.out.println("Los alumnos no pueden cambiar de especialidad lokoh.");
        }
    }
}
