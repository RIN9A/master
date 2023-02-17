public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, " + args[0]);
        String arg = args[1];
        String arg1 = args[2];
        double x = Double.parseDouble(arg);
        double y = Double.parseDouble(arg1);
        double otv = (3 * Math.cos(x - Math.PI/6)*Math.cos(x - Math.PI/6))/ (0.5 + Math.sin(y*y)) ;
        System.out.println(otv);



    }
}