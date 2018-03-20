public class Asegurado {
    String nombre, apellidoP, apellidoM, fechaNac, fechaIng, tarjetaCredito, nss;
    int subdelegacion, nConsecutivo;


    public Asegurado(String nombre, String apellidoP, String apellidoM, String fechaNac, String fechaIng, int subdelegacion, int nConsecutivo, String nss, String tarjetaCredito) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.fechaNac = fechaNac;
        this.apellidoM = apellidoM;
        this.fechaIng = fechaIng;
        this.subdelegacion = subdelegacion;
        this.nConsecutivo = nConsecutivo;
        this.nss = nss;
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(String fechaIng) {
        this.fechaIng = fechaIng;
    }

    public int getSubdelegacion() {
        return subdelegacion;
    }

    public void setSubdelegacion(int subdelegacion) {
        this.subdelegacion = subdelegacion;
    }

    public int getnConsecutivo() {
        return nConsecutivo;
    }

    public void setnConsecutivo(int nConsecutivo) {
        this.nConsecutivo = nConsecutivo;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
}
