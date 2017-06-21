package pdm115.sv.fia.ues.dietaonline;

/**
 * Created by Diego on 21/06/2017.
 */
public class apoyoCrearMenu {

    public int sumaCaloriasDia(int num, int num2, int num3, int num4){

        int suma = num + num2 + num3 + num4;
        return suma;
    }

    public  int caloriasRestantes(int total, int diferencia){

        int nuevoTotal = total - diferencia;
        return nuevoTotal;

    }

}
