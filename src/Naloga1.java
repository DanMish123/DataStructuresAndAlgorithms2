import java.util.Scanner;

//class CollectionException extends Exception{
//    public CollectionException(String msg){
//        super(msg);
//    }
//}

@SuppressWarnings("unused")
//interface Collection {
//    static final String ERR_MSG_EMPTY = "Collection is empty.";
//    static final String ERR_MSG_FULL = "Collection is full.";
//
//    boolean isEmpty();
//    boolean isFull();
//    int size();
//    String toString();
//    int next(int i);
//    int prev(int i);
//}

interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}

interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}

interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}

@SuppressWarnings({"unchecked", "FieldMayBeFinal"})
class ArrayDeque<T> implements Collection, Deque<T>, Stack<T>, Sequence<T> {
    private T[] a;
    private int front, back, size;
    private static final int DEFAULT_CAPACITY = 64;

    public ArrayDeque() {
        this.a = (T[]) new Object[DEFAULT_CAPACITY];
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size > 0) {
            for (int i = 0; i < size - 1; i++)
                sb.append(a[prev(back - i)].toString()).append(' ');
            sb.append(a[front].toString());
            return sb.toString();
        } else return "";
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int next(int i) {
        return (i + 1) % DEFAULT_CAPACITY;
    }

    @Override
    public int prev(int i) {
        return (DEFAULT_CAPACITY + i - 1) % DEFAULT_CAPACITY;
    }

    @Override
    public T front() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        return a[front];
    }

    @Override
    public T back() throws CollectionException {
        return top();
    }

    @Override
    public void enqueue(T x) throws CollectionException {
        push(x);
    }

    @Override
    public void enqueueFront(T x) throws CollectionException {
        if (isFull())
            throw new CollectionException(ERR_MSG_FULL);
        front = prev(front);
        a[front] = x;
        size++;
    }

    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        T o = a[front];
        a[front] = null;
        front = next(front);
        size--;
        return o;
    }

    @Override
    public T dequeueBack() throws CollectionException {
        return pop();
    }

    @Override
    public T get(int i) throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (i < 0 || i >= size)
            throw new CollectionException(ERR_MSG_INDEX);
        return a[i];
    }

    @Override
    public void add(T x) throws CollectionException {
        push(x);
    }

    @Override
    public T top() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        return a[prev(back)];
    }

    @Override
    public void push(T x) throws CollectionException {
        if (isFull())
            throw new CollectionException(ERR_MSG_FULL);
        a[back] = x;
        back = next(back);
        size++;
    }

    @Override
    public T pop() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        back = prev(back);
        T o = a[back];
        a[back] = null;
        size--;
        return o;
    }
}






class Calculator {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";
    static final String ERR_MSG_NOT_ENOUGH_EL = "Not enough elements in stack.";
    private boolean condition = false;

    Sequence<Stack<String>> stacks = new ArrayDeque<>();

    Calculator() throws CollectionException {
        for (int i = 0; i < 42; i++)
            stacks.add(new ArrayDeque<>());
    }

    public void echo() throws CollectionException {
        if (stacks.get(0).isEmpty())
            System.out.println();
        else System.out.println(stacks.get(0).top());
    }

    public void _pop() throws CollectionException {
        stacks.get(0).pop();
    }

    public void dup() throws CollectionException {
        if (stacks.get(0).isFull())
            throw new CollectionException(ERR_MSG_FULL);
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        stacks.get(0).push(s.top());
        stacks.get(0).push(s.pop());
    }

    public void dup2() throws CollectionException {
        if (stacks.get(0).isFull())
            throw new CollectionException(ERR_MSG_FULL);
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> s = new ArrayDeque<>();
        Stack<String> s1 = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        s1.push(stacks.get(0).pop());
        stacks.get(0).push(s1.top());
        stacks.get(0).push(s.top());
        stacks.get(0).push(s1.pop());
        stacks.get(0).push(s.pop());
    }

