import java.util.Stack;

public class StackPushPop {

    static void prepisi(Stack s, Stack s1){
        while (!s.empty())
            s1.push(s.pop());
    }

    static void obrni(Stack s, int n, int m){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        prepisi(s, s1);
        for (int i = 0; i < n; i++)
            s.push(s1.pop());
        for (int i = n; i <= m; i++)
            s2.push(s1.pop());
        int dolzinaS2 = s2.size();
        for (int i = 0; i < dolzinaS2; i++)
            s.push(s2.pop());
        int dolzinaS1 = s1.size();
        for (int i = 0; i < dolzinaS1; i++)
            s.push(s1.pop());
    }

    static void pogrezni(Stack s, int n, int m){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        prepisi(s, s1);
        for (int i = 0; i < n; i++)
            s2.push(s1.pop());
        prepisi(s2, s3);
        for (int i = 0; i < m; i++)
            s.push(s1.pop());
        while (!s3.empty())
            s.push(s3.pop());
        while (!s1.empty())
            s.push(s1.pop());
    }

    public static class Main {
        public static void main(String[] args) {
            Stack<Integer> s = new Stack<>();
            for (int i = 1; i <= 10; i++)
                s.push(i);
            System.out.println(s);
//            obrni(s, 2,3);
            pogrezni(s, 3, 1);
            System.out.println(s);
        }
    }
}