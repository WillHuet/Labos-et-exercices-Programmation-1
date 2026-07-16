import java.util.*;

public class GenericCollections {
    public void makeIntArray(){
        // create integerArray
        Integer[] intArray = new Integer[5];

        // assign Integer 10 to integerArray[0]
        intArray[0] = 10;

        // get int value
        int value = intArray[0];
    }

    private void removeColors(Collection<String> collection1, Collection<String> collection2){
        Iterator<String> iterator = collection1.iterator();

        while(iterator.hasNext()){
            if(collection2.contains(iterator.next())){
                iterator.remove();
            }
        }
    }

    public void makeColorArrayList(){
        String[] colors = {"RED","BLUE","GREEN","YELLOW", "WHITE", "CYAN", "PURPLE"};
        List<String> list = new ArrayList<String>();
        for (String color : colors){
            list.add(color);
        }
        // all colors should be added to the ArrayList

        String[] removeColors = {"RED","CYAN","WHITE"};
        List<String> removeList = new ArrayList<String>();
        for (String color : removeColors){
            removeList.add(color);
        }
        // list of colors to remove completed

        System.out.println("ArrayList: ");
        for (int i = 0; i < list.size(); i++){
            System.out.printf("%s ", list.get(i));
        }

        removeColors(list, removeList);

        System.out.printf("%n%nArrayList after calling removeColors:%n");

        for (String color : list){
            System.out.printf("%s ", color);
        }
    }

    public void ArrayListSpecs(){
        List<String> list = new ArrayList<>();
        // list.add("...") = add single element. Has the first Iterator available (0 in this case)
        list.add("RED");
        list.add("BLUE");
        list.add("GREEN");

        List<String> list2 = new ArrayList<>();
        list2.add("CYAN");
        list2.add("PURPLE");
        list2.add("YELLOW");

        // list.addAll(Collection<...>) = add ALL elements from another collection
        list.addAll(list2);

        // String.toUpperCase() = get uppercase version (toLowerCase as well)
        list.get(0).toUpperCase();

        // list.set(iterator, String) = replace item that has the iterator mentioned
        list.set(5, "WHITE");

        // list.subList(start, end) = make a sublist from an iterator to the other
        List<String> shortList = list.subList(0, 1);

        // list.clear() = remove ALL items from List
        shortList.clear();

        // list.size() = returns list number of items
        list.size();

        ListIterator<String> iterator = list.listIterator();
        // ListIterator.hasNext || ListIterator.hasNext = boolean, determine if there's another item before or after
        iterator.hasNext();
        // goes to next item
        iterator.next();
        // goes to previous item
        iterator.previous();
    }

    public void collectionsSpecs(){
        List<Integer> list = new ArrayList<>();
        // list.add("...") = add single element. Has the first Iterator available (0 in this case)
        list.add(40);
        list.add(12);
        list.add(1);
        list.add(99);

        List<Integer> list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // sort list in alphabetical or ascending order
        Collections.sort(list);
        // sort list in reverse alphabetical or descending order
        Collections.reverse(list);
        // shuffle list in random order
        Collections.shuffle(list);
        // copies references from a list to another
        Collections.copy(list, list2);
        // returns smallest item
        Collections.min(list);
        // returns biggest item
        Collections.max(list);
        // calculates how many collection items equals to specific item
        Collections.frequency(list, 99);
        // determines if two collections has no element in common
        Collections.disjoint(list, list2);
    }

    private void createMap(Map<String, Integer> map){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter key: ");
        String input = scanner.nextLine();

        // tokenize the input
        String[] tokens = input.split(" ");

        //precessing input text
        for (String token : tokens){
            String word = token.toLowerCase();

            // if the map contains the word
            if (map.containsKey(word)){
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    private void displayMap(Map<String, Integer> map){
        Set<String> keys = map.keySet();

        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : sortedKeys){
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize: %d%nisEmpty: %b%n",  map.size(), map.isEmpty());
    }

    public void mapSpecs(){
        Map<String, Integer> map = new HashMap<>();

        createMap(map);
        displayMap(map);

        // determines whether a key is in the map
        map.containsKey("a");
        // creates a new entry or replaces an existing entry's value
        map.put("hello", 1);
        // obtain the specified key's associated value in the map
        map.get("hello");
        // returns the number of key/value pairs in the Map
        map.size();
        // return a boolean indicating whether the Map is empty
        map.isEmpty();
    }

    void main(String[] args) {
        mapSpecs();
    }
}
