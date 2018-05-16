import java.util.*;

public class HeterogeneousContainer {
    private Map<Class<?>, Object> container = new HashMap<>();

    public <T> void putContainer(Class<T> type, T instance) {
        if ( type == null ) 
            throw new NullPointerException("type is null");
        container.put(type, type.cast(instance));
        //container.put(type, instance);
    }

    public <T> T getContainer(Class<T> type) {
        return type.cast(container.get(type));
    }
}