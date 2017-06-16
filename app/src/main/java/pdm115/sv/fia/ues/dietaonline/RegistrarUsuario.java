package pdm115.sv.fia.ues.dietaonline;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity {
    EditText nombre, usuario, contraseña, email, telefono;
    Button btnGuardarRegistro;

    ControladorBD base = new ControladorBD(this, "DBDieta", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);


        nombre = (EditText) findViewById(R.id.etnombre);
        usuario = (EditText) findViewById(R.id.etusuario);
        contraseña = (EditText) findViewById(R.id.etpass);
        email = (EditText) findViewById(R.id.etemail);
        telefono = (EditText) findViewById(R.id.ettel);

        btnGuardarRegistro = (Button) findViewById(R.id.btnGuardarRegistro);
        btnGuardarRegistro.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
        String nombreUsuario=nombre.getText().toString();
        String Usuario=usuario.getText().toString();
        String contraseñaUsuario=contraseña.getText().toString();
        String emailUsuario=email.getText().toString();
        String telefonoUsuario=telefono.getText().toString();

            if(nombreUsuario.equals("")||Usuario.equals("")||contraseñaUsuario.equals("")||emailUsuario.equals("")||telefonoUsuario.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Campos faltantes", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                // Save the Data in Database

                SQLiteDatabase db = base.getWritableDatabase();

                int total = 0;

                if(db != null)
                {
                    int id = 1;
                    String sqlInsert = "INSERT INTO usuario (id_usuario, id_rol, id_perfil, nombre, contraseña, email ) " + "VALUES (" + id + ", '" + nombreUsuario +"')";
                    db.execSQL(sqlInsert);

                    db.close();
                }

            }
        }
        });
    }
}