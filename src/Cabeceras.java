import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Cabeceras {
    //Definicion de enumerado
    private static enum CabecerasArchivoCSV {
        nombre, apellido_paterno, apellido_materno, fecha_nacimiento, fecha_ingreso_imss, subdelegacion_imss, consecutivo_inscripcion_imss, nss, tarjeta_credito
    }

    public static List<Asegurado> parsear(Path ubicacionArchivo) throws IOException {

        List<Asegurado> objeto = new ArrayList<>();
        Reader lectorArchivo = new FileReader(ubicacionArchivo.toString());
        Iterable<CSVRecord> registros = CSVFormat.RFC4180
                .withFirstRecordAsHeader()
                .withHeader(CabecerasArchivoCSV.class)
                .parse(lectorArchivo);
        for (CSVRecord registro : registros) {
            //manejando atributo nombre del asegurado
            String nombre = registro.get("nombre");
            //manejando atributo apellido paterno del asegurado
            String apellidoP = registro.get("apellido_paterno");
            //manejando atributo apellido materno del asegurado
            String apellidoM = registro.get("apellido_materno");
            //manejando atributo fecha nacimiento del asegurado
            String fechaN = registro.get("fecha_nacimiento");
            //manejando atributo fecha ingreso del asegurado
            String fechaI = registro.get("fecha_ingreso_imss");
            //manejando atributo subdelegacion imss del asegurado
            int subdelegacionIMSS = Integer.parseInt(registro.get("subdelegacion_imss"));
            //manejando atributo consecutivo_inscripcion del asegurado
            int nConsecutivo = Integer.parseInt(registro.get("consecutivo_inscripcion_imss"));
            //manejando atributo nss del asegurado
            String nss = "";
            String aux = subdelegacionIMSS +
                    fechaI.substring((fechaI.length() - 2), (fechaI.length())) +
                    fechaN.substring((fechaN.length() - 2), (fechaN.length())) +
                    nConsecutivo;
            aux += multiplicacion(aux);
            nss = aux;
            //manejando atributo tarjeta de credito del asegurado
            String cC = verificador(registro.get("tarjeta_credito"));
            //crear el objeto Asegurado y agregarlo a la lista
            Asegurado asegurado = new Asegurado(nombre, apellidoP, apellidoM, fechaN, fechaI, subdelegacionIMSS, nConsecutivo, nss, cC);
            objeto.add(asegurado);
        }
        return objeto;
    }

    public static String verificador(String s) {
        String valor = s;
        String card = s.replaceAll("[^0-9]+", "");
        s = card;
        int suma = 0;
        if (card.length() == 16) {
            for (int i = 0; i < s.length(); i++) {
                int b = Integer.parseInt(s.charAt(i) + "");
                if (i % 2 == 0) {
                    int a = 2 * Integer.parseInt(s.charAt(i) + "");
                    if (a > 9) {
                        String c = a + "";
                        a = Integer.parseInt(c.charAt(0) + "");
                        a += Integer.parseInt(c.charAt(1) + "");
                        suma += a;
                    } else
                        suma += a;
                } else {
                    suma += b;
                }
            }
        } else return "N/V";
        if (suma % 10 == 0) {
            return valor;
        } else
            return "N/V";
    }

    public static int multiplicacion(String s) {
        int suma = 0;
        for (int i = 0; i < s.length(); i++) {
            int b = Integer.parseInt(s.charAt(i) + "");
            if (i % 2 == 0) {
                suma += b;
            } else {
                int a = 2 * Integer.parseInt(s.charAt(i) + "");
                if (a > 9) {
                    String c = a + "";
                    a = Integer.parseInt(c.charAt(0) + "");
                    a += Integer.parseInt(c.charAt(1) + "");
                    suma += a;
                } else
                    suma += a;
            }
        }
        String aux = suma + "";
        int suma2 = (Integer.parseInt(aux.charAt(0) + "") + 1) * 10;
        return suma2 - suma;
    }
}
