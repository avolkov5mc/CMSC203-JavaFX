/*
Class: CMSC203 CRN 30339
Program: Assignment #4
Instructor: Grigoriy Grinberg
Summary of Description: Calculates and stores information about plots of land and properties.
Due Date: 4/1/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Alexei Volkov
*/

package CMSC203_Assignment4;

public class Plot {

    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot(){
        x = 0;
        y = 0;
        width = 1;
        depth = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    public boolean encompasses(Plot plot){
        return (plot.x + plot.width) <= (this.x + this.width) && plot.x >= this.x && plot.y >= this.y && (plot.y + plot.depth) <= (this.y + this.depth);
    }

    public boolean overlaps(Plot plot){
        return this.x < (plot.x + plot.width) && (this.x + this.width) > plot.x && this.y < (plot.y + plot.depth) && (this.y + this.depth) > plot.y;
    }

    public String toString(){
        return x+","+y+","+width+","+depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
