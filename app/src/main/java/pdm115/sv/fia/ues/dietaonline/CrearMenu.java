package pdm115.sv.fia.ues.dietaonline;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CrearMenu extends AppCompatActivity {

    EditText proteina, carbohidratos, vegetales, frutas, cantipro, canticarbo, cantiVeget, cantifrut;
    Spinner spindia, spintiempo;
    TextView caloriasRestantes;
    Button botonGuardar;
    InstanciaControladorBD controlador = new InstanciaControladorBD();
    apoyoCrearMenu apoyo = new apoyoCrearMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_menu);

        proteina = (EditText) findViewById(R.id.etProteina);
        cantipro = (EditText) findViewById(R.id.etProteinaCantidad);
        carbohidratos = (EditText) findViewById(R.id.etCarbohidratos);
        canticarbo = (EditText) findViewById(R.id.etCarbohidratosCantidad);
        vegetales = (EditText) findViewById(R.id.etVegetales);
        cantiVeget = (EditText) findViewById(R.id.etVegetalesCantidad);
        frutas = (EditText) findViewById(R.id.etFrutas);
        cantifrut = (EditText) findViewById(R.id.etFrutasCantidad);
        spindia = (Spinner) findViewById(R.id.spinnerDia);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.Dia , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spindia.setAdapter(spinner_adapter);

        spintiempo = (Spinner) findViewById(R.id.spinnerTiempo);
        ArrayAdapter spinner_adapter2 = ArrayAdapter.createFromResource( this, R.array.Tiempo , android.R.layout.simple_spinner_item);
        spinner_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spintiempo.setAdapter(spinner_adapter2);

        botonGuardar = (Button) findViewById(R.id.btnGuardarMenu);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dia = spindia.getSelectedItem().toString();
                String tiempo = spintiempo.getSelectedItem().toString();
                String prot = proteina.getText().toString();
                String carb = carbohidratos.getText().toString();
                String veg = vegetales.getText().toString();
                String frut = frutas.getText().toString();
                String cant = cantipro.getText().toString();
                Integer num = Integer.parseInt(cant);
                String cant2 = canticarbo.getText().toString();
                Integer num2 = Integer.parseInt(cant2);
                String cant3 = cantiVeget.getText().toString();
                Integer num3 = Integer.parseInt(cant3);
                String cant4 = cantifrut.getText().toString();
                Integer num4 = Integer.parseInt(cant4);

                if (prot.equals("")||carb.equals("")||veg.equals("")||frut.equals("")) {
                    Toast.makeText(getApplicationContext(), "Campos faltantes", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    // Save the Data in Database
                    int suma = apoyo.sumaCaloriasDia(num, num2, num3, num4);

                    prot = prot + ", " + cant;
                    carb = carb + ", " + cant2;


                    controlador.insertarCrearMenu(prot, carb, veg, frut);

                    //Toast.makeText(getApplicationContext(), "Datos ingresados: "+ dia +", " + tiempo +", " + prot + ", " + carb +", " + veg +"", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
