
import com.itextpdf.text.Chunk;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valenthina
 */
public class Archivos extends Modelo{
    
    static public Archivos ob=new Archivos();    
    
    
    public Archivos() {
        super();
    }
    
    
    void crearUsuario() {
        String cadena;
        cadena = ob.getNombre()+"/"+ob.getDoc()+"/"+ob.getEmail()+"/";
        FileWriter fichero = null;
        PrintWriter linea = null;

        try {
            fichero = new FileWriter("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\usuarios.txt", true);
            linea = new PrintWriter(fichero);

            linea.println(cadena);

        } catch (IOException e) {
            System.out.print("Error creando archivo");
        } finally {
            JOptionPane.showMessageDialog(null," Ha sido agregado");
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }
    }
    void identificar() {
        String cadena;
        cadena = ob.getBocas()+"/"+ob.getCabello()+"/"+ob.getCara()+"/"+ob.getNariz()+"/"+ob.getOjos()+"/"+ob.getDoc()+"/";
        FileWriter fichero = null;
        PrintWriter linea = null;

        try {
            fichero = new FileWriter("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\identificar.txt", true);
            linea = new PrintWriter(fichero);

            linea.println(cadena);

        } catch (IOException e) {
            System.out.print("Error creando archivo");
        } finally {
            
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }
    }
    void crearAdmin() {
        String cadena;
        cadena = ob.getUser()+"/"+ob.getContra()+"/";
        FileWriter fichero = null;
        PrintWriter linea = null;

        try {
            fichero = new FileWriter("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\administradores.txt", true);
            linea = new PrintWriter(fichero);

            linea.println(cadena);

        } catch (IOException e) {
            System.out.print("Error creando archivo");
        } finally {
            JOptionPane.showMessageDialog(null," Ha sido agregado");
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }
    }
    boolean buscar(String filtro, String direc) {
        boolean encontro = false;
        
        java.io.File archivo = null;
        FileReader contenido = null;
        BufferedReader linea = null;

        try {
            archivo = new java.io.File(direc);
            contenido = new FileReader(archivo);
            linea = new BufferedReader(contenido);

            String cadena = "";

            while ((cadena = linea.readLine()) != null) {
                
                if (cadena.contains(filtro)) {
                    encontro = true;
                    return encontro;
                }

            }
            if (encontro == false) {
                return encontro;
            }

        } catch (IOException e) {
            System.out.print("Error consultando archivo");
        } finally {
            try {
                if (contenido != null) {
                    contenido.close();
                }
            } catch (IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }
        return false;

    }
    void comparar() {
        java.io.File archivo = null;
        FileReader contenido = null;
        BufferedReader linea = null;
       
        try {
            archivo = new java.io.File("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\identificar.txt");
            contenido = new FileReader(archivo);
            linea = new BufferedReader(contenido);

            String cadena = "";

            while ((cadena = linea.readLine()) != null) {
                String dato[] = cadena.split("/");
                
               if(dato[0].equals(ob.getBocas())&& dato[1].equals(ob.getCabello())&&dato[2].
                        equals(ob.getCara())&&dato[3].equals(ob.getNariz())&&dato[4].equals(ob.getOjos())){
                    JOptionPane.showMessageDialog(null,"Existe una coincidencia del 100% de los rasgos en el archivo  "+ dato[5]);
                }else if(dato[0].equals(ob.getBocas())&&dato[2].
                        equals(ob.getCara())&&dato[3].equals(ob.getNariz())&&dato[4].equals(ob.getOjos())){
                    JOptionPane.showMessageDialog(null,"Existe una coincidencia del 90% de los rasgos en el archivo  "+ dato[5]);
                }else if(dato[2].equals(ob.getCara())&&dato[3].equals(ob.getNariz())&&dato[4].equals(ob.getOjos())){
                    JOptionPane.showMessageDialog(null,"Existe una coincidencia del 70% de los rasgos en el archivo  "+ dato[5]);
                }
                

            }
            

        } catch (IOException e) {
            System.out.print("Error consultando archivo");
        } finally {
            try {
                if (contenido != null) {
                    contenido.close();
                }
            } catch (IOException e1) {
                System.out.print("Error cerrando archivo");
            }
        }

    }
    void pdf() {
        try {
            Font fondo=new Font(Font.FontFamily.COURIER,20,Font.ITALIC);
            FileOutputStream archivo = new FileOutputStream("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\PDF\\"+ob.getDoc()+".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(1);
            Chunk c=new Chunk();
            c.append("RETRATO HABLADO");
            c.setFont(fondo);
            parrafo.add(c);
            doc.add(parrafo);

            
            doc.add(new Paragraph("\nNombres : " + ob.getNombre()));
            doc.add(new Paragraph("Documento  : " + ob.getDoc()));
            doc.add(new Paragraph("Correo : " + ob.getEmail()));
            
            Image imagen = Image.getInstance("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\captura.png");
            imagen.setAlignment(Element.ALIGN_CENTER);
            doc.add(imagen);

            
            doc.close();
            JOptionPane.showMessageDialog(null, "PDF Correctamente creado ");

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
    
    public void Correo(){
        String correoEnvia = "miasimni@gmail.com";
        String claveCorreo = "afk16chm49va";
		  
        // La configuraci�n para enviar correo
        Properties properties = new Properties();
		 
        properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");

	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.user", correoEnvia);
	properties.put("mail.password", claveCorreo);
		 
	// Obtener la sesion
	Session session = Session.getInstance(properties, null);
	int aviso = 0;
	try {
            // Crear el cuerpo del mensaje
            MimeMessage mimeMessage = new MimeMessage(session);
		 
            // Agregar quien envia el correo
            mimeMessage.setFrom(new InternetAddress(correoEnvia, "valentina"));
		    
            // Los destinatarios
            InternetAddress[] internetAddresses = {new InternetAddress(ob.getEmail())};
		 
            // Agregar los destinatarios al mensaje
            mimeMessage.setRecipients(Message.RecipientType.TO,
            internetAddresses);
		 
            // Agregar el asunto al correo
            mimeMessage.setSubject("ADJUNTO ARCHIVO CON EL ROSTRO CREADO");
		 
            // Creo la parte del mensaje
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText("");
		 
            MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
            mimeBodyPartAdjunto.attachFile("C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\PDF\\"+ob.getDoc()+".pdf");

            // Crear el multipart para agregar la parte del mensaje anterior
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(mimeBodyPartAdjunto);
		   
            // Agregar el multipart al cuerpo del mensaje
            mimeMessage.setContent(multipart);
		 
            // Enviar el mensaje
            Transport transport = session.getTransport("smtp");
            transport.connect(correoEnvia, claveCorreo);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		   
            transport.close();
		 
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
            aviso = 1;
	}
        if (aviso==0) {
            JOptionPane.showMessageDialog(null, "Correo electronico enviado exitosamente");
        }
    }                                      

}
