import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "casetas")
public class casetas {

    private List<casetaFeria> casetasList;

    public casetas() {
    }

    public casetas(List<casetaFeria> casetasList) {
        this.casetasList = casetasList;
    }

    @XmlElement(name = "caseta")
    public List<casetaFeria> getCasetasList() {
        return casetasList;
    }

    public void setCasetasList(List<casetaFeria> casetasList) {
        this.casetasList = casetasList;
    }

    @Override
    public String toString() {
        return "casetas{" +
                "casetasList=" + casetasList +
                '}';
    }
}
