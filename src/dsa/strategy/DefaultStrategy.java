package dsa.strategy;

public final class DefaultStrategy implements Strategy {

    public boolean equal(Object obj1, Object obj2) {
        return obj1.toString().equals(obj2.toString());
    }


    public int compare(Object obj1, Object obj2) {
        int comp = obj1.toString().compareTo(obj2.toString());
        return Integer.compare(comp, 0);
    }
}
