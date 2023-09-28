
package proyecto3_floricela;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author Flory
 */
public class Carrera {

    /*Declaraciones*/
    String ID_carrera;
    String fecha;
    String hora;
    String competidor1;
    String competidor2;
    String competidor3;
    String competidor4;
    String competidor5;
    String tiempoCo1;
    String tiempoCo2;
    String tiempoCo3;
    String tiempoCo4;
    String tiempoCo5;

    /*Método Constructor*/
    public Carrera(String ID_carrera, String fecha, String hora, String competidor1, String tiempoCo1, String competidor2, String tiempoCo2, String competidor3, String tiempoCo3, String competidor4, String tiempoCo4, String competidor5, String tiempoCo5) {
        this.ID_carrera = ID_carrera;
        this.fecha = fecha;
        this.hora = hora;
        this.competidor1 = competidor1;
        this.tiempoCo1 = tiempoCo1;
        this.competidor2 = competidor2;
        this.tiempoCo2 = tiempoCo2;
        this.competidor3 = competidor3;
        this.tiempoCo3 = tiempoCo3;
        this.competidor4 = competidor4;
        this.tiempoCo4 = tiempoCo4;
        this.competidor5 = competidor5;
        this.tiempoCo5 = tiempoCo5;

    }

    /*Getters*/
    public String getID_carrera() {
        return ID_carrera;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getCompetidor1() {
        return competidor1;
    }

    public String getCompetidor2() {
        return competidor2;
    }

    public String getCompetidor3() {
        return competidor3;
    }

    public String getCompetidor4() {
        return competidor4;
    }

    public String getCompetidor5() {
        return competidor5;
    }

    public String getTiempoCo1() {
        return tiempoCo1;
    }

    public String getTiempoCo2() {
        return tiempoCo2;
    }

    public String getTiempoCo3() {
        return tiempoCo3;
    }

    public String getTiempoCo4() {
        return tiempoCo4;
    }

    public String getTiempoCo5() {
        return tiempoCo5;
    }

    /*Setters*/

    public void setID_carrera(String ID_carrera) {
        this.ID_carrera = ID_carrera;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCompetidor1(String competidor1) {
        this.competidor1 = competidor1;
    }

    public void setCompetidor2(String competidor2) {
        this.competidor2 = competidor2;
    }

    public void setCompetidor3(String competidor3) {
        this.competidor3 = competidor3;
    }

    public void setCompetidor4(String competidor4) {
        this.competidor4 = competidor4;
    }

    public void setCompetidor5(String competidor5) {
        this.competidor5 = competidor5;
    }

    public void setTiempoCo1(String tiempoCo1) {
        this.tiempoCo1 = tiempoCo1;
    }

    public void setTiempoCo2(String tiempoCo2) {
        this.tiempoCo2 = tiempoCo2;
    }

    public void setTiempoCo3(String tiempoCo3) {
        this.tiempoCo3 = tiempoCo3;
    }

    public void setTiempoCo4(String tiempoCo4) {
        this.tiempoCo4 = tiempoCo4;
    }

    public void setTiempoCo5(String tiempoCo5) {
        this.tiempoCo5 = tiempoCo5;
    }

}
