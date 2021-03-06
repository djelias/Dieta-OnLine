package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearDieta extends AppCompatActivity {

    EditText nombreDieta, cantidadCalorias, cantidadMeriendas, cantidadMenu, edadInicio, edadFin;
    Spinner rangoEdades;
    CheckBox checkF, checkM;
    Button btnCrearDieta;

    ControladorBD base = new ControladorBD(this, "DBDieta", null, 3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_dieta);

        nombreDieta = (EditText) findViewById(R.id.etNombreDieta);
        cantidadCalorias = (EditText) findViewById(R.id.etCantidadCalorias);
        cantidadMeriendas = (EditText) findViewById(R.id.etCantidadMeriendas);
        rangoEdades = (Spinner) findViewById(R.id.spinnerRangoEdad);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.RangoEdad , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rangoEdades.setAdapter(spinner_adapter);
        checkF = (CheckBox) findViewById(R.id.checkBoxF);
        checkM = (CheckBox) findViewById(R.id.checkBoxM);

        btnCrearDieta = (Button) findViewById(R.id.btnGuardarDieta);
        btnCrearDieta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String nomDieta=nombreDieta.getText().toString();
                String cant=cantidadCalorias.getText().toString();
                Integer cantCal=Integer.parseInt(cant);
                String cant2=cantidadMeriendas.getText().toString();
                Integer cantMer=Integer.parseInt(cant2);
                String rango=rangoEdades.getSelectedItem().toString();

                if (checkF.isChecked())
                {
                    String sexoPerfil= "Femenino";

                }else {
                    String sexoPerfil = "Masculino";
                }

                if(nomDieta.equals("")||cant.equals("")||cantMer.equals(""))
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
                        String sqlInsert = "INSERT INTO dieta (nombre, calorias_dia, sexo, meriendas, edad_inicio, edad_fin ) " +
                                "VALUES ('" + nomDieta + "', " + cantCal + ", " + null + ", " + cantMer + ", " + null + ", " + null + ")";
                        db.execSQL(sqlInsert);
                        Toast.makeText(CrearDieta.this,"Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

                        db.close();
                    }

                }
                Intent ven = new Intent(CrearDieta.this, CrearMenu.class);
                startActivity(ven);
            }

        });
    }
}
