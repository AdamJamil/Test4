package com.company;

public enum WalkingStatus
{
    B0(0x0),
    B1(0x1),
    B2(0x2),
    R0(0x3),
    R1(0x4),
    R2(0x5),
    F0(0x6),
    F1(0x7),
    F2(0x8),
    L0(0x9),
    L1(0xA),
    L2(0xB);

    public final byte status;

    WalkingStatus(int val)
    {
        this.status = (byte)val;
    }
}