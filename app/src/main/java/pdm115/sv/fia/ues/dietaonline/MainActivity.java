package pdm115.sv.fia.ues.dietaonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button registrarse;
    Button IniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrarse =(Button)findViewById(R.id.botonRegistrarse);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(MainActivity.this, RegistrarUsuario.class);
                startActivity(registrarse);
            }
        });

        IniciarSesion = (Button)findViewById(R.id.botonIniciarSesion);
        IniciarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent iniciarSesion = new Intent(MainActivity.this, IniciarSesion.class);
                startActivity(iniciarSesion);
            }
            });

        Button perfil =(Button)findViewById(R.id.prueba);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(MainActivity.this, PerfilSalud.class);
                startActivity(perfil);
            }
        });

    }
}