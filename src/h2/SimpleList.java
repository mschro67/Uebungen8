//by mschro67

package h2;

public class SimpleList{
    Node head;
    Node[] content=new Node[0];

    public SimpleList(Node head){
        this.head=head;
    }

    public Node get(int index){
        try {
            if (this.content.length == 0) {
                return null;
            } else {
                Node result = new Node(this.content[index].value);
                try {
                    result.next = new Node(this.content[index + 1].value);
                } catch (Exception e) {
                    result.next = null;
                }
                return result;
            }
        }catch (Exception e){
            return this.content[index];
        }
    }

    public Node getFirst(){
        return this.get(0);
    }

    public Node getLast(){
        return this.get(this.content.length-1);
    }

    public int getValue(int index){
        return get(index).value;
    }

    public void append(int newValue){
        if (this.content.length>0) {
            Node[] copy = new Node[this.content.length + 1];
            for (int x = 0; x < this.content.length; x++) {
                copy[x] = this.get(x);
            }
            copy[this.content.length] = new Node(newValue);
            this.content = copy;
        }else {
            this.content = new Node[1];
            this.content[0] = new Node(newValue);
        }
    }

    public Node findFirst(){
        if (this.content.length>0){
            return this.get(0);
        }else{
            return null;
        }
    }

    public boolean insertAfter(int preValue,int newValue){
        boolean result=false;
        for (int x=0;x<this.content.length;x++){
            if (getValue(x)==preValue){
                Node[] copy=new Node[this.content.length+1];
                for (int y=0;y<content.length;y++){
                    if (result){
                        copy[y]=new Node(this.content[y-1].value);
                    }else{
                        copy[y] = this.get(y);
                    }
                }
                copy[x+1]=new Node(newValue);
                this.content=copy;
                break;
            }
        }
        return result;
    }

    public void delete(int a){
        Node[] copy=new Node[this.content.length-1];
        for (int x=0;x<copy.length;x++) {
            if (x > a) {
                copy[x] = new Node(this.content[x+1].value);
            } else if (x < a) {
                copy[x] = new Node(this.content[x].value);
            }
        }
        copy[a]=new Node(this.content[a+1].value);
        this.content=copy;
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
