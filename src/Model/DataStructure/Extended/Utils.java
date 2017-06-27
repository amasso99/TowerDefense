package Model.DataStructure.Extended;

import Model.DataStructure.List;

import java.lang.reflect.Array;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by jardu on 5/5/2017.
 */
public final class Utils {
    public static <T> void forEachElement(List<T> list, Consumer<T> consumer) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(consumer);

        for (list.toFirst(); list.hasAccess(); list.next()) {
            consumer.accept(list.getContent());
        }
    }

    public static <T> List<T> cloneList(List<T> list) {
        return map(list, x -> x);
    }

    public static <T> List<T> altCloneList(List<T> list) {
        List<T> out = new List<T>();
        for (list.toFirst();list.hasAccess();list.next()){
            out.append(list.getContent());
        }
        return out;
    }

    public static <T> T[] toArray(List<T> list, Class<T> clz) {
        return mapToArray(list, x -> x, clz);
    }

    @SuppressWarnings ("unchecked")
    public static <T, R> R[] mapToArray(List<T> list, Function<T, R> func, Class<R> clz) {
        R[] arr = (R[]) Array.newInstance(clz, size(list));

        list.toFirst();
        for (int i = 0; i < arr.length; ++i, list.next()) {
            arr[i] = func.apply(list.getContent());
        }

        return arr;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> func) {
        Objects.requireNonNull(func);

        List<R> ret = new List<>();

        forEachElement(list, x -> ret.append(func.apply(x)));
        ret.toFirst();

        return ret;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        Objects.requireNonNull(predicate);

        List<T> ret = new List<>();

        forEachElement(list, x -> {
            if (predicate.test(x)) {
                ret.append(x);
            }
        });
        ret.toFirst();

        return ret;
    }

    public static <T> T find(List<T> list, Predicate<T> predicate) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(predicate);

        for (list.toFirst(); list.hasAccess(); list.next()) {
            if (predicate.test(list.getContent())) {
                return list.getContent();
            }
        }
        return null;
    }

    public static <T> T first(List<T> list) {
        list.toFirst();
        return list.getContent();
    }

    public static <T> boolean contains(List<T> list, T item) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(item);

        for (list.toFirst(); list.hasAccess(); list.next()) {
            if (item.equals(list.getContent())) {
                return true;
            }
        }
        return false;
    }

    public static <T> int count(List<T> list, Predicate<T> predicate) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(predicate);

        int count = 0;
        for (list.toFirst(); list.hasAccess(); list.next()) {
            if (predicate.test(list.getContent())) {
                ++count;
            }
        }

        return count;
    }

    public static int size(List<?> list) {
        return count(list, x -> true);
    }

    public static boolean isEmpty(List<?> list) {
        return size(list) == 0;
    }

    public static <T> boolean addIfNotExists(List<T> list, T item) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(item);

        if (contains(list, item)) return false;

        list.append(item);

        return true;
    }

    /*public static <T> String toString(T t, Function<T, String> func){
        return func.apply(t);
    }*/

    public static <T> String toString(List<T> list, Function<T, String> func) {
        return String.join(", ", mapToArray(list, func, String.class));
    }

    public static String toString(List<?> list) {
        return toString(list, x -> x.toString());
    }

    public static void print(List<?> list) {
        System.out.println(toString(list));
    }

    public static int altSize(List<?> list){
        int size = 0;
        for(list.toFirst();list.hasAccess();list.next()){
            size++;
        }
        return size;
    }
}
