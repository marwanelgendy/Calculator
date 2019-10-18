package eg.edu.alexu.csd.oop.calculator.cs63;


import java.io.*;

public class Model implements Calculator  {

    private double num1;
    private double num2;
    private String operator;
    private boolean erorr1 = false;
    private boolean erorr2 = false;
    File Calcfile = new File("Calculator.txt");
    DLL Save = new DLL();

    public void setErorr1(boolean erorr) {
        this.erorr1 = erorr;
    }

    public void setErorr2(boolean erorr) {
        this.erorr2 = erorr;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    Model() {
        num1 = 0;
        num2 = 0;
        operator = "";
    }

    public void input(String s) {
        Save.add(s);
        String nu1 = "";
        String nu2 = "";
        String oper = "";
        boolean x = true;
        boolean a = false;
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' && nu1 == "")
                a = true;
            else if (s.charAt(i) == '-' && nu2 == "" && !x)
                b = true;
            else if (((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.') && x) {
                nu1 = nu1 + s.charAt(i);
            } else if (((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.') && oper != "") {
                nu2 = nu2 + s.charAt(i);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '/' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                oper = oper + s.charAt(i);
                x = false;
            } else {
                erorr1 = true;
                return;
            }
        }
        if (nu1 == "" && nu2 == "" && oper == "" && !a)
            erorr2 = true;
        if ((nu1 == "" && nu2 == "" && oper != "") || (nu1 != "" && oper != "" && nu2 == "") || (nu1 == "" && oper != "" && nu2 != ""))
            erorr1 = true;

        if (nu1 != "")
            num1 = Double.parseDouble(nu1);
        if (nu2 != "")
            num2 = Double.parseDouble(nu2);
        if (oper != "")
            operator = oper;

        if (a) {
            a = false;
            num1 = num1 * -1;
        }
        if (b) {
            b = false;
            num2 = num2 * -1;
        }
    }

    public String getResult() {
        if (erorr1)
            return "Wrong Mathematical Expression";

        if (num2 == 0 && operator == "" && erorr2 == false)
            return Double.toString(num1);

        if (erorr2) {
            erorr2 = false;
            return "";
        }


        switch (operator) {
            case "+":
                return Double.toString(num1 + num2);

            case "-":
                return Double.toString(num1 - num2);

            case "*":
                return Double.toString(num1 * num2);

            case "/": {
                if ((int) num2 == 0) {
                    return "Cannot Divide By ZerOoOo";
                }
                return Double.toString(num1 / num2);
            }

            default:
                return "Wrong Mathematical Expression";
        }
    }

    public String current()
    {
        if(Save.curr == null)
            return null;
        return Save.curr.value;
    }

    public String prev()
    {
        if(Save.curr == null)
            return null;
        if(Save.curr.previous == null)
            return null;
        String s = Save.curr.previous.getValue();
        Save.curr = Save.curr.previous;
        return s;
    }

    public String next()
    {
        if(Save.curr == null)
            return null;
        if(Save.curr.next == null)
            return null;
        String s = Save.curr.next.getValue();
        Save.curr = Save.curr.next;
        return s;
    }

    public void  save() throws IOException {
        FileOutputStream f1 = new FileOutputStream(Calcfile,false);
        ObjectOutputStream out1 = new ObjectOutputStream(f1);
        out1.close();
        FileOutputStream f2 = new FileOutputStream(Calcfile,false);
        ObjectOutputStream out2 = new ObjectOutputStream(f2);
        out2.writeObject(Save);
        out2.close();
    }

    public void load() throws IOException {
        FileInputStream f1 = new FileInputStream(Calcfile);
        ObjectInputStream in = new ObjectInputStream(f1);
        try {
            Save = (DLL) in.readObject() ;
        }
        catch (ClassNotFoundException | IOException var4 )
        {
            var4.printStackTrace();
        }
    }

}
