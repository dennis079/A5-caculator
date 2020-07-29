import java.util.Scanner;


public class A{
    private String calculate(String s) {
        double val0 = 0;
        double val1 = 0;
        //System.out.print("calculator");

        //to check is there any operation
        if (s.contains(" ")) {
            System.out.println("the string: "+ s);

            //if the string still contain '('
            if (s.contains("(")) {
                //System.out.println("contain(");
                //the string after "("
                String sAfter = s.substring(s.indexOf("(") + 1);
                //the string before "("
                String sBefore = s.substring(0,s.indexOf("(") -1);
                //the String after ")"
                String sAftR="";
                if(s.indexOf(")")!=s.length()-1){
                    s.substring(s.indexOf(")")+1);
                }
                //the String before ")"
                String sBefR=sAfter.substring(0,sAfter.indexOf(")")-1);

                //System.out.println(sAfter);
                //System.out.println(sBefore);
                //System.out.println(sAftR);
                //System.out.println(sBefR);

                //if the string still contain '('
                if(sAfter.contains("(")){
                    //System.out.println("still!!!!! contain (");
                    //if the next signal is '(' not ')'
                    //which means it is something like '(aa(' that still need to calculate the inside
                    if (s.indexOf("(") < s.indexOf(")")) {
                        //System.out.println("( before )");
                        return calculate(sBefore+calculate(sAfter));
                    }
                    //if the next signal is ')' not '('
                    //which means it is something like 'aa)' that the end of Priority
                    if(s.indexOf("(") > s.indexOf(")"))
                        return calculate(sBefore+calculate(sBefR)+sAftR);
                }
                if(s.contains(")")){
                    return calculate(sBefore+calculate(sBefR)+sAftR);
                }
                else{
                    return "error!!!!!!!";
                }

            }

            //case with out any (
            else {
                if (s.contains(")")){
                    System.out.print("calculate error");
                    //screen.setText(String.format("%s input error", screen.getText()));
                }

                //the 1st num in the string and convert it into int
                String s1;
                s1 = s.substring(0, s.indexOf(" "));

                //the operation
                String op = s.substring(s.indexOf(" ")+1,s.indexOf(" ") + 2);
                //let the 2ed num be the string after 1st operation
                String s2=s.substring(s.indexOf(" ")+2);
                //string after the operationed string
                String s3 = "";
                //if there still any operation in the 2nd num
                if(s2.contains(" ")) {
                    s3= s2.substring(s2.indexOf(" "));
                    s2= s2.substring(0,s2.indexOf(" "));

                }


                //System.out.println(s1);
                //System.out.println(s2);
                //System.out.println(op);
                //System.out.println(s3);


                //the result that will return
                double result = 0;
                //if there is * or /

                if (s.contains("*") || s.contains("/")) {
                    //if the 1st op is */
                    //System.out.println("***///");
                    if (op.equals("*")||op.equals("/")
                    ) {
                        //System.out.println("1st op is */");

                        try {
                            val0 = Double.parseDouble(s1);
                            val1 = Double.parseDouble(s2);
                        } catch (Exception e) {
                            //System.out.println("error: */");
                        }
                        if (op.equals("*")) {
                            //System.out.println("*");
                            result = val0 * val1;
                        }
                        if (op.equals("/")) {
                            //System.out.println("/");
                            result = val0 / val1;
                        }
                        String res=String.format("%.2f",result);
                        //String res = Double.toString(result);
                        //System.out.println(res);
                        return calculate(res+s3);
                    }else{
                        return calculate(s.substring(0,s.indexOf(" ")+2)+calculate(s.substring(s.indexOf(" ")+2)));
                    }

                }

                //if there is  + or -
                if ((s.contains("+") || s.contains("-"))
                ) {
                    //System.out.println("+++---");
                    //if(s.contains("*") && s.contains("/")){
                    //System.out.println("+- error");
                    try {
                        //System.out.println("try");
                        val0 = Double.parseDouble(s1);
                        val1 = Double.parseDouble(calculate(s2));
                    }
                    catch(Exception e){
                        System.out.println("error: +-");
                    }
                    if(op.equals("+")){
                        //System.out.println("+");
                        result= val0 + val1;
                    }
                    if(op.equals("-")){
                        //System.out.println("-");
                        result= val0 - val1;
                    }
                    String res = Double.toString(result);
                    //System.out.println(res);
                    return calculate(res+s3);
                }
            }
        }
        //if(!isNum(s)){
            //System.out.println("input error");
            //screen.setText(String.format("%s input error", screen.getText()));
        //}
        return s;
    }

    public static  void main(String [] argv) {
        A a = new A();
        System.out.println(a.calculate("1 +1"));
        System.out.println(a.calculate("1 *3"));
        System.out.println(a.calculate("2 *3 /4"));
        System.out.println(a.calculate("2 * (3 +4 )"));
        System.out.println(a.calculate("2 * (3 / (4 +1 ) )"));
        System.out.println(a.calculate("2 +3 /4"));
        System.out.println(a.calculate("2 +3 /4 -1"));


        /*
        while (!a.isNum(afm) || count == 1000) {
            a.calculate(afm);
            count++;
            if (count == 1000) {
                System.out.println("caculate error");
            }
            a.calculate(afm);
        }

         */
    }
}