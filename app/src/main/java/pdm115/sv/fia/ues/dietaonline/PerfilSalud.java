package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    //String[] estados={"Lista de estados", "Excelente", "Bueno", "Regular","Malo"};

    //botones del formulario
    Button idGuardar;
    Button idEliminar;
    Button idActualizar;

    ControladorBD base = new ControladorBD(this, "DBDieta", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_salud);



        edadPerfilSalud     = (EditText) findViewById(R.id.edadPerfilSalud);
        pesoPerfilSalud     = (EditText) findViewById(R.id.pesoPerfilSalud);
        checkBoxMasculino   = (CheckBox) findViewById(R.id.checkBoxMasculino);
        checkBoxFemenino    = (CheckBox) findViewById(R.id.checkBoxFemenino);
        estaturaPerfilSalud = (EditText) findViewById(R.id.estaturaPerfilSalud);

        /*spinnerPerfilSalud  = (Spinner)  findViewById(R.id.spinnerPerfilSalud);
        final ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,estados);
        spinnerPerfilSalud.setAdapter(adaptador);*/

        spinnerPerfilSalud = (Spinner) findViewById(R.id.spinnerPerfilSalud);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.estados , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPerfilSalud.setAdapter(spinner_adapter);

        alergiasPerfilSalud = (EditText) findViewById(R.id.alergiasPerfilSalud);

        idGuardar = (Button) findViewById(R.id.idGuardar);
        idGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                int edadPerfil=Integer.parseInt(edadPerfilSalud.getText().toString());
                float pesoPerfil=Float.parseFloat(pesoPerfilSalud.getText().toString());

                if (checkBoxMasculino.isChecked())
                {
                    String sexoPerfil=checkBoxMasculino.getText().toString();
                }else {
                    String sexoPerfil = checkBoxFemenino.getText().toString();
                }
                float estatura=Float.parseFloat(estaturaPerfilSalud.getText().toString());
                String est=spinnerPerfilSalud.getSelectedItem().toString();
                /*spinnerPerfilSalud.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        switch(i){
                            case 1:
                                Toast to1 = Toast.makeText(getApplicationContext(), estados[i], Toast.LENGTH_LONG);
                                //String to1=spinnerPerfilSalud.getTextDirection(to1);
                                to1.show();
                                spinnerPerfilSalud.setAdapter(adaptador);
                                break;
                            case 2:
                                Toast to2 = Toast.makeText(getApplicationContext(), estados[i], Toast.LENGTH_LONG);
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                to2.show();
                                break;
                            case 3:
                                Toast to3 = Toast.makeText(getApplicationContext(), estados[i], Toast.LENGTH_LONG);
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                to3.show();
                                break;
                            case 4:
                                Toast to4 = Toast.makeText(getApplicationContext(), estados[i], Toast.LENGTH_LONG);
                                //spinnerPerfilSalud.setAdapter(adaptador);
                                to4.show();
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });*/

                String alergia=alergiasPerfilSalud.getText().toString();

                if(edadPerfil == 0|| pesoPerfil == 0.0 || /*sexoPerfil.equals("") ||*/ estatura == 0 || alergia.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Campos faltantes", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {

                    // Save the Data in Database

                   /* SQLiteDatabase db = base.getWritableDatabase();

                    int total = 0;

                    if(db != null)
                    {
                        int id = 1;
                        String sqlInsert = "INSERT INTO PERFIL (ID_PERFIL, ID_DIETA, ID_USUARIO, EDAD, PESO_INICIO, SEXO, ESTATURA, ESTADO_SALUD, ALERGIAS ) " +
                                "VALUES (" + id + ",  " + null + ", " + null + ", " + edadPerfil + ", " + pesoPerfil + ", " + null + ", " + estatura + ", " + null + ", " + alergia + " )";
                        db.execSQL(sqlInsert);
                        Toast.makeText(PerfilSalud.this,"Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

                        db.close();
                    }*/
                    Toast.makeText(getApplicationContext(), "Datos ingresados: "+ edadPerfil +", " + null + "," + pesoPerfil +", " + estatura + ", " + est +", " + alergia +"", Toast.LENGTH_LONG).show();
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
                Intent perfil = new Intent(PerfilSalud.this, GestionarResultados.class);
                startActivity(perfil);
            }
        });


    }
}
