## My Java Style Guide

This document describes the format of my java classes.

```java
// PACKAGE DECLERATION
package default;

// CLASS DECLERATION
public class Pseudo
{
    // PUBLIC STATIC MEMBERS
    public static final int CONST = 0;
    // PRIVATE STATIC MEMBERS
    private static final int N_CONST = 0;

    // STATIC FUNCTIONS
    public static void staticFoo() {}

    // PUBLIC MEMBERS
    // PROTECTED MEMBERS
    // PRIVATE MEMBERS
    private Object obj;

    // CONSTRUCTORS
    public Pseudo() {}

    // OVERRIDES
    @Override
    public String toString() {}

    // PUBLIC FUNCTIONS
    public void foo() {}

    // PRIVATE FUNCTIONS
    private void bar() {}

    // Mutators, accessors and other classes will always be at the bottom of my files.
    // MUTATORS
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    // ACCESSORS
    public Object getObj() 
    {
        return this.obj;
    }

    class Node {}
    enum NodeType {}
}
```
