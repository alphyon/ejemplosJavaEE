
package datos;
import java.sql.PreparedStatement;
public class Mantenimiento {
    Coneccion cn = new Coneccion();
    PreparedStatement ps = null;
    String msg = null;
    public int Insertar(String nombre, String apellido, String email) {
        int estado = 0;
        try {
            String sql = "INSERT INTO pruebas.pruebas";
            sql += "(id,nombre,apellido,email) ";
            sql += " VALUES (null,?,?,?)";
            ps = cn.Conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            if (ps.executeUpdate() == 1) {
                estado = 1;
                msg = "Guardado";
                System.out.println(msg);
            }
        } catch (Exception e) {
            estado = 0;
            msg = e.getMessage();
            System.out.println(msg);
        }
        return estado;
    }
    public int Eliminar(int id) {
        int estado = 0;
        try {
            String sql = "DELETE FROM  pruebas.pruebas WHERE id = ?";
            ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) estado = 1;  
        } catch (Exception e) {
            estado = 0;
            e.getMessage();
        }
        return estado;
    }
}
