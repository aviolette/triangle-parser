import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class Main {
  public static void main(String[] args) {
    if (args.length < 1) {
      System.err.println("File not specified");
      System.exit(1);
    }
    int triangles = 0;
    double surfaceArea = 0.0;
    try (var reader = new BufferedReader(new FileReader(args[0]))) {
      String line;
      var polygon = new ArrayList<Point>(3);
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.startsWith("vertex ")) {
          polygon.add(Arrays.stream(line.substring(7).split(" ")).map(Double::parseDouble).collect(toPoint()));
        } else if (line.startsWith("endloop")) {
          var triangle = new Triangle(polygon);
          triangles++;
          surfaceArea += triangle.surfaceArea();
          polygon.clear();
        }
      }
      System.out.println("Number of triangles: " + triangles);
      System.out.println("Surface Area: " + surfaceArea);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static class PointCollector implements Collector<Double, List<Double>, Point> {
    @Override
    public Supplier<List<Double>> supplier() {
      return LinkedList::new;
    }

    @Override
    public BiConsumer<List<Double>, Double> accumulator() {
      return List::add;
    }

    @Override
    public BinaryOperator<List<Double>> combiner() {
      return (list1, list2) -> list1;
    }

    @Override
    public Function<List<Double>, Point> finisher() {
      return (l) -> new Point(l.get(0), l.get(1), l.get(2));
    }

    @Override
    public Set<Characteristics> characteristics() {
      return new HashSet<>();
    }
  }

  private static PointCollector toPoint() {
    return new PointCollector();
  }
}
