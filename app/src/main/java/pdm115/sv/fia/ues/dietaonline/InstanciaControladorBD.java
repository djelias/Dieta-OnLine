package pdm115.sv.fia.ues.dietaonline;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Diego on 21/06/2017.
 */
public class InstanciaControladorBD extends AppCompatActivity {

    ControladorBD base = new ControladorBD(this, "DBDieta", null, 8);
    SQLiteDatabase db = base.getWritableDatabase();

    public void insertarCrearMenu(String prot, String carb, String veg, String frut) {
        if (db != null) {
            int id = 1;
            String sqlInsert = "INSERT INTO TIEMPO_COMIDA (ID_TIEMPO_COMIDA, PROTEINA, CARBOHIDRATO, VEGETAL, FRUTA ) " +
                    "VALUES (" + id + ", '" + prot + "', '" + carb + "', '" + veg + "', '" + frut + "')";
            db.execSQL(sqlInsert);
            Toast.makeText(this, "Datos insertados en la base de datos correctamente", Toast.LENGTH_SHORT).show();

            db.close();
        }
    }

}
