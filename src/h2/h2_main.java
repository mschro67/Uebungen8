//by mschro67

package h2;

public class h2_main {
    public static void main(String[] args) {
        SimpleList test = new SimpleList(new Node(0));
        test.append(1);
        test.append(2);
        test.append(3);
        System.out.println(test.toString()+" "+test.content.length);
        test.insertAfter(1,-1);
        System.out.println(test.toString()+" "+test.content.length);
        test.delete(1);
        System.out.println(test.toString()+" "+test.content.length);
    }
}