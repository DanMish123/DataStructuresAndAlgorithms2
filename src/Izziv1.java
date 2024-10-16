//public class Izziv1 {
//    public static void main(String[] args) throws CollectionException {
//        Stack<String> s = new ArrayDeque<String>();
//        Deque<String> d = new ArrayDeque<String>();
//        Sequence<String> z = new ArrayDeque<String>();
////        s.push("ABC");
////        s.push("DEF");
////        s.push("GHI");
////        System.out.println("Stack: ");
////        while (!s.isEmpty()){
////            System.out.print(s.top() + ' ');
////            d.enqueueFront(s.pop());
////        }
////        System.out.println("\n Deque: ");
////        while(!d.isEmpty()){
////            System.out.print(d.back() + ' ');
////            z.add(d.dequeueBack());
////        }
////        System.out.println("\n Sequence: ");
////        for (int i = 0; i < z.size(); i++)
////            System.out.print(i+1 + '.' + z.get(i) + ' ');
////    }
//
//        System.out.println("STACK");
//        System.out.println("Je prazen? " + s.isEmpty());
//        System.out.println("Dodaj A");
//        s.push("A");
//        System.out.println("Dodaj B");
//        s.push("B");
//        System.out.println("Dodaj C");
//        s.push("C");
//        System.out.println("Je poln? " + s.isFull());
//        System.out.println("Stevilo elementov: " + s.size());
//        System.out.println("Je prazen? " + s.isEmpty());
//        System.out.println("Top: " + s.top());
//        System.out.print("Elementi: ");
//        while (!s.isEmpty())
//            System.out.print(s.pop() + ' ');
//
//        System.out.println("\n\nDEQUE");
//        System.out.println("Je prazna? " + s.isEmpty());
//        System.out.println("Dodaj D na zacetku");
//        d.enqueueFront("D");
//        System.out.println("Dodaj E na koncu");
//        d.enqueue("E");
//        System.out.println("Je polna? " + s.isFull());
//        System.out.println("Element na koncu je: " + d.back());
//        System.out.println("Element na zacetku je: " + d.front());
//        System.out.println("Dodaj F na koncu");
//        d.enqueue("F");
//        System.out.println("Dodaj G na zacetku");
//        d.enqueueFront("G");
//        System.out.println("Element na koncu je: " + d.dequeueBack());
//        System.out.println("Element na zacetku je: " + d.dequeue());
//
//        System.out.println("\nSEQUENCE");
//        System.out.println("Je prazno? " + z.isEmpty());
//        System.out.println("Dodaj F ");
//        z.add("F");
//        System.out.println("Dodaj G");
//        z.add("G");
//        System.out.println("Dodaj H");
//        z.add("H");
//        System.out.println("Je polno? " + s.isFull());
//        System.out.println("Velicina: " + z.size());
//        System.out.println("Element na indeks 2: " + z.get(2));
//    }
//}
