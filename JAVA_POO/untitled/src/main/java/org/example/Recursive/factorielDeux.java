package org.example.Recursive;

public class factorielDeux {
    public static int multi(int x,int y){
        if (y != 0) {
            System.out.println(y + " x " + x + " = " +(x*y));
            return (x + multi(x, y - 1));
        } else {
            return 0;
        }

    }
}
