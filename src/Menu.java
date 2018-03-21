import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Menu {
	public Menu() {
	}
	
	public void listar(String nombreArchivo) {
		 Path ubicacionArchivo = Paths.get(nombreArchivo);
         boolean existeArchivo = Files.exists(ubicacionArchivo);

         if (!existeArchivo) {
             System.out.println("Error: el archivo no existe.");
             return;
         }

         List<Asegurado> Asegurados;
         try {
             Asegurados = Cabeceras.parsear(ubicacionArchivo);
         } catch (IOException e) {
             System.out.println("Error: el archivo no ha podido ser leido con exito.");
             return;
         }
         
         for (Asegurado asegurado : Asegurados) {
             System.out.println(asegurado.toString());
         }
	}
	public void generarArchivo(String nombreArchivo, String nombreSalida) throws IOException {
		 Path ubicacionArchivo = Paths.get(nombreArchivo);
         boolean existeArchivo = Files.exists(ubicacionArchivo);

         if (!existeArchivo) {
             System.out.println("Error: el archivo no existe.");
             return;
         }

         List<Asegurado> Asegurados;
         try {
             Asegurados = Cabeceras.parsear(ubicacionArchivo);
         } catch (IOException e) {
             System.out.println("Error: el archivo no ha podido ser leido con exito.");
             return;
         }
         BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(nombreSalida));
         CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.RFC4180.withDelimiter('|').withHeader("nombre",
                 "apellido_paterno", "apellido_materno", "fecha_nacimiento", "fecha_ingreso_imss"
                 , "subdelegacion_imss", "consecutivo_inscripcion_imms", "nss", "tarjeta_credito"));
         for (Asegurado asegurado : Asegurados) {
             csvPrinter.printRecord(asegurado.getNombre(), asegurado.getApellidoP(), asegurado.getApellidoM(),
                     asegurado.getFechaNac(), asegurado.getFechaIng(), asegurado.getSubdelegacion(),
                     asegurado.getnConsecutivo(), asegurado.getNss(), asegurado.getTarjetaCredito());
         }
         csvPrinter.flush();
         csvPrinter.close();
		
	}

}
