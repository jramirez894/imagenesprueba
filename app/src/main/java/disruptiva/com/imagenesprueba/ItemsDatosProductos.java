package disruptiva.com.imagenesprueba;

/**
 * Created by jeniffer on 29/02/2016.
 */
public class ItemsDatosProductos
{
    Integer imagen;
    String nombreP;
    String tiempo;
    String precio;
    String descripcion;

    public ItemsDatosProductos(Integer imagen, String nombreP, String tiempo, String precio, String descripcion) {
        this.imagen = imagen;
        this.nombreP = nombreP;
        this.tiempo = tiempo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
