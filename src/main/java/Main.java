import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "casetas.txt";
        List<casetaFeria> casetaslist;
        int opcion;

        casetaslist = casetaFeria.importarCasetas(ruta); //Importo los objetos

// Declaro mi menu con sus multiples opciones
        do {
            System.out.println("Escoje una de las opciones. \n1.Marshalling casetas a XML \n2.Unmarshalling casetas de XML \n3.Mostrar la caseta número X \n4.Marshalling casetas a JSON \n5.Unmarshalling casetas de JSON \n6.Mostrar la caseta número X desde JSON \n7.Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        Marshalling_XML.generrarArchivoXML(casetaslist);
                    } catch (Exception e) {
                        System.err.println("No se ha podido importar el archivo casetas");
                    }

                    break;

                case 2:
                    try {
                        Marshalling_XML.unmarshalling(new File("casetas.xml"));
                    } catch (Exception e) {
                        System.err.println("No se ha podido importar el archivo xml");
                    }
                    break;
                case 3:
                    try {
                        int x = 0;
                        System.out.println("Introduce el número de la caseta que quieres mostrar");
                        x = sc.nextInt();
                        Marshalling_XML.mostrarCasetaX(new File("casetas.xml"), x);
                        break;
                    } catch (Exception e) {
                        System.err.println("ID no existente o archivo no valido");
                    }
                case 4:
                    try {
                        Marshalling_JSON.MarshallingJson(casetaslist);
                    } catch (Exception e) {
                        System.err.println(e + " No se ha podido importar las casetas");
                    }
                    break;
                case 5:
                    try {
                        Marshalling_JSON.UnmarshallingJson("casetas.json");
                    } catch (Exception e) {
                        System.err.println(e + "Error al introducir el archivo Json");
                        break;
                    }
                case 6:
                    try {
                        int x = 0;
                        System.out.println("Introduce el número de la caseta que quieres mostrar");
                        x = sc.nextInt();
                        Marshalling_JSON.mostrarCasetaX("casetas.json", x);
                    } catch (Exception e) {
                        System.err.println("ID no existente o archivo no valido");
                    }
                    break;
            }
        } while (opcion != 7);
    }
}
