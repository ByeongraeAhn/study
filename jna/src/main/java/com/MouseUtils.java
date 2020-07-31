package com;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.LONG;
import com.sun.jna.platform.win32.WinUser.INPUT;
import com.sun.jna.win32.StdCallLibrary;

public class MouseUtils {
   public interface User32 extends StdCallLibrary {
      public static final long MOUSEEVENTF_MOVE = 0x0001L;
      public static final long MOUSEEVENTF_VIRTUALDESK = 0x4000L;
      public static final long MOUSEEVENTF_ABSOLUTE = 0x8000L;

      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      // User32 INSTANCE = (User32) Native.loadLibrary("testtest", User32.class);

      DWORD SendInput(DWORD dWord, INPUT[] input, int cbSize);

      public static final int SM_CXSCREEN = 0x0;
      public static final int SM_CYSCREEN = 0x1;

      int GetSystemMetrics(int index);
   }

   public static void main(String[] args) {
      INPUT input = new INPUT();
      input.type = new DWORD(INPUT.INPUT_MOUSE);

      input.input.setType("mi");
      input.input.mi.dx = new LONG(500 * 65536 / User32.INSTANCE.GetSystemMetrics(User32.SM_CXSCREEN));
      input.input.mi.dy = new LONG(500 * 65536 / User32.INSTANCE.GetSystemMetrics(User32.SM_CYSCREEN));
      input.input.mi.mouseData = new DWORD(0);
      input.input.mi.dwFlags = new DWORD(
            User32.MOUSEEVENTF_MOVE | User32.MOUSEEVENTF_VIRTUALDESK | User32.MOUSEEVENTF_ABSOLUTE);
      // input.input.mi.dwFlags = new DWORD(0x8000L);
      input.input.mi.time = new DWORD(0);

      INPUT[] inArray = { input };

      int cbSize = input.size(); // mouse input struct size
      DWORD nInputs = new DWORD(1); // number of inputs
      DWORD result = User32.INSTANCE.SendInput(nInputs, inArray, cbSize);
      System.out.println("result: " + result); // return 1 if the 1 event successfully inserted
   }
}