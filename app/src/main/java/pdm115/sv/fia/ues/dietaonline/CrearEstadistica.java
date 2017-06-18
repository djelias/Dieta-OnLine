package pdm115.sv.fia.ues.dietaonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

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




    }


}
