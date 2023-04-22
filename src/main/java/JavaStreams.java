import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    @Test
    public void getNames() {

        ArrayList<String> names = new ArrayList<String>();
        int count = 0;
        names.add("SHAJI");
        names.add("Elma");
        names.add("Junaid");
        names.add("Zee");
        names.add("Taimur");


        for(int i=0; i < names.size(); i++){

            String current = names.get(i);
            if(current.startsWith("S")){
                count++;
                System.out.println(count);
            }

        }

    }

    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("SHAJI");
        names.add("Elma");
        names.add("Junaid");
        names.add("Zee");
        names.add("Taimur");

        long A = names.stream().filter(s->s.startsWith("SH")).count();

        System.out.println(A);


        long d = Stream.of("SHAJI","Elma","Sajid","Salik").filter(e -> {
             return e.startsWith("S");

        }).count();
        System.out.println(d);

        names.stream().filter(s-> s.length() > 4).forEach(s-> System.out.println(s));



    }

    @Test
    public void streamMap(){
        //List <String> list =
              // Stream.of("SHAJI","Elma","Sajid","Salik").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s -> System.out.println(s))
              //          .collect(Collectors.toList());


        //List<String> names = Arrays.asList("SHAJI","Elma","Sajid","Salik");


    }


}
