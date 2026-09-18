/**
Diego Alberto Cervantes Funes
00594828
17/09/2026
**/
import java.util.Stack;
import java.util.Scanner;

/**
 * Clase que simula el funcionamiento básico del historial de un navegador web.
 * Utiliza dos pilas para gestionar las páginas anteriores y siguientes.
 */
public class NavegadorWeb {
    // Atributos de la clase
    private Stack<String> pilaAtras;
    private Stack<String> pilaAdelante;
    private String paginaActual;

    /**
     * Constructor de la clase.
     * Inicializa las pilas y establece una página de inicio por defecto.
     */
    public NavegadorWeb() {
        pilaAtras = new Stack<>();
        pilaAdelante = new Stack<>();
        paginaActual = "Acerca de : Blanco";    
    }

    /**
     * Visita una nueva URL.
     * Guarda la página actual en la pila de atrás y borra el historial de adelante.
     *  La dirección web que se desea visitar.
     */
    public void visitarPagina(String url){
        pilaAtras.push(paginaActual);
        paginaActual = url;
        pilaAdelante.clear(); // Al visitar una web nueva, se pierde el historial "hacia adelante"
    }

    /**
     * Navega a la página anterior en el historial.
     * Guarda la página actual en la pila "adelante" antes de retroceder.
     */
    public void irAtras(){
        if(!pilaAtras.isEmpty()){
            pilaAdelante.push(paginaActual);
            paginaActual = pilaAtras.pop();
        } else {
            System.out.println("No hay páginas atrás.");
        }
    }

    /**
     * Navega a la página siguiente en el historial.
     * Guarda la página actual en la pila "atrás" antes de avanzar.
     */
    public void irAdelante(){
        if (!pilaAdelante.isEmpty()){
            pilaAtras.push(paginaActual);
            paginaActual = pilaAdelante.pop();
        } else {
            System.out.println("No hay páginas adelante.");
        }
    }

    /**
     * Muestra en consola la URL en la que se encuentra posicionado el navegador.
     */
    public void mostrarPaginaActual(){
        System.out.println("Página actual: " + paginaActual);
    }

    /**
     * Método principal que ejecuta el menú interactivo para el usuario.
     */
    public static void main (String[] args){
        NavegadorWeb navegador = new NavegadorWeb();
        Scanner scanner = new Scanner(System.in);
        String url;

        while(true){
            System.out.println("\n--- MENÚ DEL NAVEGADOR ---");
            System.out.println("1. Visitar página");
            System.out.println("2. Ir atrás");
            System.out.println("3. Ir adelante");
            System.out.println("4. Mostrar página actual");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcion){
                case 1:
                    System.out.println("Ingrese la URL de la página que desea visitar:");
                    url = scanner.nextLine();
                    navegador.visitarPagina(url);
                    break;
                case 2:
                    navegador.irAtras();
                    break;
                case 3:
                    navegador.irAdelante();
                    break;
                case 4:
                    navegador.mostrarPaginaActual();
                    break;
                case 5:
                    System.out.println("Saliendo del navegador...");
                    scanner.close(); 
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
