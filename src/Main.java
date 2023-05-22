/*
Implementa un programa que recoja de teclado una URL (con el formato http://www.sitioweb.dom)
y abra una conexión a dicho sitio Web, mostrando por pantalla el código HTML de su página inicial.
 */


import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://algunconsejo.foroactivo.com");
        URLConnection connection = url.openConnection();

        probandoMetodos(connection);
    }

    private static void probandoMetodos(URLConnection a) {

        System.out.println("-----------------------------------------");
        System.out.println("URL : " + a.getURL());
        System.out.println("Tipo de contenido : " + a.getContentType());

        Date ultimaModificacion = new Date(a.getLastModified());
        System.out.println("Ultima modificacion : " + ultimaModificacion);

        //Cabeceras
        Map camposcabecera = a.getHeaderFields();
        Iterator it = camposcabecera.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        System.out.println("Campo 1 de cabecera: " + a.getHeaderField(1));
        System.out.println("Campo 3 de cabecera: " + a.getHeaderField(3));
        System.out.println("-----------------------------------------");

    }
}