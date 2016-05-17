package com.company;

/*
    Combination of 2/3 states that dictate how an object should look
    This class is used as the key for sprites, which maps each objectState to an image
 */
class ObjectState implements Constants
{
    private int direction = front;
    private int animationStep = 0;
    private int status = idle;

    ObjectState(int direction, int animationStep)
    {
        this.direction = direction;
        this.animationStep = animationStep;
    }

    int getDirection()
    {
        return direction;
    }

    void setDirection(int direction)
    {
        this.direction = direction;
    }

    public int getAnimationStep()
    {
        return animationStep;
    }

    void setAnimationStep(int animationStep)
    {
        this.animationStep = animationStep;
    }

    int getStatus()
    {
        return status;
    }

    void setStatus(int status)
    {
        this.status = status;
    }

    public String toString()
    {
        return ((direction == front) ? "F" : (direction == right) ? "R" : (direction == left)  ? "L" : "B")
             + (Integer.toString(animationStep));
    }


    //Here, the status int is ignored for equality
    //This allows the hashmap to get the same image for different statuses
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ObjectState that = (ObjectState) o;

        return direction == that.direction && animationStep == that.animationStep;
    }

    //Same deal here as with equals
    @Override
    public int hashCode()
    {
        int result = direction;
        result = 31 * result + animationStep;
        return result;
    }
}
