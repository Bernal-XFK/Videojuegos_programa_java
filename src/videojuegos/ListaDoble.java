
package videojuegos;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class ListaDoble {
        NodoUsuario pri, ult;

    public ListaDoble() {
        pri = null;
        ult = null;
    }

    public boolean esVacia() {
        if (pri == null) {
            return true;
        } else {
            return false;
        }
    }
    
 public String generarReportePorPlataforma() {
    StringBuilder reporte = new StringBuilder();

   
    Map<String, Integer> plataformasContador = new HashMap<>();

    NodoUsuario auxUsuario = pri;

    while (auxUsuario != null) {
        NodoAlquilar auxAlquilar = auxUsuario.priAlquilar;

        while (auxAlquilar != null) {
            String plataforma = auxAlquilar.Plataforma;

            
            plataformasContador.put(plataforma, plataformasContador.getOrDefault(plataforma, 0) + 1);

            auxAlquilar = auxAlquilar.sigAlquilar;
        }

        auxUsuario = auxUsuario.sig;
    }

   
    List<Map.Entry<String, Integer>> listaPlataformas = new ArrayList<>(plataformasContador.entrySet());
    listaPlataformas.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

    
    int contador = 0;
    for (Map.Entry<String, Integer> entrada : listaPlataformas) {
        String plataforma = entrada.getKey();
        int cantidad = entrada.getValue();

        reporte.append("Plataforma: ").append(plataforma).append(", Cantidad de Alquileres: ").append(cantidad).append("\n");

        contador++;
        if (contador >= 3) {
            break;
        }
    }

    return reporte.toString();
}
public String generarReportePorMes(int mesSeleccionado) {

        StringBuilder reporte = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
        NodoUsuario auxUsuario = pri;
        double gananciasTotales = 0; 

        while (auxUsuario != null) {
            double gananciasUsuario = 0; 
            boolean clienteConAlquileresEnMes = false;
            reporte.append("\nCliente: ").append(auxUsuario.nombre_usuario).append("\n");
            NodoAlquilar auxAlquilar = auxUsuario.priAlquilar;

            while (auxAlquilar != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(auxAlquilar.fecAlquiler);
                int mesAlquiler = cal.get(Calendar.MONTH);
                int anioAlquiler = cal.get(Calendar.YEAR);

                if (mesAlquiler == mesSeleccionado && anioAlquiler == Year.now().getValue()) {
                    
                    gananciasUsuario += auxAlquilar.Costo;

                    reporte.append("   Juego: ").append(auxAlquilar.juego)
                            .append(", Fecha de Alquiler: ").append(sdf.format(auxAlquilar.fecAlquiler))
                            .append(", Precio: ").append(auxAlquilar.Costo)
                            .append("\n");

                    clienteConAlquileresEnMes = true;
                }

                auxAlquilar = auxAlquilar.sigAlquilar;
            }

            if (!clienteConAlquileresEnMes) {
                int inicioClienteInfo = reporte.lastIndexOf("\nCliente: ");
                int finClienteInfo = reporte.indexOf("\n", inicioClienteInfo + 1);
                if (finClienteInfo != -1) {
                    reporte.delete(inicioClienteInfo, finClienteInfo + 1);
                }
            } else {
                reporte.append("   Ganancias por Separado: ").append(gananciasUsuario).append("\n");
                gananciasTotales += gananciasUsuario;
            }

            auxUsuario = auxUsuario.sig;
        }

        reporte.append("\nGanancias totales: ").append(gananciasTotales).append("\n");

        return reporte.toString();
    }
    
 public void agregarUsuario(NodoUsuario nuevoUsuario) {
        if (pri == null) {
            pri = nuevoUsuario;
        } else {
            NodoUsuario ultimo = pri;
            while (ultimo.sig != null) {
                ultimo = ultimo.sig;
            }
            nuevoUsuario.ant = ultimo;
            ultimo.sig = nuevoUsuario;
        }
    }
    public void insertarCliente(NodoUsuario nue) {
       
        if (esVacia()) {
            pri = nue;
            ult = nue;
        } else {
            NodoUsuario aux = pri;
            while (aux != null && nue.nombre_usuario.compareTo(aux.nombre_usuario)>0) {
                aux = aux.sig;
            }
            if (aux == pri) {
                nue.sig = pri;
                pri.ant = nue;
                pri = nue;
            } else {
                if (aux == null) {
                    nue.ant = ult;
                    ult.sig = nue;
                    ult = nue;
                } else {
                    nue.sig = aux;
                    nue.ant = aux.ant;
                    aux.ant.sig = nue;
                    aux.ant = nue;
                }
            }
        }
    }

    public boolean eliminar(int v) {
        NodoUsuario aux = pri;
        while (aux != null && aux.id != v) {
            aux = aux.sig;
        }
        if (aux == null) {
            return false;
        } else {
            if (aux.priAlquilar!=null) return false;
            if (aux == pri && aux == ult) {
                pri = null;
                ult = null;
            } else if (aux == pri) {
                pri = pri.sig;
                pri.ant = null;
                aux.sig = null;
            } else if (aux == ult) {
                ult = ult.ant;
                aux.ant = null;
                ult.sig = null;
            } else {
                aux.ant.sig = aux.sig;
                aux.sig.ant = aux.ant;
                aux.sig = null;
                aux.ant = null;
            }

        }

        return true;
    }

    public String listar() {
        String cad="";
        NodoUsuario aux = pri;
        while (aux != null) {
            cad+=aux.toString();
            aux = aux.sig;
        }
        return cad;
    }
    
    public boolean insertarDeuda(int xid, NodoAlquilar nue){
        NodoUsuario aux = pri;
        while (aux!=null && aux.id!=xid){
            aux=aux.sig;
        }
        if (aux==null) return false;
        else{
            NodoAlquilar aux1 = aux.priAlquilar;
            if (aux1==null) aux.priAlquilar=nue;
            else{
                while(aux1.sigAlquilar!=null) aux1=aux1.sigAlquilar;
                aux1.sigAlquilar=nue;
            }
            
        }
        return true;
    }
    
    
public NodoUsuario buscarCliente(int cedula) {
    NodoUsuario actual = pri; 

    while (actual != null) {
        if (actual.id == cedula) {
            return actual; 
        }
        actual = actual.sig;
    }

    return null; 
}
}
