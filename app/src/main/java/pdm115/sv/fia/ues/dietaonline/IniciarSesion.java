package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class IniciarSesion extends AppCompatActivity {

    EditText et1, et2;
    String[] campos = new String[] {"usuario", "contraseña"};
    String[] args = new String[] {"usu1"};
    ControladorBD base = new ControladorBD(this, "DBDieta", null, 13);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        et1 = (EditText) findViewById(R.id.etUsuarioLog);
        et2 = (EditText) findViewById(R.id.etPassLog);





    Button botonIniciarSesion = (Button) findViewById(R.id.btnLogin);
    botonIniciarSesion.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
        SQLiteDatabase db = base.getReadableDatabase();

        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        Cursor fila = db.rawQuery("select nombre, contrasena from usuario where nombre='" + usuario + "' and contrasena='" + contrasena + "'", null);
        //preguntamos si el cursor tiene algun valor almacenado
        if (fila.moveToFirst() == true) {

            //capturamos los valores del cursos y lo almacenamos en variable
            String usua = fila.getString(0);
            String pass = fila.getString(1);

            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua) && contrasena.equals(pass)) {
                Toast.makeText(IniciarSesion.this, "Se ha logeado", Toast.LENGTH_SHORT).show();

                //si son iguales entonces vamos a otra ventana

                //Menu es una nueva actividad empty
                Intent ven = new Intent(IniciarSesion.this, CrearMenu.class);
                startActivity(ven);

                //limpiamos las las cajas de texto
                et1.setText("");
                et2.setText("");
            }
        }
        }
    });
}
}