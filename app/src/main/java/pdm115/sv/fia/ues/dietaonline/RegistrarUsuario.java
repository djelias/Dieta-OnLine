package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity {
    EditText nombre, usuario, contraseña, email, telefono;
    Button btnGuardarRegistro;
    Spinner spinnerTipoUsuario;
    int id;
    ControladorBD base = new ControladorBD(this, "DBDieta", null, 13);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);


        nombre = (EditText) findViewById(R.id.etnombre);
        usuario = (EditText) findViewById(R.id.etusuario);
        contraseña = (EditText) findViewById(R.id.etpass);
        email = (EditText) findViewById(R.id.etemail);
        telefono = (EditText) findViewById(R.id.ettel);
        spinnerTipoUsuario = (Spinner) findViewById(R.id.spinnerTipoUsuario);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.TipoUsuario , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoUsuario.setAdapter(spinner_adapter);

        btnGuardarRegistro = (Button) findViewById(R.id.btnGuardarRegistro);
        btnGuardarRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nombreUsuario = nombre.getText().toString();
                String Usuario = usuario.getText().toString();
                String contraseñaUsuario = contraseña.getText().toString();
                String rolUsuario = spinnerTipoUsuario.getSelectedItem().toString();
                String emailUsuario = email.getText().toString();
                String telefonoUsuario = telefono.getText().toString();

                if (nombreUsuario.equals("") || Usuario.equals("") || contraseñaUsuario.equals("") || emailUsuario.equals("") || telefonoUsuario.equals("")) {
                    Toast.makeText(getApplicationContext(), "Campos faltantes", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    SQLiteDatabase db = base.getWritableDatabase();
                    // Save the Data in Database
                    if (db != null) {

                        String sqlInsert = "INSERT INTO usuario (nombre, contrasena, email, telefono, rol ) " +
                                "VALUES ('" + nombreUsuario + "', '" + contraseñaUsuario + "', '" + emailUsuario + "', '" + telefonoUsuario + "', '" + rolUsuario + "')";
                        db.execSQL(sqlInsert);
                        Toast.makeText(RegistrarUsuario.this, "Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

                        db.close();

                        Intent iniciarSesion = new Intent(RegistrarUsuario.this, IniciarSesion.class);
                        startActivity(iniciarSesion);
                    }
                }
            }


        });
    }
}