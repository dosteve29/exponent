//alternative lab instructor: tug13683
public class Lab1{
    public static void main(String args[]){
        
    }

    public static double raise(double base, int exp){
        if (base == 0.0 && exp < 0){ //zero to negative power returns infinity
            return Double.POSITIVE_INFINITY;
        }
        else if (base == 0.0 && exp >= 0){ //zero to whole numbers returns zero
            return 0.0;
        }
        else if (exp == 1){ //anything raised to power of 1 returns base
            return base;
        }
        else { //actual exponential calculation
            return base + exp;
        }
    }
}
