import java.util.HashMap;
import java.util.Map;

public class DatabaseRow {

    private Map<Column<?>, Object> columns = new HashMap<>();

    public <T> void putColumn(Column<T> type, T instance) {
        if ( type == null ) 
            throw new NullPointerException("type is null");
        columns.put(type, instance.getClass().cast(instance));
        //columns.put(type, instance);
    }

    public <T> T getColumn(Column<T> type) {
        return type.cast(columns.get(type));
    }
}