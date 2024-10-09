import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Marshalling_XML {
    public static void generrarArchivoXML(List<casetaFeria> casetaslist) {

        String xmlFilePath = "casetas.xml";

        casetas casetas = new casetas(casetaslist);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(casetas.class); //Creamos el objeto JAXBContext

            Marshaller marshaller = jaxbContext.createMarshaller(); //Creamos el marshaller

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //Y seteamos sus propiedades

            marshaller.marshal(casetas, new File(xmlFilePath)); //Creo el archivo XML

        } catch (JAXBException e) {
            System.err.println(e + " Ha habido un error al generar las clase casetas");
        }
    }

    public static void unmarshalling(File xmlFile) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(casetas.class); //Creamos el objeto JAXBContext

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller(); //Creamos el marshaller

            casetas casetasFromXml = (casetas) unmarshaller.unmarshal(xmlFile); //Y creamos el objeto casetas para introducir el unmarshall en la lista

            System.out.println("Objeto Casetas despues de deserializarlo");
            System.out.println(casetasFromXml.getCasetasList());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarCasetaX(File xmlFile, int x) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(casetas.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            casetas casetasFromXml = (casetas) unmarshaller.unmarshal(xmlFile);

            System.out.println(casetasFromXml.getCasetasList().stream().filter(casetaFeria -> casetaFeria.getId() == x).findFirst().orElseThrow(IOException::new));
// De la lista de unmarshaller hago un stream -> filter para buscar el id que nos piden y lo muestro
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
