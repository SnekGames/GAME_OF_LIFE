package default_GOL.tools;

/**
 * Created by Viktor on 2017-04-28.
 */
import java.util.ArrayList;

public class GridArray<T> extends ArrayList<ArrayList<T>> {
    //public void setObject(int index1, T element) {
    //    while (index1 >= this.size()) {
    //        this.setObject(new ArrayList<T>());
    //    }
    //    this.getObject(index1).setObject(element);
    //}

    public void setObject(int indexM, int indexN, T element) {
        while (indexM >= this.size()) {
            this.add(new ArrayList<T>());
        }

        ArrayList<T> inner = this.get(indexM);
        while (indexN >= inner.size()) {
            inner.add(null);
        }

        inner.set(indexN, element);
    }

    public Object getObject(int indexM, int indexN) {
        if (indexM >= this.size()) {
            //this.setObject(new ArrayList<T>());
            System.out.println("ERROR INDEX OUT OF BOUNDS");
            System.exit(-1);
        }
        else {
            ArrayList<T> inner = this.get(indexM);
            if (indexN >= inner.size()) {
                //inner.setObject(null);
                System.out.println("ERROR INDEX OUT OF BOUNDS");
                System.exit(-1);
            }
            else{
                // index(m,n) exists, getObject the object
                return inner.get(indexN);
            }
        }

        return "ERROR INDEX OUT OF BOUNDS";
    }

    public int getM_rows(){
        int m = 0;

        while (m < this.size()) {
            m ++;
        }
        return m;
    }

    public int getN_columns(){
        int m = 0;
        int n = 0;

        while (m < this.size()) {
            m ++;
        }

        ArrayList<T> inner = this.get(m-1);
        while (n < inner.size()) {
            n++;
        }

        return n;
    }
}
