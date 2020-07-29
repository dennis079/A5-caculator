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
                System.out.print("contain(");
                String temp = s.substring(s.indexOf("(") + 1);
                System.out.println(temp);
                String substring = s.substring(s.indexOf("("), s.indexOf(")") + 1);
                System.out.println(substring);

                //if the string still contain '('
                if(temp.contains("(")){
                    System.out.println("still!!!!! contain (");
                    //if the next signal is '(' not ')'
                    //which means it is something like '(aa(' that still need to calculate the inside
                    if (s.indexOf("(") < s.indexOf(")")) {
                        System.out.println("( before )");
                        return s.substring(0,s.indexOf("(")-1)+calculate(s.substring(s.indexOf("(")));
                    }
                    //if the next signal is ')' not '('
                    //which means it is something like 'aa)' that the end of Priority
                    if(s.indexOf("(") > s.indexOf(")"))
                        return calculate(calculate(s.substring(0,s.indexOf(")")-1))+s.substring(0,s.indexOf(")")));
                }

            }

            //case with out any (
            else {
                if (s.contains(")")){
                    System.out.print("calculate error");
                    screen.setText(String.format("%s input error", screen.getText()));
                }

                //the 1st num in the string and convert it into int
                String s1;
                s1 = s.substring(0, s.indexOf(" "));

                //the operation
                String op = s.substring(s.indexOf(" "),s.indexOf(" ") + 2);
                //let the 2ed num be the string after 1st operation
                String s2=s.substring(s.indexOf(" ")+1);;
                //string of two value and one opertaion
                String s3 = null;
                //if there still any operation in the 2nd num
                if(s2.contains(" ")) {
                    s2= s2.substring(0,s2.indexOf(" "));
                    s3= s.substring(0, s.indexOf(" ") + s2.length());
                }

                System.out.println(s3);

                //the result that will return
                double result = 0;
                //if there is * or /
                System.out.println("***///");
                if (s.contains("*") || s.contains("/")) {
                    //if the 1st op is */
                    if (op.equals("*")||op.equals("/")
                    ) {
                        System.out.println("1st op is */");

                        try {
                            val0 = Double.parseDouble(s1);
                            val1 = Double.parseDouble(s2);
                        } catch (Exception e) {
                            System.out.println("error: */");
                        }
                        if (op.equals("*")) {
                            result = val0 * val1;
                        }
                        if (op.equals("/")) {
                            result = val0 / val1;
                        }
                        String res = Double.toString(result);
                        return calculate(res+s3);
                    }

                }

                //if there is  + or -
                if ((s.contains("+") || s.contains("-"))
                ) {
                    //if(s.contains("*") && s.contains("/")){
                    //System.out.println("+- error");
                    try {
                        val0 = Double.parseDouble(s1);
                        val1 = Double.parseDouble(calculate(s2));
                    }
                    catch(Exception e){
                        System.out.println("error: +-");
                    }
                    if(op.equals("+")){
                        result= val0 + val1;
                    }
                    if(op.equals("+")){
                        result= val0 - val1;
                    }
                    String res = Double.toString(result);
                    return calculate(res+s3);
                }
            }
        }
        if(!isNum(s)){
            screen.setText(String.format("%s input error", screen.getText()));
        }
        return s;
    }

    public static  void main(String [] argv) {
        MainActivity a = new MainActivity();
        String afm = argv[0];
        afm.replace("(", " (");
        afm.replace(")", " )");
        afm.replace("+", " +");
        afm.replace("-", " -");
        afm.replace("*", " *");
        afm.replace("/", " /");
        //if there is a calculate loop error
        int count = 0;
        a.calculate(afm);
        System.out.println(afm);
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