public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customList = new CustomLinkedList<>();
        customList.add(15);
        customList.add(16);
        customList.add(17);
        customList.print();
        System.out.println(customList.size());

        customList.add(15);
        customList.add(16);
        customList.add(17);

        customList.add(null);
        customList.print();
        System.out.println(customList.size());

        customList.removeFromTail(15);


        customList.print();
        System.out.println(customList.size());

        customList.delete(17);


        customList.print();
        System.out.println(customList.size());
        customList.removeFromTail(null);


        customList.print();
        System.out.println(customList.size());
    }
}
