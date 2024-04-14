package CMSC203_Assignment5;

/*
Class: CMSC203 CRN 30339
Program: Assignment #5
Instructor: Grigoriy Grinberg
Summary of Description: Calculates holiday bonuses from a two dimensional ragged array of doubles
Due Date: 4/15/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Alexei Volkov
*/
public class HolidayBonus {

    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double DEFAULT_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] data){
        double[] bonuses = new double[data.length];
        for(int store = 0; store < data.length; store++){
            for(int item = 0; item < data[store].length; item++){
                int lowest = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, item);
                int highest = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, item);
                if(store == lowest){
                    bonuses[store] += LOWEST_BONUS;
                }
                else if(store == highest){
                    bonuses[store] += HIGHEST_BONUS;
                }
                else{
                    bonuses[store] += DEFAULT_BONUS;
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data){
        double[] bonuses = calculateHolidayBonus(data);
        double sum = 0.0;
        for(int i = 0; i < bonuses.length; i++){
            sum += bonuses[i];
        }
        return sum;
    }
}
