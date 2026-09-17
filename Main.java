import java.util.Stack;
import java.util.Scanner;

public class NavegadorWeb {
    private Stack<String> pilaAtras;
    private Stack<String> pilaAdelante;
    private String paginaActual;

    public NavegadorWeb() {
        pilaAtras = new Stack<>();
        pilaAdelante = new Stack<>();
        paginaActual = "Acerca de : Blanco";    
    }

    public void visitarPagina(String url){
        pilaAtras.push(paginaActual);
        paginaActual = url;
        pilaAdelante.clear();
    }
    public void irAtras(){
        if(!pilaAtras.isEmpty()){
            pilaAdelante.push(paginaActual);
            paginaActual = pilaAtras.pop();
        } else {
            System.out.println("No hay páginas atrás.");
        }
    }
    public void irAdelante(){
        if (!pilaAdelante.isEmpty()){
            pilaAtras.push(paginaActual);
            paginaActual = pilaAdelante.pop();
        } else {
            System.out.println("No hay páginas adelante.");
        }
    }
    public void mostrarPaginaActual(){
        System.out.println("Página actual: " + paginaActual);

    }

    public static void main (String[] args){
        NavegadorWeb navegador = new NavegadorWeb();
        Scanner scanner = new Scanner(System.in);
        String url;

        while(true){
            System.out.println("1. Visitar página");
            System.out.println("2. Ir atrás");
            System.out.println("3. Ir adelante");
            System.out.println("4. Mostrar página actual");
            System.out.println("5. Salir");
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
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
