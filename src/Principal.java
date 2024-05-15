
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {

		List<Punto> listaPunto = ListaPuntos.getListPuntos();

		solucionarPuntoA(listaPunto);
		solucionarPuntoB(listaPunto);
		solucionarPuntoC(listaPunto);
		solucionarPuntoE(listaPunto);
	}

	private static String graficarLista(List<Punto> listaPuntos) {
		String listaGraficable = "{"
				+ listaPuntos.stream().map(punto -> punto.toString()).collect(Collectors.joining(",")) + "}";
		return listaGraficable;
	}

	/**
	 * RESOLUCIÓN DE PUNTOS
	 */

	private static void solucionarPuntoA(List<Punto> listaPunto) {
		System.out.println("--- Lista ejercicio A ---\n");

		List<Punto> listaA = listaPunto.stream().filter(punto -> (punto.getY() < 15) && (punto.getY() > -15)).sorted()
				.collect(Collectors.toList());
		System.out.println(graficarLista(listaA));
		System.out.println("--- < -------------- > ---\n");
	}

	private static void solucionarPuntoB(List<Punto> listaPunto) {
		System.out.println("--- Lista ejercicio B ---\n");

		List<Punto> listaB = listaPunto.stream().map(punto -> new Punto(punto.getX(), Fx.fx(punto.getX())))
				.collect(Collectors.toList());
		System.out.println(graficarLista(listaB));
		System.out.println("--- < -------------- > ---\n");
	}

	private static void solucionarPuntoC(List<Punto> listaPunto) {
		System.out.println("--- Lista ejercicio C ---\n");
		List<Punto> listaC = listaPunto.stream().filter(p -> (Fx.fx(p.getX()) - p.getY()) > 0)
				.filter(p -> (Fx.fx(p.getX()) - p.getY()) < 10).collect(Collectors.toList());
		System.out.println(graficarLista(listaC));
		System.out.println("--- < -------------- > ---\n");
	}

	private static void solucionarPuntoE(List<Punto> listaPunto) {
		System.out.println("Lista Ejercicio E");
		double avgX = 0;
		double avgY = 0;

		for (Iterator<Punto> iterator = listaPunto.iterator(); iterator.hasNext();) {
			Punto punto = (Punto) iterator.next();
			avgX += punto.getX();
			avgY += punto.getY();

		}
		Punto c = new Punto(avgX / 100, avgY / 100);
		List<Punto> listaE = listaPunto.stream()
				.filter(p -> (Math.sqrt(Math.pow(c.getX() - p.getX(), 2) + Math.pow(c.getY() - p.getY(), 2))) <= 5)
				.collect(Collectors.toList());
		System.out.println(graficarLista(listaE));
		System.out.println("--- < -------------- > ---\n");
	}

}
