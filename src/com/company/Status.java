package com.company;

public enum Status
{
    WALKING(0x0),
    IDLE(0x1);

    private byte status;

    Status(int status)
    {
        this.status = (byte)status;
    }

    public void setStatus(int status)
    {
        this.status = (byte)status;
    }

    public byte getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        return (status == 0x0) ? ("WALKING")
              :("IDLE");
    }
}