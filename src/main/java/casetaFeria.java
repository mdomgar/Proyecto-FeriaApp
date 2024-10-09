import javax.xml.bind.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "casetaferia")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "nombre", "titular", "aforo", "tipoCaseta"})
public class casetaFeria {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "titular")
    private String titular;

    @XmlElement(name = "aforo")
    private int aforo;

    @XmlElement(name = "tipoCaseta")
    private String tipoCaseta;

    @XmlTransient
    private static int aux = 1;

    public casetaFeria() {
    }

    public casetaFeria(String nombre, String titular, int aforo, String tipoCaseta) {
        this.id = aux;
        this.nombre = nombre;
        this.titular = titular;
        this.aforo = aforo;
        this.tipoCaseta = tipoCaseta;
        aux++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getTipoCaseta() {
        return tipoCaseta;
    }

    public void setTipoCaseta(String tipoCaseta) {
        this.tipoCaseta = tipoCaseta;
    }

    @Override
    public String toString() {
        return "casetaFeria{" + id +
                ", " + nombre +
                ", " + titular +
                ", " + aforo +
                ", " + tipoCaseta +
                '}';
    }

    public static List<casetaFeria> importarCasetas(String entrada) {
        try (FileReader fr = new FileReader(entrada);
             BufferedReader br = new BufferedReader(fr)) { //Declaramos para poder leer las lineas

            String linea = "";
            List<casetaFeria> casetasList = new ArrayList<>();

            while ((linea = br.readLine()) != null) { //Un while para que lea hasta el final
                String[] objeto = linea.split(" - "); //Que splitee cada vez que encuentres espacio-espacio
                casetaFeria caseta = new casetaFeria(objeto[0], objeto[1], Integer.parseInt(objeto[2]), objeto[3]);
                casetasList.add(caseta); // Y lo introduce al array una vez creado el objeto
            }
            return casetasList;
        } catch (IOException e) {
            System.err.println("No se ha podido importar el archivo");
            return null;
        }
    }
}

