/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspam;

/**
 *
 * @author Maheswari
 */

        // TODO code application logic here
import bsh.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
        import java.util.BitSet;
import java.util.List;
import java.util.Set;

public class Webspam {

  public static void main(String args[]) throws IOException {
     BitSet bits1 = new BitSet(16);
     BitSet bits2 = new BitSet(16);
    //  System.out.println(bits1[1]);
     // set some bits
     for(int i=0; i<=25; i++) {
       // if((i%2) == 0)
            bits1.set(i);
       // if((i%5) != 0)
            bits2.set(i);
     }
     System.out.println("Initial pattern in bits1: ");
     System.out.println(bits1);
     System.out.println("\nInitial pattern in bits2: ");
     System.out.println(bits2);

     // AND bits
     bits2.and(bits1);
     System.out.println("\nbits2 AND bits1: ");
     System.out.println(bits2);

     // OR bits
     bits2.or(bits1);
     System.out.println("\nbits2 OR bits1: ");
     System.out.println(bits2);

     // XOR bits
     bits2.xor(bits1);
     System.out.println("\nbits2 XOR bits1: ");
     System.out.println(bits2);
     String[] s={"qw","qwe","hdjk"};
     System.out.println(s);
     
     
      System.out.println("hello");
List<String> dan = Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Orange", "Blue");

boolean contains = dan.contains("Redww");
if(contains)
      System.out.println("present");

String[] st=new String[6];
String y="if(HST_6 <= 2.34292)\n" +
"{   if(HST_5 <= 0.396508)\n" +
"    {   if(HST_6 <= 1.330097)\n" +
"|   |   {   if(HST_2 <= 1)\n" +
"|   |   |   {   if(HST_1 <= 7)\n" +
"|   |   |   |   {   if(HST_6 <= 0.434783)   {System.out.println(\"nonspam\"); }\n" +
"|   |   |   |   |   else    //HST_6 > 0.434783\n" +
"|   |   |   |   |   {   if(HST_2 <= 0) { System.out.println(\"nonspam\"); }\n" +
"|   |   |   |   |   |   else    //HST_2 > 0\n" +
"|   |   |   |   |   |   {   if(HST_4 <= 0.083333) System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   else System.out.println(\"nonspam\"); \n" +
"                        }   \n" +
"|   |   |   |       }\n" +
"                }else    //HST_1 > 7: \n" +
"                    System.out.println(\"nonspam\");\n" +
"|   |   |   }\n" +
"            else    //HST_2 > 1:\n" +
"                System.out.println(\"nonspam\");\n" +
"|   |   }\n" +
"        else      // HST_6 > 1.330097\n" +
"|   |   {   if(HST_1 <= 165)\n" +
"|   |   |   {   if(HST_6 <= 2.098691)\n" +
"|   |   |   |   {   if(HST_4 <= 0.272016)\n" +
"|   |   |   |   |   {   if(HST_6 <= 1.89011)\n" +
"|   |   |   |   |   |   {   if(HST_3 <= 6.165517)  System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   else    //HST_3 > 6.165517\n" +
"|   |   |   |   |   |   |   {   if(HST_3 <= 6.692913)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_4 <= 0.105769)   System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   |   |   else        //HST_4 > 0.105769\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_3 <= 6.319588)    System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"                                    }\n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else    //HST_3 > 6.692913: \n" +
"                                     System.out.println(\"spam\"); \n" +
"                            }\n" +
"|   |   |   |   |   |   }\n" +
"                        else    //HST_6 > 1.89011\n" +
"|   |   |   |   |   |   {   if(HST_5 <= 0.105583)\n" +
"|   |   |   |   |   |   |   {   if(HST_5 <= 0.09305)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_5 <= 0.031205)   System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   |   |   else    //HST_5 > 0.031205\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_6 <= 1.901099)\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_4 <= 0.128205)    System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   |   |   |   |   else   System.out.println(\"nonspam\");  \n" +
"                                        }\n" +
"|   |   |   |   |   |   |   |   |   |   else    //HST_6 > 1.901099: \n" +
"                                            System.out.println(\"nonspam\");  \n" +
"                                    }\n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else        //HST_5 > 0.09305\n" +
"|   |   |   |   |   |   |   |   {   if(HST_2 <= 4) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   else    //HST_2 > 4\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_6 <= 2.018543)\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_1 <= 141) System.out.println(\"undecided\"); \n" +
"|   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   |   |   |   }\n" +
"                                        else    //HST_6 > 2.018543: \n" +
"                                            System.out.println(\"spam\"); \n" +
"                                    }\n" +
"                                }\n" +
"|   |   |   |   |   |   |   }\n" +
"                            else        //HST_5 > 0.105583\n" +
"|   |   |   |   |   |   |   {   if(HST_3 <= 4.892086)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_4 <= 0.00315) System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else    //HST_3 > 4.892086:\n" +
"                                     System.out.println(\"nonspam\");  \n" +
"                            }\n" +
"                        }\n" +
"|   |   |   |   |   }\n" +
"                    else    //HST_4 > 0.272016\n" +
"|   |   |   |   |   {   if(HST_5 <= 0.129295) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   else    //HST_5 > 0.129295\n" +
"|   |   |   |   |   |   {   if(HST_4 <= 0.486653)\n" +
"|   |   |   |   |   |   |   {   if(HST_2 <= 7)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_3 <= 4.661972)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_1 <= 138)     System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else     System.out.println(\"spam\"); \n" +
"                                    }\n" +
"|   |   |   |   |   |   |   |   |   else     System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else    //HST_2 > 7\n" +
"|   |   |   |   |   |   |   |   {   if(HST_1 <= 107)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_1 <= 80)  System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else     System.out.println(\"spam\");\n" +
"                                    }\n" +
"|   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");   \n" +
"                                }\n" +
"|   |   |   |   |   |   |   }\n" +
"                            else        //HST_4 > 0.486653\n" +
"|   |   |   |   |   |   |   {   if(HST_6 <= 1.934049) System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   |   else     System.out.println(\"nonspam\");  \n" +
"                            }\n" +
"                        }\n" +
"                    }\n" +
"|   |   |   |   }\n" +
"                else        //HST_6 > 2.098691\n" +
"|   |   |   |   {   if(HST_2 <= 12)\n" +
"|   |   |   |   |   {   if(HST_1 <= 93) System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   else    //HST_1 > 93\n" +
"|   |   |   |   |   |   {   if(HST_3 <= 5.354515) System.out.println(\"spam\"); \n" +
"|   |   |   |   |   |   |   else    //HST_3 > 5.354515\n" +
"|   |   |   |   |   |   |   {   if(HST_3 <= 5.692946) System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   |   else    //HST_3 > 5.692946\n" +
"|   |   |   |   |   |   |   |   {   if(HST_4 <= 0.72)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_6 <= 2.237589)\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_3 <= 5.996226)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   else     System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   |   |   |   }\n" +
"                                        else  System.out.println(\"spam\");  \n" +
"                                    }\n" +
"|   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\"); \n" +
"                                }\n" +
"                            }\n" +
"                        }\n" +
"|   |   |   |   |   }\n" +
"                    else       //HST_2 > 12: \n" +
"                          System.out.println(\"spam\");  \n" +
"                }\n" +
"|   |   |   }\n" +
"            else        //HST_1 > 165\n" +
"|   |   |   {   if(HST_4 <= 0.001091)\n" +
"|   |   |   |   {   if(HST_2 <= 2)\n" +
"|   |   |   |   |   {   if(HST_5 <= 0.246221)\n" +
"|   |   |   |   |   |   {   if(HST_1 <= 459)\n" +
"|   |   |   |   |   |   |   {   if(HST_3 <= 5.55818) System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   |   else System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   }\n" +
"                            else    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   }\n" +
"                        else    /*HST_5 > 0.246221*/     System.out.println(\"spam\");  \n" +
"|   |   |   |   |   }\n" +
"                    else    /*HST_2 > 2*/    System.out.println(\"nonspam\"); \n" +
"|   |   |   |   }\n" +
"                else        //HST_4 > 0.001091\n" +
"|   |   |   |   {   if(HST_5 <= 0.030327)\n" +
"|   |   |   |   |   {   if(HST_2 <= 9)\n" +
"|   |   |   |   |   |   {   if(HST_3 <= 5.440945)    System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   else System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   }\n" +
"                        else    /*HST_2 > 9*/    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   }\n" +
"                    else    //HST_5 > 0.030327\n" +
"|   |   |   |   |   {   if(HST_3 <= 5.552381)    System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   else        //HST_3 > 5.552381\n" +
"|   |   |   |   |   |   {   if(HST_5 <= 0.064121)\n" +
"|   |   |   |   |   |   |   {   if(HST_6 <= 2.104828)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_6 <= 1.846154)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_3 <= 5.972683) System.out.println(\"undecided\"); \n" +
"|   |   |   |   |   |   |   |   |   |   else System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   }\n" +
"                                    else        //HST_6 > 1.846154\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_5 <= 0.061524)\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_6 <= 1.889024)\n" +
"|   |   |   |   |   |   |   |   |   |   |   {   if(HST_2 <= 4) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   |   |   |   |   |   }\n" +
"                                            else System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   }\n" +
"                                        else        //HST_5 > 0.061524\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_3 <= 5.936047)\n" +
"|   |   |   |   |   |   |   |   |   |   |   {   if(HST_1 <= 319) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   }\n" +
"                                            else  System.out.println(\"undecided\"); \n" +
"                                        }\n" +
"                                    }\n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   }\n" +
"                            else    //HST_5 > 0.064121\n" +
"|   |   |   |   |   |   |   {   if(HST_1 <= 441) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   else    //HST_1 > 441\n" +
"|   |   |   |   |   |   |   |   {   if(HST_4 <= 0.038462) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   else    //HST_4 > 0.038462\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_3 <= 6.1)     System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else    //HST_3 > 6.1\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_2 <= 6   ) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   else    //HST_2 > 6\n" +
"|   |   |   |   |   |   |   |   |   |   |   {   if(HST_1 <= 448)     System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"                                            }\n" +
"                                        }\n" +
"                                    }\n" +
"                                }\n" +
"                            }\n" +
"                        }\n" +
"                    }\n" +
"                }\n" +
"            }\n" +
"        }\n" +
"|   }\n" +
"    else        //HST_5 > 0.396508\n" +
"|   {   if(HST_1 <= 422)\n" +
"|   |   {   if(HST_6 <= 0.382353)    System.out.println(\"spam\");  \n" +
"|   |   |   else        //HST_6 > 0.382353\n" +
"|   |   |   {   if(HST_2 <= 8)   System.out.println(\"nonspam\");  \n" +
"|   |   |   |   else    //HST_2 > 8\n" +
"|   |   |   |   {   if(HST_6 <= 2.070913) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   else     System.out.println(\"spam\");  \n" +
"                }\n" +
"            }\n" +
"|   |   }\n" +
"        else        //HST_1 > 422\n" +
"|   |   {   if(HST_4 <= 0.077113)    System.out.println(\"nonspam\");  \n" +
"|   |   |   else System.out.println(\"spam\");  \n" +
"        }\n" +
"    }\n" +
"}\n" +
"else            //  HST_6 > 2.34292\n" +
"{   if(HST_4 <= 0.00641)\n" +
"|   {   if(HST_2 <= 5)\n" +
"|   |   {   if(HST_1 <= 1584)\n" +
"|   |   |   {   if(HST_2 <= 0)\n" +
"|   |   |   |   {   if(HST_3 <= 5.510949)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   else  System.out.println(\"spam\");  \n" +
"|   |   |   |   }\n" +
"                else        //HST_2 > 0\n" +
"|   |   |   |   {   if(HST_5 <= 0.108292) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   else        //HST_5 > 0.108292\n" +
"|   |   |   |   |   {   if(HST_3 <= 4.505747)    System.out.println(\"nonspam\"); \n" +
"|   |   |   |   |   |   else    //HST_3 > 4.505747\n" +
"|   |   |   |   |   |   {   if(HST_2 <= 3)\n" +
"|   |   |   |   |   |   |   {   if(HST_2 <= 2)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_4 <= 0.001647)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_1 <= 319) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else        //HST_1 > 319\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_5 <= 0.163023)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"                                        }\n" +
"|   |   |   |   |   |   |   |   |   }\n" +
"                                    else  System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else        //HST_2 > 2\n" +
"|   |   |   |   |   |   |   |   {   if(HST_3 <= 6.269737)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_1 <= 444) System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else    //HST_1 > 444\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_3 <= 5.746426) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"spam\");  \n" +
"                                        }\n" +
"|   |   |   |   |   |   |   |   |   }\n" +
"                                    else  System.out.println(\"nonspam\");  \n" +
"                                }\n" +
"|   |   |   |   |   |   |   }\n" +
"                            else        //HST_2 > 3\n" +
"|   |   |   |   |   |   |   {   if(HST_3 <= 5.089744) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   else        //HST_3 > 5.089744\n" +
"|   |   |   |   |   |   |   |   {   if(HST_6 <= 2.746655)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   else System.out.println(\"spam\");  \n" +
"                                }\n" +
"                            }\n" +
"                        }\n" +
"                    }\n" +
"                }\n" +
"|   |   |   }\n" +
"            else        //HST_1 > 1584\n" +
"|   |   |   {   if(HST_2 <= 4) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   else    //HST_2 > 4\n" +
"|   |   |   |   {   if(HST_1 <= 2203) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   else System.out.println(\"spam\");  \n" +
"                }\n" +
"            }\n" +
"|   |   }\n" +
"        else        //HST_2 > 5\n" +
"|   |   {   if(HST_2 <= 7) System.out.println(\"nonspam\");  \n" +
"|   |   |   else    //HST_2 > 7\n" +
"|   |   |   {   if(HST_6 <= 3.953737)\n" +
"|   |   |   |   {   if(HST_4 <= 0.001647) System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   else    //HST_4 > 0.001647\n" +
"|   |   |   |   |   {   if(HST_1 <= 2193)\n" +
"|   |   |   |   |   |   {   if(HST_5 <= 0.135849)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   else System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   }\n" +
"                        else     System.out.println(\"nonspam\");  \n" +
"                    }\n" +
"|   |   |   |   }\n" +
"                else    //HST_6 > 3.953737\n" +
"                        System.out.println(\"spam\");  \n" +
"            }\n" +
"        }\n" +
"|   }\n" +
"    else        //HST_4 > 0.00641\n" +
"|   {   if(HST_6 <= 2.904916)\n" +
"|   |   {   if(HST_4 <= 0.384615)    System.out.println(\"nonspam\");  \n" +
"|   |   |   else    //HST_4 > 0.384615\n" +
"|   |   |   {   if(HST_2 <= 6)\n" +
"|   |   |   |   {   if(HST_1 <= 1111)\n" +
"|   |   |   |   |   {   if(HST_5 <= 0.233111)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   else        //HST_5 > 0.233111\n" +
"|   |   |   |   |   |   {   if(HST_1 <= 590)     System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   else    //HST_1 > 590\n" +
"|   |   |   |   |   |   |   {   if(HST_4 <= 0.514658)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   else     System.out.println(\"nonspam\");  \n" +
"                            }\n" +
"                        }\n" +
"|   |   |   |   |   }\n" +
"                    else    //HST_1 > 1111\n" +
"|   |   |   |   |   {   if(HST_2 <= 0)   System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   else        //HST_2 > 0\n" +
"|   |   |   |   |   |   {   if(HST_5 <= 0.119131)    System.out.println(\"undecided\"); \n" +
"|   |   |   |   |   |   |   else        //HST_5 > 0.119131\n" +
"|   |   |   |   |   |   |   {   if(HST_3 <= 4.525773)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   else        //HST_3 > 4.525773\n" +
"|   |   |   |   |   |   |   |   {   if(HST_1 <= 1627)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_1 <= 1301)        System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else     System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   }\n" +
"                                    else    //HST_1 > 1627: \n" +
"                                        System.out.println(\"nonspam\");  \n" +
"                                }\n" +
"                            }\n" +
"                        }\n" +
"                    }\n" +
"|   |   |   |   }\n" +
"                else    //HST_2 > 6\n" +
"|   |   |   |   {   if(HST_1 <= 236)\n" +
"|   |   |   |   |   {   if(HST_3 <= 5.919608)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   }\n" +
"                    else    System.out.println(\"nonspam\");  \n" +
"                }\n" +
"            }\n" +
"|   |   }\n" +
"        else    //HST_6 > 2.904916\n" +
"|   |   {   if(HST_4 <= 0.10628)\n" +
"|   |   |   {   if(HST_5 <= 0.106468)\n" +
"|   |   |   |   {   if(HST_1 <= 1204)\n" +
"|   |   |   |   |   {   if(HST_3 <= 4.419214)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   else        //HST_3 > 4.419214\n" +
"|   |   |   |   |   |   {   if(HST_5 <= 0.099286)\n" +
"|   |   |   |   |   |   |   {   if(HST_2 <= 7)\n" +
"|   |   |   |   |   |   |   |   {   if(HST_2 <= 5)   System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   else     System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   }\n" +
"                                else    /*HST_2 > 7:*/ System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   }\n" +
"                            else    /*HST_5 > 0.099286:*/ System.out.println(\"spam\");  \n" +
"                        }\n" +
"|   |   |   |   |   }\n" +
"                    else    /*HST_1 > 1204*/ System.out.println(\"nonspam\");  \n" +
"|   |   |   |   }\n" +
"                else    /*HST_5 > 0.106468*/ System.out.println(\"nonspam\");  \n" +
"|   |   |   }\n" +
"            else        //HST_4 > 0.10628\n" +
"|   |   |   {   if(HST_2 <= 6)\n" +
"|   |   |   |   {   if(HST_4 <= 0.807692)\n" +
"|   |   |   |   |   {   if(HST_6 <= 3.021146)\n" +
"|   |   |   |   |   |   {   if(HST_4 <= 0.604217)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   else System.out.println(\"undecided\"); \n" +
"|   |   |   |   |   |   }\n" +
"                        else        //HST_6 > 3.021146\n" +
"|   |   |   |   |   |   {   if(HST_1 <= 2345)\n" +
"|   |   |   |   |   |   |   {   if(HST_1 <= 389) System.out.println(\"undecided\"); \n" +
"|   |   |   |   |   |   |   |   else        //HST_1 > 389\n" +
"|   |   |   |   |   |   |   |   {   if(HST_2 <= 5)\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_4 <= 0.418283)\n" +
"|   |   |   |   |   |   |   |   |   |   {   if(HST_2 <= 0)   System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   else    //HST_2 > 0\n" +
"|   |   |   |   |   |   |   |   |   |   |   {   if(HST_5 <= 0.352528)\n" +
"|   |   |   |   |   |   |   |   |   |   |   |   {   if(HST_2 <= 4)   System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   |   |   else        //HST_2 > 4\n" +
"|   |   |   |   |   |   |   |   |   |   |   |   |   {   if(HST_1 <= 1305)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"                                                    }\n" +
"|   |   |   |   |   |   |   |   |   |   |   |   }\n" +
"                                                else    /*HST_5 > 0.352528*/ System.out.println(\"nonspam\");  \n" +
"                                            }\n" +
"|   |   |   |   |   |   |   |   |   |   }\n" +
"                                        else    /*HST_4 > 0.418283*/ System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   |   |   |   }\n" +
"                                    else        //HST_2 > 5\n" +
"|   |   |   |   |   |   |   |   |   {   if(HST_1 <= 1199)    System.out.println(\"spam\");  \n" +
"|   |   |   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"                                    }\n" +
"                                }\n" +
"|   |   |   |   |   |   |   }\n" +
"                            else        //HST_1 > 2345\n" +
"|   |   |   |   |   |   |   {   if(HST_2 <= 1)   System.out.println(\"undecided\"); \n" +
"|   |   |   |   |   |   |   |   else System.out.println(\"nonspam\");  \n" +
"                            }\n" +
"                        }\n" +
"|   |   |   |   |   }\n" +
"                    else        //HST_4 > 0.807692\n" +
"|   |   |   |   |   {   if(HST_5 <= 0.121137)    System.out.println(\"nonspam\");  \n" +
"|   |   |   |   |   |   else     System.out.println(\"spam\");  \n" +
"                    }\n" +
"|   |   |   |   }\n" +
"                else    /*HST_2 > 6*/ System.out.println(\"nonspam\");  \n" +
"            }\n" +
"        }\n" +
"    }\n" +
"}";
y=y.replace('|',' ');
      String h;
String i="http://24shop.cohttp://";
h=i=i.replace("http://", "");
      System.out.println(h);
if(true)   System.out.println("hel");
else
{
    
}
String k,kl = null;
     k="hrll0";
     
      System.out.println(dan.get(0));
      System.out.println(k);
  }
}
    
    

