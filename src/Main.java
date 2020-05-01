import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
 // GUI cwiczenia so0168 T Tatarski
    public static void main(String[] args) {
/*
     dostarczony string do obliczenia w formacie: operand [spacja] operator [spacja] operand
 */
        Calc calc = new Calc();
        String wynik = calc.doCalc("2 * 33");
        System.out.println(wynik);
    }
}
interface Calculable{
    int Calc(int x, int y);
}
class Calc{
    int x;
    int y;

    String doCalc(String cs) {
        Map<String,Calculable> cc= new HashMap<>();
        cc.put("+", new AddCalc());
        cc.put("-", new MinCalc());
        cc.put("*", new MulCalc());
        cc.put("/", new DivCalc());

        StringTokenizer stringTokenizer = new StringTokenizer(cs);
        int result=0;
        try {
            String x,y,z;
             x = stringTokenizer.nextToken();
             z = stringTokenizer.nextToken();
             y = stringTokenizer.nextToken();
            result = (cc.get(z).Calc(Integer.valueOf(x),Integer.valueOf(y)));

        }catch (Exception e){
            System.out.println("Podaj prawidłowe diziałanie arytmetyczne do wykonania");
        }

        return String.valueOf(result);
    }
}
class AddCalc extends Calc implements Calculable{
    @Override
    public int Calc(int x, int y) {
        return x+y;
    }

}
class MinCalc extends Calc implements Calculable{
    @Override
    public int Calc(int x, int y) {
        return x-y;
    }

}
class MulCalc extends Calc implements Calculable{
    @Override
    public int Calc(int x, int y) {
        return x*y;
    }

}
class DivCalc extends Calc implements Calculable{
    @Override
    public int Calc(int x, int y) {
        try {
            return x / y;
        }catch (ArithmeticException e){
            System.err.println("podaj prawidlowe dzialanie >> wystąpiło dzielenie przez zero");
        }return 0;
    }
}