package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class IniciarSesion extends AppCompatActivity {
    EditText et1, et2;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        et1 = (EditText) findViewById(R.id.etemail);
        et2 = (EditText) findViewById(R.id.etpass);
    }


    public void ingresar(View v) {
        ControladorBD admin = new ControladorBD(this, "usuario", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        fila = db.rawQuery("select usuario,contrasena from usuarios where usuario='" + usuario + "' and contrasena='" + contrasena + "'", null);
        //preguntamos si el cursor tiene algun valor almacenado
        if (fila.moveToFirst() == true) {

            //capturamos los valores del cursos y lo almacenamos en variable
            String usua = fila.getString(0);
            String pass = fila.getString(1);

            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua) && contrasena.equals(pass)) {

                //si son iguales entonces vamos a otra ventana

                //Menu es una nueva actividad empty
                Intent ven = new Intent(this, Menu.class);
                startActivity(ven);

                //limpiamos las las cajas de texto
                et1.setText("");
                et2.setText("");
            }

        }
    }
}