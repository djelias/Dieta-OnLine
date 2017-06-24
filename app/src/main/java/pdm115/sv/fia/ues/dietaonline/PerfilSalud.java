package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PerfilSalud extends AppCompatActivity {

    //campos del formulario
    EditText edadPerfilSalud;
    EditText pesoPerfilSalud;
    CheckBox checkBoxMasculino, checkBoxFemenino; //agregar 2 checkbox
    EditText estaturaPerfilSalud;
    EditText alergiasPerfilSalud;
    Spinner spinnerPerfilSalud;

    //botones del formulario
    Button idGuardar;
    Button idEliminar;
    Button idActualizar;

    ControladorBD base = new ControladorBD(this, "DBDieta", null, 3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_salud);



        edadPerfilSalud     = (EditText) findViewById(R.id.edadPerfilSalud);
        pesoPerfilSalud     = (EditText) findViewById(R.id.pesoPerfilSalud);
        checkBoxMasculino   = (CheckBox) findViewById(R.id.checkBoxMasculino);
        checkBoxFemenino    = (CheckBox) findViewById(R.id.checkBoxFemenino);
        estaturaPerfilSalud = (EditText) findViewById(R.id.estaturaPerfilSalud);
        spinnerPerfilSalud = (Spinner) findViewById(R.id.spinnerPerfilSalud);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.estados , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPerfilSalud.setAdapter(spinner_adapter);
        alergiasPerfilSalud = (EditText) findViewById(R.id.alergiasPerfilSalud);

        idGuardar = (Button) findViewById(R.id.idGuardar);
        idGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String edadPerfil=edadPerfilSalud.getText().toString();
                int edad=Integer.parseInt(edadPerfil);
                String pesoPerfil=pesoPerfilSalud.getText().toString();
                float peso=Float.parseFloat(pesoPerfil);
                if (checkBoxMasculino.isChecked())
                {
                    String sexo="masculino";
                }else {
                    if(checkBoxFemenino.isChecked()){
                        String sexo ="femenino";
                    }

                }
                String est=estaturaPerfilSalud.getText().toString();
                float estatura=Float.parseFloat(est);
                String estado=spinnerPerfilSalud.getSelectedItem().toString();
                String alergia=alergiasPerfilSalud.getText().toString();

                if(edadPerfil.equals("")|| pesoPerfil.equals("") || est.equals("") || estado.equals("")|| alergia.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Campos faltantes", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {

                    // Save the Data in Database

                   SQLiteDatabase db = base.getWritableDatabase();

                    if(db != null)
                    {
                        String sqlInsert = "INSERT INTO perfil (edadPerfilSalud, pesoPerfilSalud,  estaturaPerfilSalud, spinnerPerfilSalud, alergiasPerfilSalud ) " +
                                "VALUES ( " + edadPerfil + ", " + pesoPerfil + ", " + estatura + ", '" + estado + "', '" + alergia + "' )";
                        db.execSQL(sqlInsert);
                        Toast.makeText(PerfilSalud.this, "Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

                        db.close();
                    }
                    //Toast.makeText(getApplicationContext(), "Datos ingresados: "+ edadPerfil +",'" + pesoPerfil +"','" + null + "', '" + estatura + "', '" + est +"', '" + alergia +"'", Toast.LENGTH_LONG).show();
                }
            }
        });

        idActualizar =(Button)findViewById(R.id.idActualizar);
        idActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perf = new Intent(PerfilSalud.this, CrearEstadistica.class);
                startActivity(perf);
            }
        });

        idEliminar =(Button)findViewById(R.id.idEliminar);
        idEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(PerfilSalud.this, GestionarEstadisticas.class);
                startActivity(perfil);
            }
        });


    }
}
