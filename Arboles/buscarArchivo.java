package Arboles;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class buscarArchivo {
    List listFiles = new LinkedList<>();
    public boolean buscarArchivo(String nombreArchivo, File folder) {
        for(int i = 0; i<listFiles.size(); i++) {
            if (listFiles.get(i).getName().equals(nombreArchivo)){
                return true;
            }
        }
        for(int j = 0; j<listFolders.size(); j++){
            boolean encontro = buscarArchivo(nombre, listFolders.get(i));
            if(encontro) return true;
        }
        return false;
    }

}
