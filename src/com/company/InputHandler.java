package com.company;

import java.awt.event.*;
import java.awt.Component;
import java.util.ArrayList;

public class InputHandler implements KeyListener
{
    private ArrayList<Integer> stack = new ArrayList<Integer>();
    boolean inStack = false;
    private boolean [] keys = new boolean[256];

    //adds new listener to component
    public InputHandler(Component c)
    {
        c.addKeyListener(this);
    }
    //returns if a key is down and returns the keyCode if it is
    public boolean isKeyDown(int keyCode)
    {
        if (keyCode > 0 && keyCode <256)
            return keys[keyCode];
        else
            return false;
    }

    public void keyPressed(KeyEvent e)                  // Sets the index of the key pressed's keyCode to true
    {                                                   // adds the current key pressed's keyCode to the stack
        if(e.getKeyCode() > 0 && e.getKeyCode() < 256)
        {
            keys[e.getKeyCode()] = true;
            addStack(e.getKeyCode());
        }
    }

    public void keyReleased(KeyEvent e)                 //Sets the index of the key released's keyCode to false
    {                                                   //removes any key released from the stack
        if(e.getKeyCode() > 0 && e.getKeyCode() < 256)
        {
            keys[e.getKeyCode()] = false;
            removeStack(e.getKeyCode());
        }
    }
    //Empty
    public void keyTyped(KeyEvent e) {}


    public void addStack(int x)                         //If the stack size is 0 it just adds the integer to the arraylist
    {                                                   //Otherwise it scans through the list to see if it already exists
        if (stack.size() == 0)                          //If it does exist the element is not added
            stack.add(x);
        else
        {
            for(int i = stack.size() - 1; i >= 0; i--)
            {
                if(stack.get(i) == x)
                    inStack = true;
            }
            if (!inStack)
                stack.add(x);
        }
    }

    public void removeStack(int x)                      //Searches through the stack and removes the element that matches the parameter value
    {
        for(int i = stack.size() - 1; i >= 0; i--)
        {
            if(stack.get(i)== x)
                stack.remove(i);
        }

    }
    //returns an element at a specific index of stack
    public int getIndex(int a)
    {
        return stack.get(a);
    }
    //returns the size of the stack
    public int getSize()
    {
        return stack.size();
    }


}
