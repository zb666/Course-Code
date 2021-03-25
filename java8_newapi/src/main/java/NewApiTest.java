import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewApiTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add("Data: " + i);
        }

        List<Integer> collect = list.stream().map(String::hashCode).collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.printf("hashcode: " + integer);
        }

        Stream<Integer> sourceStream = Stream.of(1, 2, 3, 4, 5,5);

        Stream<Integer> distinctStream = sourceStream.distinct();

        List<Integer> integerList = distinctStream.filter(p -> p < 3).collect(Collectors.toList());

        Stream<Integer> sourceStream2 = Stream.of(1, 2, 3, 4, 5,5);

        List<String> stringList = sourceStream2.map(p -> String.valueOf(p)+": Value").collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }




    }

}
