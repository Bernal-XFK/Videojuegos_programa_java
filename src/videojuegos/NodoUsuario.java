package videojuegos;


import java.util.Date;

public class NodoUsuario {

    String nombre_usuario;
    int id;
    String telefono;
    String direccion;
    Date fecha_Inscripcion;
   
    NodoUsuario sig;
    NodoUsuario ant;
    NodoAlquilar priAlquilar;
   

    public NodoUsuario(String nombre_usuario, int id, String telefono, String direccion, Date fecha_Inscripcion) {
        this.nombre_usuario = nombre_usuario;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_Inscripcion = fecha_Inscripcion;
        
        this.sig = null;
        this.ant = null;
        this.priAlquilar = null;

    }

   
public void agregarJuegoAlquilado(String nombreJuego, int id, int costo, String plataforma, String codigoJuego, Date fecAlquiler, Date fecDevuelto, String categoria, boolean multas) {
    NodoAlquilar nuevoJuego = new NodoAlquilar(id, costo, nombreJuego, plataforma, codigoJuego, fecAlquiler, fecDevuelto, categoria, nombreJuego, multas);

    if (priAlquilar == null) {
        priAlquilar = nuevoJuego;
    } else {
        NodoAlquilar ultimo = priAlquilar;
        while (ultimo.sigAlquilar != null) {
            ultimo = ultimo.sigAlquilar;
        }
        ultimo.sigAlquilar = nuevoJuego;
    }
}
    

 
    
@Override
    public String toString() {
        String cad = "\nCLIENTE: " + nombre_usuario + " \nCEDULA: " + id + " \nTELEFONO: " + telefono + " \nDIRECCION: " + direccion + " \nFECHA INSCRIPCION: " + fecha_Inscripcion + "\n";

        NodoAlquilar aux = priAlquilar;

        boolean tieneMultas = false; 

        while (aux != null) {
           
            cad += aux.toString();

            if (aux.tieneMultas()) {
                tieneMultas = true;
            }

            aux = aux.sigAlquilar;
        }

        if (tieneMultas) {
            cad += "\n (El Usuario Está Multado) ";
        } else {
            cad += "\n (El usuario No Tiene Multas) ";
        }

        cad += "\n======================================================";

        return cad;
    }
}
