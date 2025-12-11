//by mschro67

package h2;

public class h2_main {
    public static void main(String[] args) {
        SimpleList test = new SimpleList(new Node(0));
        test.append(5);
        test.append(6);
        test.append(7);
        test.append(8);
        System.out.println(test.toString()+" "+test.content.length);
        test.insertAfter(6,3);
        test.append(5);
        System.out.println(test.toString()+" "+test.content.length);
        test.delete(5);
        System.out.println(test.toString()+" "+test.content.length);
    }
}