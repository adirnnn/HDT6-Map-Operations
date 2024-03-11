package uvg.edu.gt;

public class CardCollectionFactory {
    public enum MapType {
        HASH_MAP,
        TREE_MAP,
        LINKED_HASH_MAP
    }

    public static CardCollection createMap(MapType type) {
        switch (type) {
            case HASH_MAP:
                return new HashMapCardCollection();
            case TREE_MAP:
                return new TreeMapCardCollection();
            case LINKED_HASH_MAP:
                return new LinkedHashMapCardCollection();
            default:
                throw new IllegalArgumentException("Tipo de Map no soportado: " + type);
        }

    }
}