    public void swap() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        Stack<String> s1 = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        s.push(stacks.get(0).pop());
        s1.push(s.pop());
        s1.push(s.pop());
        stacks.get(0).push(s1.pop());
        stacks.get(0).push(s1.pop());
    }

    public void _char() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        char ch = (char) Integer.parseInt(stacks.get(0).pop());
        stacks.get(0).push(String.valueOf(ch));
    }

    public void even() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (Integer.parseInt(stacks.get(0).pop()) % 2 == 0)
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void odd() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (Integer.parseInt(stacks.get(0).pop()) % 2 != 0)
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void factorial() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        int product = 1;
        for (int i = 1; i <= Integer.parseInt(stacks.get(0).top()); i++)
            product *= i;
        stacks.get(0).pop();
        stacks.get(0).push(String.valueOf(product));
    }

    public void len() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        stacks.get(0).push(String.valueOf(s.pop().length()));
    }

    public void checkDifferent() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        if (Integer.parseInt(stacks.get(0).pop()) != Integer.parseInt(stacks.get(0).pop()))
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void checkLower() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        if (Integer.parseInt(stacks.get(0).pop()) < Integer.parseInt(s.pop()))
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void checkLowerEqual() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        if (Integer.parseInt(stacks.get(0).pop()) <= Integer.parseInt(s.pop()))
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void checkEqual() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        if (stacks.get(0).pop().equals(stacks.get(0).pop()))
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void checkHigher() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        if (Integer.parseInt(stacks.get(0).pop()) > Integer.parseInt(s.pop()))
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void checkHigherEqual() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        if (Integer.parseInt(stacks.get(0).pop()) >= Integer.parseInt(s.pop()))
            stacks.get(0).push("1");
        else stacks.get(0).push("0");
    }

    public void add() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        int sum = Integer.parseInt(stacks.get(0).pop()) + Integer.parseInt(stacks.get(0).pop());
        stacks.get(0).push(String.valueOf(sum));
    }

    public void subtract() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        int sub = Integer.parseInt(stacks.get(0).pop()) - Integer.parseInt(s.pop());
        stacks.get(0).push(String.valueOf(sub));
    }

    public void multiply() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        int product = Integer.parseInt(stacks.get(0).pop()) * Integer.parseInt(stacks.get(0).pop());
        stacks.get(0).push(String.valueOf(product));
    }

    public void divide() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        int div = Integer.parseInt(stacks.get(0).pop()) / Integer.parseInt(s.pop());
        stacks.get(0).push(String.valueOf(div));
    }

    public void remainder() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        int a = Integer.parseInt(stacks.get(0).pop());
        int b = Integer.parseInt(s.pop());
        int rem = a % b;
        stacks.get(0).push(String.valueOf(rem));
    }

    public void combine() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        Stack<String> s = new ArrayDeque<>();
        Stack<String> s1 = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        s1.push(stacks.get(0).pop());
        stacks.get(0).push(s1.pop() + s.pop());
    }

    public void random() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        if (stacks.get(0).size() == 1)
            throw new CollectionException(ERR_MSG_NOT_ENOUGH_EL);
        int b = Integer.parseInt(stacks.get(0).pop());
        int a = Integer.parseInt(stacks.get(0).pop());
        int result = (int) (Math.random() * (a - b + 1) + b);
        stacks.get(0).push(String.valueOf(result));
    }

    public void then() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        condition = Integer.parseInt(stacks.get(0).pop()) != 0;
    }

    public void _else() throws CollectionException {
        condition = !condition;
    }

    public boolean question() throws CollectionException {
        return condition;
    }

    public void print() throws CollectionException {
        System.out.println(stacks.get(Integer.parseInt(stacks.get(0).pop())).toString());
    }

    public void clear() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> s = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        while (!stacks.get(Integer.parseInt(s.top())).isEmpty())
            stacks.get(Integer.parseInt(s.top())).pop();
    }

    public void run() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> temp = new ArrayDeque<>();
        int index = Integer.parseInt(stacks.get(0).pop());
        while (!stacks.get(index).isEmpty())
            temp.push(stacks.get(index).pop());
        Stack<String> copy = new ArrayDeque<>();
        while(!temp.isEmpty()) {
            copy.push(temp.top());
            stacks.get(index).push(temp.top());
            temp.pop();
        }
        Stack<String> s = new ArrayDeque<>();
        while (!copy.isEmpty())
            s.push(copy.pop());
        while (!s.isEmpty())
            execute(s.pop());
    }

    public void loop() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        int ind = Integer.parseInt(stacks.get(0).pop());
        int n = Integer.parseInt(stacks.get(0).pop());
        for (int i = 0; i < n; i++){
            Stack<String> temp = new ArrayDeque<>();
            while (!stacks.get(ind).isEmpty())
                temp.push(stacks.get(ind).pop());
            Stack<String> copy = new ArrayDeque<>();
            while(!temp.isEmpty()) {
                copy.push(temp.top());
                stacks.get(ind).push(temp.top());
                temp.pop();
            }
            Stack<String> s = new ArrayDeque<>();
            while (!copy.isEmpty())
                s.push(copy.pop());
            while (!s.isEmpty())
                execute(s.pop());
        }
    }

    public void move() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> s1 = new ArrayDeque<>();
        int index = Integer.parseInt(stacks.get(0).pop());
        s1.push(stacks.get(0).pop());
        for (int i = 0; i < Integer.parseInt(s1.top()); i++) {
            String element = stacks.get(0).pop();
            stacks.get(index).push(element);
        }
    }

    public void reverse() throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> stackToReverse = stacks.get(Integer.parseInt(stacks.get(0).pop()));
        Stack<String> s1 = new ArrayDeque<>();
        Stack<String> s2 = new ArrayDeque<>();
        while (!stackToReverse.isEmpty())
            s1.push(stackToReverse.pop());
        while (!s1.isEmpty())
            s2.push(s1.pop());
        while (!s2.isEmpty())
            stackToReverse.push(s2.pop());
    }

    public void fun(Scanner sc) throws CollectionException {
        if (stacks.get(0).isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        Stack<String> s = new ArrayDeque<>();
        Stack<String> s1 = new ArrayDeque<>();
        s.push(stacks.get(0).pop());
        s1.push(stacks.get(0).pop());
        for (int i = 0; i < Integer.parseInt(s1.top()); i++)
            stacks.get(Integer.parseInt(s.top())).push(sc.next());
    }



    @SuppressWarnings({"EnhancedSwitchMigration"})
    public void execute(String command) throws CollectionException {
        if (command.startsWith("?")) {
            if (question()) {
                command = command.substring(1);
                switch (command) {
                    case "echo": echo();break;
                    case "pop": _pop();break;
                    case "dup": dup();break;
                    case "dup2": dup2();break;
                    case "swap": swap();break;
                    case "char": _char();break;
                    case "even": even();break;
                    case "odd": odd();break;
                    case "!": factorial();break;
                    case "len": len();break;
                    case "<>": checkDifferent();break;
                    case "<": checkLower();break;
                    case "<=": checkLowerEqual();break;
                    case "==": checkEqual(); break;
                    case ">": checkHigher(); break;
                    case ">=": checkHigherEqual(); break;
                    case "+": add(); break;
                    case "-": subtract(); break;
                    case "*": multiply(); break;
                    case "/": divide(); break;
                    case "%": remainder(); break;
                    case ".": combine(); break;
                    case "rnd": random(); break;
                    case "then": then(); break;
                    case "else": _else(); break;
                    case "print": print(); break;
                    case "clear": clear(); break;
                    case "run": run(); break;
                    case "loop": loop(); break;
                    case "move": move(); break;
                    case "reverse": reverse(); break;
                    default: stacks.get(0).push(command);
                }
            }
        } else {
            switch (command) {
                case "echo": echo();break;
                case "pop": _pop();break;
                case "dup": dup();break;
                case "dup2": dup2();break;
                case "swap": swap();break;
                case "char": _char();break;
                case "even": even();break;
                case "odd": odd();break;
                case "!": factorial();break;
                case "len": len();break;
                case "<>": checkDifferent();break;
                case "<": checkLower();break;
                case "<=": checkLowerEqual();break;
                case "==": checkEqual(); break;
                case ">": checkHigher(); break;
                case ">=": checkHigherEqual(); break;
                case "+": add(); break;
                case "-": subtract(); break;
                case "*": multiply(); break;
                case "/": divide(); break;
                case "%": remainder(); break;
                case ".": combine(); break;
                case "rnd": random(); break;
                case "then": then(); break;
                case "else": _else(); break;
                case "print": print(); break;
                case "clear": clear(); break;
                case "run": run(); break;
                case "loop": loop(); break;
                case "move": move(); break;
                case "reverse": reverse(); break;
                default: stacks.get(0).push(command);
            }
        }
    }
}








public class Naloga1 {
    public static void main(String[] args) throws CollectionException {
        String vrstica, element;
        Scanner sc_v, sc_n;
        sc_v = new Scanner(System.in);
        while (sc_v.hasNextLine()) {
            Calculator c = new Calculator();
            vrstica = sc_v.nextLine();
            sc_n = new Scanner(vrstica);
            while (sc_n.hasNext()) {
                element = sc_n.next();
                if (element.equals("fun")){
                    c.fun(sc_n);
                } else if (element.equals("?fun")) {
                    if (c.question())
                        c.fun(sc_n);
                } else c.execute(element);
            }
        }
        sc_v.close();
    }
}
