package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GestionarResultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_resultados);
















        Button btnAtras =(Button)findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(GestionarResultados.this, PerfilSalud.class);
                startActivity(perfil);
            }
        });
    }
}
