//alternative lab instructor: tug13683
public class Lab1{
    public static void main(String args[]){
        for (int i = 1; i <= 100; i++){
            MyPow.countGbl = 0;
            System.out.println("Product (raise): " + raise2(2.0, i));
            System.out.println("Count: " + MyPow.countGbl);
        }
        
        for (int i = 1; i <= 100; i++){
            MyPow.countGbl = 0;
            System.out.println("Product (raise2): " + raise2(2.0, i));
            System.out.println("Count: " + MyPow.countGbl);
        }
    }

    //not the best solution
    public static double raise(double base, int exp){
        //zero to negative power returns infinity
        if (base == 0.0 && exp < 0){ 
            return Double.POSITIVE_INFINITY;
        }
        //zero to whole numbers returns zero
        else if (base == 0.0 && exp >= 0){ 
            return 0.0;
        }
        //anything raised to power of 1 returns base
        else if (exp == 1){ 
            return base;
        }
        
        //fixing negative exponents
        if (base != 0.0 && exp < 0){
            base = 1.0 / base;
            exp = -exp;
        }

        //even
        if (exp % 2 == 0)
            return raise(base, exp/2) * raise(base, exp/2);
        //odd
        else
            return raise(base, exp/2) * raise(base, exp/2) * base;
    }
    
    public static double raise2(double base, int exp){
        double temp = 0.0;
        double retval = 0.0;
        //zero to negative power returns infinity
        if (base == 0.0 && exp < 0){ 
            return Double.POSITIVE_INFINITY;
        }
        //zero to whole numbers returns zero
        else if (base == 0.0 && exp >= 0){ 
            return 0.0;
        }
        //anything raised to power of 1 returns base
        else if (exp == 1){ 
            return base;
        }
        
        //fixing negative exponents
        if (base != 0.0 && exp < 0){
            base = 1.0 / base;
            exp = -exp;
        }
        temp = raise2(base, exp / 2);
        retval = temp * temp; //count this multiply as explained later
        if (exp % 2 == 1){
            retval *= base; //count this multiply as explained later
        }
        return retval;
    }
}

class MyPow{
    public static int countGbl = 0;
}
