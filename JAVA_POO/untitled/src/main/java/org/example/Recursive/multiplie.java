package org.example.Recursive;

public class multiplie {

    public static int multi(int x,int y){
        if (y != 0) {
            return (x + multi(x, y - 1));
        } else {
            return 0;
        }

    }

}
