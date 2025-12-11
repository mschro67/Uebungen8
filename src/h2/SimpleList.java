//by mschro67

package h2;

public class SimpleList{
    Node head;
    Node[] content=new Node[0];

    public SimpleList(Node head){
        this.head=head;
    }

    public int length(){
        return this.content.length;
    }

    private void reload(){
        this.content[this.length()-1].next=null;
        if (this.length()>1) {
            for (int x = this.length() - 2; x >= 0; x--) {
                this.content[x].next = get(x + 1);
            }
        }
        this.head=getFirst();
    }

    public Node get(int index){
        if (this.length() == 0) {
        return new Node(Integer.MIN_VALUE);
        }else{
            Node result = new Node(this.content[index].value);
            try {
                result.next = new Node(this.content[index + 1].value);
            }catch (Exception e){
                result.next = null;
            }
            return result;
        }
    }

    public Node getFirst(){
        return this.get(0);
    }

    public Node getLast(){
        return this.get(this.length()-1);
    }

    public int getValue(int index){
        return get(index).value;
    }

    public void append(int newValue){
        if (this.content.length>0) {
            Node[] copy = new Node[this.length() + 1];
            for (int x = 0; x < this.length(); x++) {
                copy[x] = this.get(x);
            }
            copy[this.length()] = new Node(newValue);
            this.content = copy;
            this.reload();
        }else{
            this.content = new Node[1];
            this.content[0] = new Node(newValue);
            this.reload();
        }
    }

    public Node findFirst(int value){
        if (this.length()>0){
            for (int y=0;y<this.length();y++){
                if (this.getValue(y)==value){
                    return new Node(y);
                }
            }
        }
        return null;
    }

    public boolean insertAfter(int preValue,int newValue){
        boolean result=false;
        SimpleList copy=new SimpleList(null);
        for (int z=0;z<findFirst(preValue).value+1;z++){
            copy.append(getValue(z));
        }
        copy.append(newValue);
        for (int z=findFirst(preValue).value+1;z<this.length();z++){
            copy.append(getValue(z));
        }
        this.content=new Node[copy.length()];
        for (int x=0;x<copy.length();x++){
            this.content[x]=copy.get(x);
        }
        this.reload();
        return result;
    }

    public void delete(int a){
        SimpleList copy=new SimpleList(null);
        for (int z=0;z<findFirst(a).value;z++){
            copy.append(getValue(z));
        }
        for (int z=findFirst(a).value+1;z<this.length();z++){
            copy.append(getValue(z));
        }
        this.content=new Node[this.length()-1];
        for (int x=0;x<copy.length();x++){
            this.content[x]=copy.get(x);
        }
        this.reload();
    }

    public String toString(){
        String result="[";
        for (int x=0;x<this.content.length;x++) {
            try {
                result += this.getValue(x);
            }catch (Exception e){
                result+="null";
            }
            if (!(x == this.content.length - 1)) {
                result += ",";
            }
        }
        result+="]";
        return result;
    }
}