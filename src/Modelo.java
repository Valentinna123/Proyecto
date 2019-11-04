
public class Modelo {
  private String nombre;
  private String doc;
  private String email;
  private String user;
  private String contra;
  private String cara;
  private String ojos;
  private String bocas;
  private String nariz;
  private String cabello;
  
    public Modelo() {
    }

    public Modelo(String nombre, String doc, String email, String user, String contra, String cara, String ojos, String bocas, String nariz, String cabello) {
        this.nombre = nombre;
        this.doc = doc;
        this.email = email;
        this.user = user;
        this.contra = contra;
        this.cara = cara;
        this.ojos = ojos;
        this.bocas = bocas;
        this.nariz = nariz;
        this.cabello = cabello;
    }

    public void setBocas(String bocas) {
        this.bocas = bocas;
    }

    public String getBocas() {
        return bocas;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }

    public String getCabello() {
        return cabello;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }

    public String getCara() {
        return cara;
    }

    public void setNariz(String nariz) {
        this.nariz = nariz;
    }

    public String getNariz() {
        return nariz;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getOjos() {
        return ojos;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDoc() {
        return doc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getContra() {
        return contra;
    }
    
    
}
