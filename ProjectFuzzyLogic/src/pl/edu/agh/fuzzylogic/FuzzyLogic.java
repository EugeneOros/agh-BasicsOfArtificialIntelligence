package pl.edu.agh.fuzzylogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyLogic {


    public static void main(String[] args) throws Exception {
        try {
            String fileName = "fuzzy_speed.fcl";//args[0];
            int visibility = 10; //Integer.parseInt(args[1]);
            int weight = 35;//Integer.parseInt(args[2]);
            int road = 6; //Integer.parseInt(args[3]);
            FIS fis = FIS.load(fileName, false);
            FunctionBlock functionBlock = fis.getFunctionBlock(null);

            // wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            JFuzzyChart.get().chart(functionBlock);

            // zadaj wartosci wejsciowe
            fis.setVariable("visibility", visibility);
            fis.setVariable("weight", weight);
            fis.setVariable("road", road);
            // logika sterownika
            fis.evaluate();

            // graficzna prezentacja wyjscia
            Variable v = functionBlock.getVariable("speed");
            JFuzzyChart.get().chart(v, v.getDefuzzifier(), true);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out
                    .println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out
                    .println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
