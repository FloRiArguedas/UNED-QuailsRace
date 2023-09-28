
package proyecto3_floricela;

import java.io.*;


/**
 *
 * @author Flory
 */
public class Codorniz {
    /*Declaraciones*/
    private String nombre;
    private Integer edad;
    private String especie;
    private Double peso;
    private Integer num_id;
    private String nombre_dueño;
    
    /*Getters y Setters*/

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getEspecie() {
        return especie;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getNum_id() {
        return num_id;
    }

    public String getNombre_dueño() {
        return nombre_dueño;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setNum_id(Integer num_id) {
        this.num_id = num_id;
    }

    public void setNombre_dueño(String nombre_dueño) {
        this.nombre_dueño = nombre_dueño;
    }
/*Constructor*/
    
    public Codorniz(String nombre, Integer edad, String especie, Double peso, Integer num_id, String nombre_dueño) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.peso = peso;
        this.num_id = num_id;
        this.nombre_dueño = nombre_dueño;
    }
    
    
}
