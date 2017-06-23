package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdministrador extends AppCompatActivity {

    Button est, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);

        Button Dieta =(Button)findViewById(R.id.btnCrearDieta);
        Dieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dieta = new Intent(MenuAdministrador.this, CrearDieta.class);
                startActivity(dieta);
            }
        });

        est =(Button)findViewById(R.id.btnCrearEstadistica);
        est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent crear = new Intent(MenuAdministrador.this, CrearEstadistica.class);
                startActivity(crear);
            }
        });

        result =(Button)findViewById(R.id.btnCrearResultados);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ingresar = new Intent(MenuAdministrador.this, IngresarResultados.class);
                startActivity(ingresar);
            }
        });
    }
}
