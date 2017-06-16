package pdm115.sv.fia.ues.dietaonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PerfilSalud extends AppCompatActivity {

    public int edadPerfil;
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
    }
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_salud);
    }
}
