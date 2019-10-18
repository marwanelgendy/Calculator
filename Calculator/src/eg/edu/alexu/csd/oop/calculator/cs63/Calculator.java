package eg.edu.alexu.csd.oop.calculator.cs63;

import java.io.IOException;

public interface Calculator {

        /** Take input from user */
         void input(String s);

        /** Return the result of the current operations or throws a runtime
        exception */
         String getResult();

        /** return the current formula */
         String current ();

        /** return the last operation in String format, or Null if no more history
        available, will update current */
         String prev();

        /** return the next operation in String format, or Null if no more history
        available, will update current */
         String next();

        /** Save in file the last 5 done Operations */
         void save()throws IOException;

        /** Load from file the saved operations */
         void load() throws IOException;

}
