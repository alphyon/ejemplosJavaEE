
package controlador;
import javax.faces.model.DataModel;
public abstract class PaginacionHelper {
  private int paginasSize;
    private int paginas;
    public PaginacionHelper(int paginasSize) {
        this.paginasSize = paginasSize;
    }    
    public abstract  int getConteoItems();
    public abstract  DataModel crearPaginaModeloDeDatos();    
    public int getPrimerItemPagina(){
        return paginas * paginasSize;
    }    
    public int getUltimoItemDePagina(){
        int i = getPrimerItemPagina() + paginasSize -1;
        int conteo = getConteoItems()-1;
        if(i > conteo){
            i = conteo;
        }
        if(i<0){
            i=0;
        }
        return  i;
    }    
    public boolean obtenerSiguientePagina(){
        return (paginas +1) * paginasSize + 1 <= getConteoItems();
    }
    
    public void siguientePagina(){
        if(obtenerSiguientePagina()){
            paginas++;
        }
    }
    
    public boolean obtenerAnteriorPagina(){
        return paginas > 0;
    }
    
    public void anteriorPagina(){
        if(obtenerAnteriorPagina()){
            paginas--;
        }
    }
    
    public int getPaginasSize(){
        return paginasSize;
    }     
}
