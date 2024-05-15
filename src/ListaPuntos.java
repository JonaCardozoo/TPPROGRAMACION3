
import java.util.*;

public class ListaPuntos {

    private static final int LimitArray = 100;

    public static List<Punto> getListPuntos(){
        Random random = new Random();

        double[] listaX = random.doubles(LimitArray, -10,10).toArray();
        double[] listaY = random.doubles(LimitArray, -20, 20).toArray();

        List<Punto> listaPuntos = new ArrayList<Punto>();
        for(int i = 0; i < LimitArray; i++) {
            listaPuntos.add(new Punto(listaX[i], listaY[i]));
        }
        return listaPuntos;
    }
}
