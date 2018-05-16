import java.util.*;

public class HeterogeneousContainerMain {

    public static void main(String[] args) {
        HeterogeneousContainer container = new HeterogeneousContainer();

        container.putContainer(Integer.class, 29);
        container.putContainer(String.class, "example");
        // will cause class cast exception
        //container.putContainer(int.class, 29);

        System.out.println(container.getContainer(Integer.class));
        System.out.println(container.getContainer(String.class));
        System.out.println(container.getContainer(String.class));
        

        Column<Integer> integerColumn = new Column<Integer>(Integer.class);
        Column<String> stringColumn = new Column<String>(String.class);
        Column<String> stringColumn2 = new Column<String>(String.class);
 
        DatabaseRow databaseRow = new DatabaseRow();
        databaseRow.putColumn(integerColumn, 3);
        databaseRow.putColumn(stringColumn, "3");
        databaseRow.putColumn(stringColumn2, "second");
 
        System.out.println("The integer + 1: "+ (databaseRow.getColumn(integerColumn)+1));
        System.out.println("The string: "+ databaseRow.getColumn(stringColumn));
        System.out.println("The string: "+ databaseRow.getColumn(stringColumn2));
    }
}