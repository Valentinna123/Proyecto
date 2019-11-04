
import java.io.File;





public class RetratoHablado {

   
    public static void main(String[] args) {
        crearCarpeta();
       InterPrincipal ob =new InterPrincipal();
        ob.setVisible(true);
    }
    private static void crearCarpeta(){
        String crear="C:\\Users\\valenthina\\Desktop\\ARCHIVOS\\PDF";
        File c = new File(crear);
        if(c.mkdirs()){
            System.out.println("creado");
        }else{
            System.out.println("no creado");
        }
    }
}
