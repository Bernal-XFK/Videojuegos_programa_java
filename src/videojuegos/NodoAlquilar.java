
package videojuegos;


import java.util.Date;




public class NodoAlquilar {
    int id;
    int Costo;
    String juego;
    String Plataforma;
    String CodigoJuego;
    Date fecAlquiler;
    Date fecDevuelto = null;
    String Categoria;
    String nombreJuego;
    public boolean Multas;
   

    NodoAlquilar sigAlquilar;

    public NodoAlquilar(int id, int Costo, String juego, String Plataforma, String CodigoJuego, Date fecAlquiler, Date fecDevuelto, String Categoria, String nombreJuego, Boolean Multas) {
        this.id = id;
        this.Costo = Costo;
        this.juego = juego;
        this.Plataforma = Plataforma;
        this.CodigoJuego = CodigoJuego;
        this.fecAlquiler = new Date();
        this.Categoria = "";
        this.nombreJuego = juego;
        this.Multas = Multas;
        

        this.fecDevuelto = null;
        this.sigAlquilar = null;
    }

    

    public String getNombreJuego() {
        return nombreJuego;
    }
    public String getCategoria() {
        return Categoria;
    }
    public String getPlataforma() {
        return Plataforma;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    
    public int getCosto() {
        return Costo;
    }

    public boolean tieneMultas() {
        return Multas;
    }

    public void agregarMulta() {
        Multas = true;
    }

    public void quitarMulta() {
        Multas = false;
    }
    
     @Override
    public String toString() {
        return  "\nNombre Juego: " + nombreJuego +  "\nCosto: " + Costo  + "\n";
    }

}