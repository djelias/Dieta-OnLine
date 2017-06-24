package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearEstadistica extends AppCompatActivity {


    //campos del formulario
    Spinner spinnerTipo;
    EditText titulo;
    EditText date1;
    EditText date2;
    Spinner spinnerEdad;
    RadioButton RadioMasc, RadioFem;
    Spinner spinnerPad;
    Spinner spinnerOt;
    EditText descripcion;

    Button btnCrearEst;

    //spinners List
    String[] tipos={"Lista de tipos", "Lineal", "Barra", "Puntos","Pastel"};
    String[] rangos={"Lista de edades", "1-10", "11-20", "21-30","31-40", "41-50", "51-100"};
    String[] padecimientos={"Lista de padecimientos", "Excelente", "Bueno", "Regular","Malo"};
    String[] otros={"Lista de otros", "A", "B", "C","D"};


    ControladorBD base = new ControladorBD(this, "DBDieta", null, 3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_estadistica);


        spinnerTipo = (Spinner) findViewById(R.id.spinnerTipo);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.tipos , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(spinner_adapter);

        titulo     = (EditText) findViewById(R.id.titulo);
        date1     = (EditText) findViewById(R.id.date1);
        date2     = (EditText) findViewById(R.id.date2);
        spinnerEdad = (Spinner) findViewById(R.id.spinnerEdad);
        ArrayAdapter spinner_adap = ArrayAdapter.createFromResource( this, R.array.rangos , android.R.layout.simple_spinner_item);
        spinner_adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdad.setAdapter(spinner_adap);
        RadioMasc   = (RadioButton) findViewById(R.id.radioMasc);
        RadioFem    = (RadioButton) findViewById(R.id.radioFem);
        spinnerPad = (Spinner) findViewById(R.id.spinnerPad);
        ArrayAdapter spinner_adapt = ArrayAdapter.createFromResource( this, R.array.padecimientos , android.R.layout.simple_spinner_item);
        spinner_adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPad.setAdapter(spinner_adapt);
        spinnerOt = (Spinner) findViewById(R.id.spinnerOt);
        ArrayAdapter spinner_adapte = ArrayAdapter.createFromResource( this, R.array.otros , android.R.layout.simple_spinner_item);
        spinner_adapte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOt.setAdapter(spinner_adapte);
        descripcion = (EditText) findViewById(R.id.descripcion);

        btnCrearEst = (Button) findViewById(R.id.btnCrearEst);
        btnCrearEst.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //lectura de datos
                /*"create table ESTADISTICA(ID_ESTADISTICA INTEGER PRIMARY KEY NOT NULL, TIPO_GRAFICO varchar, TITULO varchar, SEXO varchar, PADECIMIENTO varchar, " +
                        "DESCRIPCION varchar, FECHA_INICIO varchar, FECHA_FIN varchar, EDAD_INICIO varchar, EDAD_FIN varchar); " +*/
                String tipo=spinnerTipo.getSelectedItem().toString();
                String tituloEst=titulo.getText().toString();
                String fechaI=date1.getText().toString();
                String fechaF=date2.getText().toString();
                String edad=spinnerEdad.getSelectedItem().toString();
                //sexo
                String padecimiento=spinnerPad.getSelectedItem().toString();
                String otro=spinnerOt.getSelectedItem().toString();
                if (RadioMasc.isChecked())
                {
                    String sexo=RadioMasc.getText().toString();
                }else {
                    String sexo = RadioFem.getText().toString();
                }
                String desc=descripcion.getText().toString();

                if(titulo.equals("")||date1.equals("")||date2.equals("")||descripcion.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Campos faltantes", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database

                    SQLiteDatabase db = base.getWritableDatabase();

                    //int total = 0;

                    if(db != null)
                    {
                        //int id = 1;
                        String sqlInsert = "INSERT INTO ESTADISTICA (tipo_grafico, titulo, sexo, padecimiento, descripcion, fecha_inicio, fecha_fin, edad_inicio, edad_fin,  ) " +
                                "VALUES ( '" + tipo + "', '" + tituloEst +"', '" + null +"', '" + padecimiento +"', '" + descripcion + "', '" + fechaI + "', '" + fechaF + "', '"+ edad +"', '"+ edad +"')";
                        db.execSQL(sqlInsert);
                        Toast.makeText(CrearEstadistica.this,"Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

                        db.close();
                    }
                    Toast.makeText(getApplicationContext(), "Datos ingresados: "+ tipo +", " + tituloEst +", " + fechaI + ", " + fechaF +", " + edad +", " + padecimiento + ", " + otro + ", " + desc + ", ", Toast.LENGTH_LONG).show();

                }
            }
        });




    }

}
