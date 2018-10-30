package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double v, v1;
    private boolean b, b1;

    public Interval(double v, double v1, boolean b, boolean b1) {
        if(v>v1)throw new IllegalArgumentException("prvi broj veci od drugog");

            this.v=v; this.v1=v1; this.b=b; this.b1=b1;
    }

    public Interval() {
        this.v=0; this.v1=0; this.b=false; this.b1=false;
    }

    public static Interval intersect(Interval i, Interval i2) {

        double novov=0,novov1=0;
        boolean novob=false,novob1=false;
        if(i.v > i2.v){
            novov=i.v;
            if(i2.b==true)novob=true; else novob=false;
        }

        if(i.v==i2.v){
            if(i.b==true)novob=true; else novob=false;
            novov=i.v;
        }

        if(i.v < i2.v) {
            novov=i2.v;
            if(i2.b==true)novob=true; else novob=false;
        }

        if(i.v1 > i2.v1){
            novov1=i2.v1;
            if(i2.b1==true)novob1=true; else novob1=false;
        }

        if(i.v1==i2.v1){
            novob1=true;
            novov1=i.v1;
        }

        if(i.v1 < i2.v1) {
            novov1=i.v1;
            if(i.b1==true)novob1=true; else novob1=false;
        }

        return new Interval(novov,novov1,novob,novob1);
    }

    public String toString() {
        String s= new String("");
        if(this.b==true)s+="[";
        else s+="(";
        s+=this.v+","+this.v1;
        if(this.b1==true)s+="]";
        else s+=")";
        return s;
    }

    public boolean isIn(double v) {
        if(  (this.v==v && this.b==true) ||   (this.v<v && this.v1>v  ) || (this.v==v1 && this.b1==true) ) return true;
        return false;
    }

    public boolean isNull() {
        if (this.v==0 && this.v1==0 && this.b==false && this.b1==false) return true;
return false;
    }

    public boolean equals(Interval i2) {
        if(this.v==i2.v && this.v1==i2.v1 && this.b==i2.b && this.b1==i2.b1) return true;
        return false;
    }


    public Interval intersect(Interval interval) {

        double novov=0,novov1=0;
        boolean novob=false,novob1=false;
       if(this.v > interval.v){
           novov=this.v;
          if(interval.b==true)novob=true; else novob=false;
       }

       if(this.v==interval.v){
           if(this.b==true)novob=true; else novob=false;
           novov=this.v;
       }

        if(this.v < interval.v) {
            novov=interval.v;
            if(interval.b==true)novob=true; else novob=false;
        }

        if(this.v1 > interval.v1){
            novov1=interval.v1;
            if(interval.b1==true)novob1=true; else novob1=false;
        }

        if(this.v1==interval.v1){
            novob1=true;
            novov1=this.v1;
        }

        if(this.v1 < interval.v1) {
            novov1=this.v1;
            if(this.b1==true)novob1=true; else novob1=false;
        }

     return new Interval(novov,novov1,novob,novob1);

    }
}
