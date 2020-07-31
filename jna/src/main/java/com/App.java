package com;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class App {

    public interface MyUser32 extends Library {

        public int MessageBoxA(int handle, String message, String title, int type);
    }

    public static void main(String[] args) {

        String mytext = "Hello World!";
        String mytitle = "Title bar";
        String libName = "c";

        if (System.getProperty("os.name").contains("Windows")) {
            libName = "user32";
        }

        MyUser32 user32 = (MyUser32) Native.loadLibrary(libName, MyUser32.class);
        user32.MessageBoxA(0, mytext, mytitle, 0);
    }
}