package generics;

public class WildCardNeedDemo {
 public static void main(String[] args ) {
   GenericStack<Integer> intStack = new GenericStack<>();
   intStack.push(1); // 1 is autoboxed into new Integer(1)
   intStack.push(2);
   intStack.push(-2);

   System.out.print("The max number is " + max(intStack)); // Error: 
 }

 /** Find the maximum in a stack of numbers */
 public static double max(GenericStack<Integer> intStack) {
   double max = intStack.pop().doubleValue(); // initialize max

   while (!intStack.isEmpty()) {
     double value = intStack.pop().doubleValue();
     if (value > max)
       max = value;
   }

   return max;
 }
}