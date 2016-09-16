//alternative lab instructor: tug13683
public class Lab1{
    public static void main(String args[]){
        //testing for first algorithm
        for (int i = 1; i <= 100; i++){
            MyPow.countGbl = 0;
            double product = raise(2.0, i);
            System.out.println("Product: " + product + " Count: " + MyPow.countGbl);
        }

        //testing for second algorithm
        for (int j = 1; j <= 100; j++){
            MyPow.countGbl = 0;
            double product = raise2(2.0, j);
            System.out.println("Product: " + product + " Count: " + MyPow.countGbl);
        }
    }

    //first algorithm
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
        if (exp % 2 == 0){
            MyPow.countGbl++;
            return raise(base, exp/2) * raise(base, exp/2);
        }
        //odd
        else{
            MyPow.countGbl += 2; 
            return raise(base, exp/2) * raise(base, exp/2) * base;
        }
    }
    
    //second algorithm
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
        MyPow.countGbl++;
        if (exp % 2 == 1){
            retval *= base; //count this multiply as explained later
            MyPow.countGbl++;
        }
        return retval;
    }
}

class MyPow{
    public static int countGbl = 0;
}
