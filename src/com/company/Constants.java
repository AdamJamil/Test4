package com.company;

interface Constants
{
    int tileSize = 64;
    int width = 21;
    int height = 11;
    int pixelWidth = tileSize * width;
    int pixelHeight = tileSize * height;
    int noAction = -1;
    int back = 0;
    int right = 1;
    int front = 2;
    int left = 3;
    int refresh = 4;
    int idle = 0;
    int walking = 1;
    int firstTickToBuffer = 48;
}
