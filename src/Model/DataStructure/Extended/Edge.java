package Model.DataStructure.Extended;

import java.util.Objects;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Klasse Edge
 * </p>
 * <p>
 * Die Klasse Edge stellt eine einzelne, ungerichtete Kante eines Graphen dar.
 * Beim Erstellen werden die beiden durch sie zu verbindenden Knotenobjekte und eine
 * Gewichtung als double uebergeben. Beide Knotenobjekte koennen abgefragt werden.
 * Des Weiteren koennen die Gewichtung und eine Markierung gesetzt und abgefragt werden.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Oktober 2015
 */
public class Edge<T, R extends Comparable<R>> {
    private Vertex<T> start;
    private Vertex<T> end;
    private R weight;
    private boolean marked;

    /**
     * Ein neues Objekt vom Typ Edge wird erstellt. Die von diesem Objekt
     * repraesentierte Kante verbindet die Knoten pVertex und pAnotherVertex mit der
     * Gewichtung pWeight. Ihre Markierung hat den Wert false.
     */
    public Edge(Vertex<T> pVertex, Vertex<T> pAnotherVertex, R pWeight) {
        start = pVertex;
        end = pAnotherVertex;
        weight = pWeight;
        marked = false;
    }

    public Vertex<T> getStart() {
        return start;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    /**
     * Die Anfrage liefert das Gewicht der Kante als double.
     */
    public R getWeight() {
        return weight;
    }

    /**
     * Der Auftrag setzt das Gewicht der Kante auf pWeight.
     */
    public void setWeight(R pWeight) {
        weight = pWeight;
    }

    /**
     * Die Anfrage liefert true, wenn die Markierung der Kante den Wert true hat, ansonsten false.
     */
    public boolean isMarked() {
        return marked;
    }

    /**
     * Der Auftrag setzt die Markierung der Kante auf den Wert pMark.
     */
    public void setMarked(boolean pMark) {
        marked = pMark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd(), getWeight(), isMarked());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?, ?> edge = (Edge<?, ?>) o;
        return isMarked() == edge.isMarked() && Objects.equals(getStart(), edge.getStart()) && Objects.equals(getEnd(), edge.getEnd()) && Objects.equals(getWeight(), edge.getWeight());
    }
}
