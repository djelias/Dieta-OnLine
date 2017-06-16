package pdm115.sv.fia.ues.dietaonline;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class PerfilSalud extends AppCompatActivity {
    //atributos, construcotres, getters and setter del perfil de salud
    /*public int edadPerfil;
    public float pesoPerfil;
    public String sexoPerfil;
    public float estaturaPerfil;
    public String estadoSalud;
    public String alergias;

    public PerfilSalud() {
    }

    public PerfilSalud(int edadPerfil, float pesoPerfil, String sexoPerfil, float estaturaPerfil, String estadoSalud, String alergias) {
        this.edadPerfil = edadPerfil;
        this.pesoPerfil = pesoPerfil;
        this.sexoPerfil = sexoPerfil;
        this.estaturaPerfil = estaturaPerfil;
        this.estadoSalud = estadoSalud;
        this.alergias = alergias;
    }

    public int getEdadPerfil() {
        return edadPerfil;
    }

    public void setEdadPerfil(int edadPerfil) {
        this.edadPerfil = edadPerfil;
    }

    public float getPesoPerfil() {
        return pesoPerfil;
    }

    public void setPesoPerfil(float pesoPerfil) {
        this.pesoPerfil = pesoPerfil;
    }

    public String getSexoPerfil() {
        return sexoPerfil;
    }

    public void setSexoPerfil(String sexoPerfil) {
        this.sexoPerfil = sexoPerfil;
    }

    public float getEstaturaPerfil() {
        return estaturaPerfil;
    }

    public void setEstaturaPerfil(float estaturaPerfil) {
        this.estaturaPerfil = estaturaPerfil;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }*/

    //campos del formulario
    EditText edadPerfil;
    EditText pesoPerfil;
    CheckBox sexoPerfil;
    EditText estaturaPerfil;
    Spinner estadoSalud;
    EditText alergias;

    //botones del formulario
    Button idGuardar;
    Button idEliminar;
    Button idActualizar;

    ControladorBD base = new ControladorBD(this, "DBDieta", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_salud);

        edadPerfil     = (EditText) findViewById(R.id.edadPerfilSalud);
        pesoPerfil     = (EditText) findViewById(R.id.pesoPerfilSalud);
        sexoPerfil     = (CheckBox) findViewById(R.id.checkBoxMasculino);
        sexoPerfil     = (CheckBox) findViewById(R.id.checkBoxFemenino);
        estaturaPerfil = (EditText) findViewById(R.id.estaturaPerfilSalud);
        estadoSalud    = (Spinner)  findViewById(R.id.spinnerPerfilSalud);
        alergias       = (EditText) findViewById(R.id.alergiasPerfilSalud);

        idGuardar = (Button) findViewById(R.id.idGuardar);
        idGuardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int edad=Integer.parseInt(edadPerfil.getText().toString());
                float peso=Float.parseFloat(pesoPerfil.getText().toString());
                String sexo=sexoPerfil.getText().toString();
                float estatura=Float.parseFloat(estaturaPerfil.getText().toString());
                //String estado=estadoSalud
                String alergia=alergias.getText().toString();

                if(edad == 0|| peso == 0.0 || sexo.equals("") || estatura == 0 || alergia.equals(""))
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
                        String sqlInsert = "INSERT INTO PERFIL (ID_PERFIL, ID_DIETA, ID_USUARIO, EDAD, PESO_INICIO, SEXO, ESTATURA, ESTADO_SALUD, ALERGIAS ) " + "VALUES (" + id + ")";
                        db.execSQL(sqlInsert);

                        db.close();
                    }
                }
            }
        });



    }
}
