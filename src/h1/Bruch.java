//by mschro67

package h1;

public class Bruch{
    int zaehler,nenner;

    public Bruch(int zaehler,int nenner){
        this.zaehler=zaehler;
        this.nenner=nenner;
    }

    public int ggT(int x,int y){
        int a,b;
        if (x>y){
            a=x;b=y;
        }else{
            a=y;b=x;
        }

        for (int z= Integer.valueOf(a);z>0;z--) {
            if (a%z==0&&b%z==0){
                return Integer.valueOf(z);
            }
        }
        return 0;
    }

    public void shorten(){
        int ggT=ggT(this.nenner,this.zaehler);
        this.nenner/=ggT;
        this.zaehler/=ggT;
    }

    public boolean hasSameValue(Bruch b){
        Bruch a=new Bruch(Integer.valueOf(this.zaehler),Integer.valueOf(this.zaehler));
        a.shorten();
        b.shorten();
        return (a.nenner==b.nenner&&a.zaehler==b.zaehler);
    }
}