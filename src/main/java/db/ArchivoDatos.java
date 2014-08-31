package db;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
/**
 * Created by root on 30/08/14.
 */
public class ArchivoDatos {
    private static String nombreArchivo="datos.txt";
    private Context context;

    public ArchivoDatos(Context context){
        this.context=context;

        FileOutputStream f;
        try{
            f = this.context.openFileOutput(nombreArchivo,Context.MODE_APPEND);
            escribirArchivo(f);
        }catch (FileNotFoundException e){
            Log.e("NO hay archivo, se creara uno ", e.getMessage());
            File datafile = new File(nombreArchivo);
            try{
                f = this.context.openFileOutput(nombreArchivo,Context.MODE_APPEND);
                escribirArchivo(f);
            }catch (FileNotFoundException e2){}
            catch (IOException e1) {e1.printStackTrace();}

        } catch (IOException e) {e.printStackTrace();}
    }
    private void escribirArchivo(FileOutputStream f) throws IOException {
        String correo1="dadaoros@hotmail.com", correo2="usuario@correo.com";
        String pass1="12345", pass2="00000";
        f.write(correo1.getBytes());
        f.write(pass1.getBytes());
        f.write(correo2.getBytes());
        f.write(pass2.getBytes());
    }
    public boolean validarUsuario(String username, String password){
        boolean validated=false;
        /*
        try {
            FileInputStream f= context.openFileInput(nombreArchivo);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(f));
            String linea;
            int contador=0;
            do{
                contador++;
                linea=entrada.readLine();
                if(linea==username)validated=true;

            }while(linea!= null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return validated;
    }

}
