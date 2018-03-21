
import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static Scanner scanner;

	public static void main(String[] args) throws IOException {
        String nombreSalida = "";
        String nombreArchivo = "";
        Menu menu = new Menu();
        if (args.length == 4) {
            if (args[0].equalsIgnoreCase("-i") || args[0].equalsIgnoreCase("-o")) {
                if (args[1].contains(".csv")) {
                    if (args[2].equalsIgnoreCase("-o") || args[0].equalsIgnoreCase("-i")) {
                        if (args[3].contains(".csv")) {
                            nombreArchivo = args[1];
                            nombreSalida = args[3];
                           menu.generarArchivo(nombreArchivo, nombreSalida);
                           }
                    }
                }
            } else {
                System.out.println("Error en el comando que ingresaste");
                return;
            }
        }else if(args.length==2){
        	if (args[0].equalsIgnoreCase("-i") || args[0].equalsIgnoreCase("-o")) {
                if (args[1].contains(".csv")) {
                	nombreArchivo = args[1];
                	int validar=0;
                	scanner = new Scanner(System.in); 
                do {
                	System.out.println("Seleccione lo que desea hacer:\n"
                			+ "1) Listar asegurados\n"
                			+ "2) Buscar asegurado"
                			+ "0) Salir\n");
                	validar=scanner.nextInt();
                	if(validar==1) {
                		menu.listar(nombreArchivo);
                	}                	
                }while(validar!=0);
                }
                }
        }
        if (nombreArchivo.isEmpty()) {
            System.out.println("Error: nombre de archivo no dado.");
            return;
        }
    }
}

