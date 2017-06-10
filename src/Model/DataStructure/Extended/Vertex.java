package Model.DataStructure.Extended;

import java.util.Objects;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Klasse Vertex
 * </p>
 * <p>
 * Die Klasse Vertex stellt einen einzelnen Knoten eines Graphen dar. Jedes Objekt
 * dieser Klasse verfuegt ueber eine im Graphen eindeutige ID als String und kann diese
 * ID zurueckliefern. Darueber hinaus kann eine Markierung gesetzt und abgefragt werden.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Oktober 2015
 */
public class Vertex<T> {
    //Einmalige ID des Knotens und Markierung
    private T content;
    private boolean mark;

    /**
     * Ein neues Objekt vom Typ Vertex wird erstellt. Seine Markierung hat den Wert false.
     */
    public Vertex(T pID) {
        content = pID;
    }

    /**
     * Die Anfrage liefert die ID des Knotens als String.
     */
    public T getContent() {
        return content;
    }

    /**
     * Der Auftrag setzt die Markierung des Knotens auf den Wert pMark.
     */
    public void setMark(boolean pMark) {
        mark = pMark;
    }

    /**
     * Die Anfrage liefert true, wenn die Markierung des Knotens den Wert true hat, ansonsten false.
     */
    public boolean isMarked() {
        return mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(content, vertex.content);
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
