package pdm115.sv.fia.ues.dietaonline;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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


    ControladorBD base = new ControladorBD(this, "DBDieta", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_estadistica);


        final ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipos);
        spinnerTipo.setAdapter(adaptador);
        titulo     = (EditText) findViewById(R.id.titulo);
        date1     = (EditText) findViewById(R.id.date1);
        date2     = (EditText) findViewById(R.id.date2);
        final ArrayAdapter<String> adap2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,rangos);
        spinnerEdad.setAdapter(adap2);
        RadioMasc   = (RadioButton) findViewById(R.id.radioMasc);
        RadioFem    = (RadioButton) findViewById(R.id.radioFem);
        final ArrayAdapter<String> adap3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,padecimientos);
        spinnerPad.setAdapter(adap3);
        final ArrayAdapter<String> adap4= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,otros);
        spinnerOt.setAdapter(adap4);
        descripcion = (EditText) findViewById(R.id.descripcion);

        btnCrearEst = (Button) findViewById(R.id.btnCrearEst);
        btnCrearEst.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //lectura de datos
                /*"create table ESTADISTICA(ID_ESTADISTICA INTEGER PRIMARY KEY NOT NULL, TIPO_GRAFICO varchar, TITULO varchar, SEXO varchar, PADECIMIENTO varchar, " +
                        "DESCRIPCION varchar, FECHA_INICIO varchar, FECHA_FIN varchar, EDAD_INICIO varchar, EDAD_FIN varchar); " +*/
                spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 1:
                                Toast to1 = Toast.makeText(getApplicationContext(), tipos[i], Toast.LENGTH_LONG);
                                //String to1=spinnerPerfilSalud.getTextDirection(to1);
                                to1.show();
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                break;
                            case 2:
                                Toast to2 = Toast.makeText(getApplicationContext(), tipos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                to2.show();
                                break;
                            case 3:
                                Toast to3 = Toast.makeText(getApplicationContext(), tipos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                to3.show();
                                break;
                            case 4:
                                Toast to4 = Toast.makeText(getApplicationContext(), tipos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                to4.show();
                                break;
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                String tituloEst=titulo.getText().toString();
                String fechaI=date1.getText().toString();
                String fechaF=date2.getText().toString();
                spinnerEdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 1:
                                Toast t1 = Toast.makeText(getApplicationContext(), rangos[i], Toast.LENGTH_LONG);
                                //String to1=spinnerPerfilSalud.getTextDirection(to1);
                                t1.show();
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                break;
                            case 2:
                                Toast t2 = Toast.makeText(getApplicationContext(), rangos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t2.show();
                                break;
                            case 3:
                                Toast t3 = Toast.makeText(getApplicationContext(), rangos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t3.show();
                                break;
                            case 4:
                                Toast t4 = Toast.makeText(getApplicationContext(), rangos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t4.show();
                                break;
                            case 5:
                                Toast t5 = Toast.makeText(getApplicationContext(), rangos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t5.show();
                                break;
                            case 6:
                                Toast t6 = Toast.makeText(getApplicationContext(), rangos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t6.show();
                                break;
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                if (RadioMasc.isChecked())
                {
                    String sexo=RadioMasc.getText().toString();
                }else {
                    String sexo = RadioFem.getText().toString();
                }
                spinnerPad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 1:
                                Toast t11 = Toast.makeText(getApplicationContext(), padecimientos[i], Toast.LENGTH_LONG);
                                //String to1=spinnerPerfilSalud.getTextDirection(to1);
                                t11.show();
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                break;
                            case 2:
                                Toast t12 = Toast.makeText(getApplicationContext(), padecimientos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t12.show();
                                break;
                            case 3:
                                Toast t13 = Toast.makeText(getApplicationContext(), padecimientos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t13.show();
                                break;
                            case 4:
                                Toast t14 = Toast.makeText(getApplicationContext(), padecimientos[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                t14.show();
                                break;
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                spinnerOt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 1:
                                Toast tos1 = Toast.makeText(getApplicationContext(), otros[i], Toast.LENGTH_LONG);
                                //String to1=spinnerPerfilSalud.getTextDirection(to1);
                                tos1.show();
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                break;
                            case 2:
                                Toast tos2 = Toast.makeText(getApplicationContext(), otros[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                tos2.show();
                                break;
                            case 3:
                                Toast tos3 = Toast.makeText(getApplicationContext(), otros[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                tos3.show();
                                break;
                            case 4:
                                Toast tos4 = Toast.makeText(getApplicationContext(), otros[i], Toast.LENGTH_LONG);
                                //spinnerTipo.setAdapter(adaptador);
                                tos4.show();
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
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

                    int total = 0;

                    if(db != null)
                    {
                        int id = 1;
                        String sqlInsert = "INSERT INTO ESTADISTICA (id_estadistica, tipo_grafico, titulo, sexo, padecimiento, descripcion, fecha_inicio, fecha_fin, edad_inicio, edad_fin,  ) " +
                                "VALUES (" + id + ", " + null + ", " + tituloEst +", " + null +", " + null +", " + descripcion + ", " + fechaI + ", " + fechaF + ", "+ null +", "+ null +")";
                        db.execSQL(sqlInsert);
                        Toast.makeText(CrearEstadistica.this,"Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

                        db.close();
                    }

                }
            }
        });




    }


}
