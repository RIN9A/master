import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0]);
        String variant = args[1];
        System.out.println(variant);
        ArrayList<Double> mas = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            mas.add(Double.valueOf(args[i]));
            System.out.print(args[i] + " ");
        }
        System.out.println();
        switch (variant) {
            case "V1", "v1", "1" -> System.out.println(v1(mas));
            case "V2", "v2", "2" -> System.out.println(v2(mas));
            case "V3", "v3", "3" -> System.out.println(v3(mas));
            case "V4", "v4", "4" -> System.out.println(v4(mas));
            case "V5", "v5", "5" -> System.out.println(v5(mas));
            case "V6", "v6", "6" -> System.out.println(v6(mas));
            case "V7", "v7", "7" -> System.out.println(v7(mas));
        }







    }
    public static Double v1(ArrayList<Double> mas){
        Double a = mas.get(0);
        Double b = mas.get(1);
        Double c = mas.get(2);
        Double n = mas.get(3);
        Double x = mas.get(4);


        return (5.0*Math.pow(a, n*x)/(b+c)) - Math.sqrt(Math.abs(Math.cos(Math.pow(x,3))));



    }
    public static Double v2(ArrayList<Double> mas){
        Double a = mas.get(0);
        Double x = mas.get(1);
        Double y = mas.get(2);
        Double w = mas.get(3);

        return Math.abs(x-y)/Math.pow((1.0 + 2.0*x), a) - Math.exp(Math.sqrt(1.0 + w));

    }
    public static Double v3(ArrayList<Double> mas){
        Double a0 = mas.get(0);
        Double a1 = mas.get(1);
        Double a2 = mas.get(2);
        Double x = mas.get(3);

        return Math.sqrt(a0 + a1*x + a2*Math.cbrt(Math.abs(Math.sin(x))));

    }

    public static Double v4(ArrayList<Double> mas){
        Double a = mas.get(0);
        Double x = mas.get(1);

        return Math.log(Math.abs(Math.pow(a,7)))+Math.atan(Math.pow(x,2)) + Math.PI/Math.sqrt(Math.abs(a+x));

    }

    public static Double v5(ArrayList<Double> mas){
        Double a = mas.get(0);
        Double b = mas.get(1);
        Double c = mas.get(2);
        Double d = mas.get(3);
        Double x = mas.get(4);


        return Math.pow((Math.pow((a+b), 2)/(c+d)), 0.2) + Math.exp(Math.sqrt(x+1.0));



    }

    public static Double v6(ArrayList<Double> mas){
        Double x = mas.get(0);


        return Math.exp((2.0*Math.sin(4.0*x) + Math.pow(Math.cos(x*x), 2))/3.0*x);

    }
    public static Double v7(ArrayList<Double> mas){
        Double x = mas.get(0);


        return ((1+Math.pow(x,2))/(1.0-x) + Math.tan(x)/2.0)/4.0;

    }

}