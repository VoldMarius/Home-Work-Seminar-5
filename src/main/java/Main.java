import java.util.*;


public class Main {
    public static void main(String[] args) {
        //Реализуем структуру телефонной книги с помощью HashMap
        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> phonebook = new ArrayList<String[]>();
        System.out.println("Введите Номер п/п,Имя, Фамилию, телефон моб,LOG звонков, телефон рабочий,LOG звонков : ");
        HashMap<Integer, String[]> phonebookMap = new HashMap<>();
        while (sc.hasNext()) {
            String name = sc.nextLine();
            phonebook.add(name.split(" "));
        }
        for (int i = 0; i < phonebook.size(); i++) {
            phonebookMap.put(i, phonebook.get(i)); //Реализция структуры телефонной книги с помощью HashMap

        }
        TreeMap<Integer, String> bookMap = new TreeMap<>(); //Создаие  bookMap для сортировки повторяющихся имен
        for (int i = 0; i < phonebookMap.size(); i++) {
            for (String elem : phonebookMap.get(i)) {
                bookMap.put((i), phonebookMap.get(i)[1]);
            }
        }

        List<String> name = new ArrayList();
        bookMap.forEach((k, v) -> name.add(String.format(v)));
        Collections.sort(name);
        List<Integer> count = new ArrayList<>();
        List<String> namemap = new ArrayList<>();
        String sample = (name.get(0));
        namemap.add(name.get(0));
        int counting = 0;
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).equals(sample) == true) {//Сортировка имен по частоте упоминания
                counting = counting + 1;
            } else {
                namemap.add(name.get(i));
                count.add(counting);
                counting = 1;
                sample = name.get(i);
                if (i == name.size() - 1) {
                    count.add(1);
                }
            }
        }
        Map<String, Integer> nameUnSort = new TreeMap<>();
        Map<String, Integer> nameSort = new LinkedHashMap<>();
        for (int i = 0; i < namemap.size(); i++) {
            nameUnSort.put(namemap.get(i), count.get(i));
        }
        nameUnSort.values().removeIf(value -> value.equals(1)); // удаление одиночных имен по параметру values(1)

        Set set = new HashSet(count);
        List<Integer> list = new ArrayList(set);
        list.sort(Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            for (String j : nameUnSort.keySet()) {
                if (nameUnSort.get(j) == list.get(i)) {// Сортировка по убыванию популярности с помощью LinkedHashMap
                    nameSort.put(j, list.get(i));
                }
            }
        }
        System.out.println("повторяющиеся имена в порядке уменьшения :");
        nameSort.entrySet()
                .iterator()
                .forEachRemaining(System.out::println);
    }
}

//            TreeMap<Integer, List[]> phone = new TreeMap<>();
//            List<String[]> name1 = new ArrayList<>();
//            List<Integer[]> phoneLog = new ArrayList<>();
//        while (sc.hasNext()) {
//            String line = sc.nextLine();
//            name1.add(line.split(" "));
//            phoneLog.add(Integer.valueOf(name1.get(3)));
//            phoneLog.add(name1.get(4));
//            phoneLog.add(name1.get(5));
//            phoneLog.add(name1.get(6));
//        }
//        for (String[] elem : data) {
//
//            phone.put(Integer.valueOf(elem[2]), (phoneLog))
//                }
//                System.out.println();
//                System.out.println(phone);


//        nameSort.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .forEach(System.out::println); // или любой другой конечный метод


//        for( Map.<String, String>item : s.entrySet()){
//
//            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
//        }



//    Map<String,String> s =new TreeMap<String,String>();
//     for (int i = 0; i< data.size(); i++)
//            s.put(data.get(i)[1],data.get(i)[0]);


