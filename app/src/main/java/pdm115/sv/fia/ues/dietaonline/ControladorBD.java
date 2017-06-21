package pdm115.sv.fia.ues.dietaonline;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by dell i7 on 15/06/2017.
 */

public class ControladorBD extends SQLiteOpenHelper {


    public ControladorBD(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL("create table AVANCE (ID_AVANCE INTEGER PRIMARY KEY NOT NULL, DIFERENCIA float, ESTADO varchar) ");
            db.execSQL("create table CUMPLIMIENTO(ID_CUMPLIMIENTO INTEGER PRIMARY KEY NOT NULL, ID_RESULTADO integer, CUMPLIO bool, MOTIVO varchar, " +
                    "FOREIGN KEY(ID_RESULTADO) REFERENCES RESULTADO(ID_RESULTADO))");
            db.execSQL("create table DIA(ID_DIA INTEGER PRIMARY KEY NOT NULL, ID_MENU integer, NOMBRE varchar, FOREIGN KEY(ID_MENU) REFERENCES MENU(ID_MENU))");
            db.execSQL("create table DIA_TIEMPO_COMIDA(ID_DIA integer NOT NULL, ID_TIEMPO_COMIDA integer NOT NULL, PRIMARY KEY (ID_DIA, ID_TIEMPO_COMIDA), " +
                    "FOREIGN KEY(ID_TIEMPO_COMIDA) REFERENCES TIEMPO_COMIDA(ID_TIEMPO_COMIDA), FOREIGN KEY(ID_DIA) REFERENCES DIA(ID_DIA))");
            db.execSQL("create table DIETA(ID_DIETA INTEGER PRIMARY KEY NOT NULL, ID_MENU integer, NOMBRE varchar, CALORIAS_DIA integer, SEXO varchar, MERIENDAS integer, " +
                    "EDAD_INICIO integer, EDAD_FIN integer, FOREIGN KEY(ID_MENU) REFERENCES MENU(ID_MENU))");
            db.execSQL("create table ESTADISTICA(ID_ESTADISTICA INTEGER PRIMARY KEY NOT NULL, TIPO_GRAFICO varchar, TITULO varchar, SEXO varchar, PADECIMIENTO varchar, " +
                    "DESCRIPCION varchar, FECHA_INICIO varchar, FECHA_FIN varchar, EDAD_INICIO varchar, EDAD_FIN varchar)");
            db.execSQL("create table MENU(ID_MENU INTEGER PRIMARY KEY NOT NULL)");
            db.execSQL("create table PERFIL(ID_PERFIL INTEGER PRIMARY KEY NOT NULL, ID_DIETA integer, ID_USUARIO integer, EDAD integer, PESO_INICIO float, SEXO varchar, " +
                    "ESTATURA float, ESTADO_SALUD varchar, ALERGIAS varchar)");
            db.execSQL("create table PRIVILEGIO(ID_PRIVILEGIO INTEGER PRIMARY KEY NOT NULL, TIPO_PRIVILEGIO varchar)");
            db.execSQL("create table RESULTADO(ID_RESULTADO INTEGER PRIMARY KEY NOT NULL, ID_CUMPLIMIENTO integer, ID_AVANCE integer, ID_DIETA integer, PESO float, " +
                    "DIFERENCIA float, ESTADO varchar, COMENTARIO varchar, FOREIGN KEY(ID_CUMPLIMIENTO) REFERENCES CUMPLIMIENTO(ID_CUMPLIMIENTO), " +
                    "FOREIGN KEY(ID_AVANCE) REFERENCES AVANCE(ID_AVANCE), FOREIGN KEY(ID_DIETA) REFERENCES DIETA(ID_DIETA))");
            db.execSQL("create table RESULTADO_ESTADISTICAS(ID_ESTADISTICA integer NOT NULL, ID_RESULTADO integer NOT NULL, PRIMARY KEY (ID_ESTADISTICA, ID_RESULTADO), " +
                    "FOREIGN KEY(ID_ESTADISTICA) REFERENCES ESTADISTICA(ID_ESTADISTICA), FOREIGN KEY(ID_RESULTADO) REFERENCES RESULTADO(ID_RESULTADO))");
            db.execSQL("create table ROL(ID_ROL INTEGER PRIMARY KEY NOT NULL, TIPO_ROL varchar)");
            db.execSQL("create table ROL_PRIVILEGIO(ID_ROL integer NOT NULL, ID_PRIVILEGIO integer NOT NULL, PRIMARY KEY (ID_ROL, ID_PRIVILEGIO), " +
                    "FOREIGN KEY(ID_ROL) REFERENCES ROL(ID_ROL), FOREIGN KEY(ID_PRIVILEGIO) REFERENCES PRIVILEGIO(ID_PRIVILEGIO))");
            db.execSQL("create table TIEMPO_COMIDA(ID_TIEMPO_COMIDA INTEGER PRIMARY KEY NOT NULL, PROTEINA varchar, CARBOHIDRATO varchar, VEGETAL varchar, FRUTA varchar)");
            db.execSQL("create table USUARIO(ID_USUARIO INTEGER PRIMARY KEY NOT NULL, ID_ROL integer, ID_PERFIL integer, NOMBRE varchar, CONTRASENA varchar, EMAIL varchar, TELEFONO varchar, " +
                    "FOREIGN KEY(ID_ROL) REFERENCES ROL(ID_ROL), FOREIGN KEY(ID_PERFIL) REFERENCES PERFIL(ID_PERFIL))");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS AVANCE");
        db.execSQL("DROP TABLE IF EXISTS CUMPLIMIENTO");
        db.execSQL("DROP TABLE IF EXISTS DIA");
        db.execSQL("DROP TABLE IF EXISTS DIA_TIEMPO_COMIDA");
        db.execSQL("DROP TABLE IF EXISTS DIETA");
        db.execSQL("DROP TABLE IF EXISTS ESTADISTICA");
        db.execSQL("DROP TABLE IF EXISTS MENU");
        db.execSQL("DROP TABLE IF EXISTS PERFIL");
        db.execSQL("DROP TABLE IF EXISTS PRIVILEGIO");
        db.execSQL("DROP TABLE IF EXISTS RESULTADO");
        db.execSQL("DROP TABLE IF EXISTS RESULTADO_ESTADISTICAS");
        db.execSQL("DROP TABLE IF EXISTS ROL");
        db.execSQL("DROP TABLE IF EXISTS ROL_PRIVILEGIO");
        db.execSQL("DROP TABLE IF EXISTS TIEMPO_COMIDA");
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }
}
