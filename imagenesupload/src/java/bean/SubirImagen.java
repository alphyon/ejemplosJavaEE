package bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
@ManagedBean
@RequestScoped
public class SubirImagen implements  Serializable{

    private String nombreiamgen;
    private String rutaGua;
    

    public SubirImagen() {
    }

    public String getNombreiamgen() {
        return nombreiamgen;
    }

    public void setNombreiamgen(String nombreiamgen) {
        this.nombreiamgen = nombreiamgen;
    }

    public String getRutaGua() {
        return rutaGua;
    }

    public void setRutaGua(String rutaGua) {
        this.rutaGua = rutaGua;
    }
    
    public void algo(){
        
    }
    
    public void subirImagen(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage();
        String nombreArchivo = event.getFile().getFileName();
        String contextPath = FacesContext.getCurrentInstance().
                getExternalContext().getContextName();
        ExternalContext ec = FacesContext.getCurrentInstance().
                getExternalContext(); 
        setNombreiamgen(contextPath + "/resources/temp/" + nombreArchivo);  
        setRutaGua(ec.getRealPath(contextPath) + "/resources/temp"); 
        
        try {
            File folder = new File(getRutaGua());
            InputStream inf = event.getFile().getInputstream(); 
            OutputStream salida = new FileOutputStream(new File(
                    folder,
                    nombreArchivo)
            ); 
            int read = 0;
            byte[] bytes = new byte[1510000];
            
            while((read = inf.read(bytes))!=-1){
                salida.write(bytes,0,read);
            }
            inf.close();
            salida.flush();
            salida.close();
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            msg.setSummary("Imagen Guardada" + nombreiamgen);
        } catch (Exception e) {
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            msg.setSummary("Imagen No Guardada");
        }
        
        FacesContext.getCurrentInstance().addMessage("Mensaje", msg);
        
    }
}
