
package Control;

import DAO.UsuarioDAO;
//import Entidad.Sistema;
import Entidad.Usuario;
//import Frontera.FramePrincipal;

import static Frontera.FramePrincipal.sistema;
        
public class ValidarLogin {
    
    // private Sistema sitema = FramePrincipal.sistema;
    private UsuarioDAO dao = new UsuarioDAO();

    public ValidarLogin() {
    }
    
    public String verificarLogin (Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
           return ("Longitud nombre incorrecta");
        }
        if(!verificarLongitudPassword(usuario.getPassword())){
           return ("Longitud contraseña incorrecta");
        }
    /*  for (Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre()) &&
               u.getPassword().equals(usuario.getPassword())){
            return("Bienvenido");
            }
        }*/
        if(dao.leer(usuario) != null){
            return ("Bienvenido");
        }
        return ("Datos incorrectos");
    }
   
    public boolean verificarLongitudNombre(String nombre){
        return (nombre.length() >1 && nombre.length() <=6);
    }
    
    public boolean verificarLongitudPassword(String password){
        return (password.length() >=3 && password.length() <6);
    }
}
