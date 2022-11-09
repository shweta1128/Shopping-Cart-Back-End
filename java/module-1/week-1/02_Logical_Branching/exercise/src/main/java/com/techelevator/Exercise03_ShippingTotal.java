package com.techelevator;

public class Exercise03_ShippingTotal {

    /*
    Scamper Shipping Company specializes in small, local deliveries.
    The problems below ask you to implement the logic to calculate a shipping amount for a package.
     */

    // You can use these constants in your solutions.
    private final int MAX_WEIGHT_POUNDS = 40;
    private final double UP_TO_40_LB_RATE = 0.50;
    private final double OVER_40_LB_RATE = 0.75;



    /*
    Scamper Shipping Company charges $0.50 per pound up to 40 pounds. After that, it's $0.75 for each additional pound.
    Implement the logic needed to calculate the shipping rate when provided a weight in pounds.

    Examples:
    calculateShippingTotal(10) ➔ 5.0
    calculateShippingTotal(25) ➔ 12.5
    calculateShippingTotal(45) ➔ 23.75
     */
    public double calculateShippingTotal(int weightPounds) {
        double totalShippingCost;

        if (weightPounds <= MAX_WEIGHT_POUNDS) {
           return weightPounds * UP_TO_40_LB_RATE;

        } else  {
             totalShippingCost = MAX_WEIGHT_POUNDS * UP_TO_40_LB_RATE;
            return totalShippingCost + ( (weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE);
        }


    }








    /*
    Scamper Shipping Company now allows customers to provide a discount code to give them 10% off of their order.
    Implement the logic to calculate the correct shipping rate when provided a weight in pounds and a boolean value for hasDiscount.

    Examples:
    calculateShippingTotal(10, false) ➔ 5.0
    calculateShippingTotal(10, true) ➔ 4.5
    calculateShippingTotal(25, false) ➔ 12.5
    calculateShippingTotal(25, true) ➔ 11.25
    calculateShippingTotal(45, false) ➔ 23.75
    calculateShippingTotal(45, true) ➔ 21.375
     */
    public double calculateShippingTotal(int weightPounds, boolean hasDiscount) {
        double totalShippingCost;
        double TOTAL_DISCOUNT = 0.1;
        double total;

          if (weightPounds <= MAX_WEIGHT_POUNDS  ) {
            total =  weightPounds * UP_TO_40_LB_RATE;

        } else  {
            totalShippingCost = MAX_WEIGHT_POUNDS * UP_TO_40_LB_RATE;
          total = totalShippingCost + ( (weightPounds - MAX_WEIGHT_POUNDS) * OVER_40_LB_RATE);
        }
         if ( hasDiscount) {
             total = total - ( total * TOTAL_DISCOUNT);

         }
         return total;
    }

    /*
    As the business grows for Scamper Shipping Company, they now offer discounts in various amounts.
    Implement the logic to calculate the shipping rate when provided a weight in pounds
    and a discount percentage (for example, 0.1 = 10% off).

    Examples:
    calculateShippingTotal(10, 0) ➔ 5.0
    calculateShippingTotal(10, 0.1) ➔ 4.5
    calculateShippingTotal(25, 0.15) ➔ 10.625
    calculateShippingTotal(45, 0.2) ➔ 19.0
     */
    public double calculateShippingTotal(int weightPounds, double discountPercentage) {
        double totalShippingCosts;
        double totalShippingUpTo40Lb ;
        double totalShippingAbove40Lb;
        double totalDiscountPercentage;


        if (weightPounds <= 40) {

             totalShippingUpTo40Lb =  weightPounds * 0.50;
             totalDiscountPercentage = 1 - discountPercentage;
             totalShippingCosts = (totalDiscountPercentage * totalShippingUpTo40Lb) ;
             return totalShippingCosts;

        } else {
            totalShippingUpTo40Lb =  40 * 0.50;
            totalShippingAbove40Lb = ((weightPounds - 40) * 0.75);
            totalDiscountPercentage = 1 - discountPercentage;
            totalShippingCosts = totalDiscountPercentage * (totalShippingUpTo40Lb + totalShippingAbove40Lb);
            return totalShippingCosts;


        }



    }
}
