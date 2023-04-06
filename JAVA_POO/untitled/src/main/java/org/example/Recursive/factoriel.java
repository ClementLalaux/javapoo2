package org.example.Recursive;

public class factoriel {

    public static int multi(int x){
        if (x != 0) {
            return (x * multi(x-1));
        } else {
            return 1;
        }

    }

}
