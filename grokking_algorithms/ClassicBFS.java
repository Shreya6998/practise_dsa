import java.util.*;

public class ClassicBFS {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Me", List.of("Alice", "Beth", "Carol", "Meredith", "Peter", "Sandy", "Ursula", "Zander"));
        graph.put("Alice", List.of("Derek", "Ethan", "Francesca"));
        graph.put("Beth", List.of("Gerald", "Harris", "Ingrid", "Ophelia"));
        graph.put("Carol", List.of("Jonathan", "Kate", "Lucifer"));
        graph.put("Meredith", List.of("Norris", "Ophelia"));
        graph.put("Peter", List.of("Queen", "Robert", "Yolanda"));
        graph.put("Sandy", List.of("Tilly", "Kate"));
        graph.put("Ursula", List.of("Vanessa", "Walter", "Xavier"));
        graph.put("Zander", List.of());
        graph.put("Harris", List.of("Yolanda"));
        graph.put("Francesca", List.of("Tilly"));
        graph.put("Vanessa", List.of());
        graph.put("Ophelia", List.of());
        graph.put("Derek", List.of());
        graph.put("Ethan", List.of());
        graph.put("Gerald", List.of("Ophelia"));
        graph.put("Ingrid", List.of());
        graph.put("Jonathan", List.of());
        graph.put("Kate", List.of("Jonathan"));
        graph.put("Lucifer", List.of());
        graph.put("Norris", List.of());
        graph.put("Queen", List.of());
        graph.put("Robert", List.of("Emma"));
        graph.put("Tilly", List.of());
        graph.put("Walter", List.of("Yolanda"));
        graph.put("Xavier", List.of());
        graph.put("Yolanda", List.of());
        graph.put("Emma", List.of());

        String name = "Max";
        Optional<Person> person = findPerson(name, graph);

        if(person.isPresent()) {
            System.out.println(name + " is found in the graph! Degree is " + person.get().degree + ". Nodes traversed are " + person.get().path);
        }
        else
            System.out.println(name + " is not found in the graph!");

    }

    private static Optional<Person> findPerson(String name, Map<String, List<String>> graph){
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(0, "Me", List.of("Me")));
        Set<String> visited = new HashSet<>();
        visited.add("Me");
        while (!queue.isEmpty()){
            Person person = queue.poll();
            if (person.name.equals(name)) return Optional.of(person);

            List<String> names = graph.get(person.name);
            if(names == null) continue;
            for(String n : names){
                if(!visited.contains(n)){
                    List<String> path = new ArrayList<>(person.path);
                    path.add(n);
                    queue.add(new Person(person.degree + 1, n, path));
                    visited.add(n);
                }
            }
        }
        return Optional.empty();
    }

    private record Person(int degree, String name, List<String> path) {}
}
