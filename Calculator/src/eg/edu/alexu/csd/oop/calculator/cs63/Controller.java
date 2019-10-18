package eg.edu.alexu.csd.oop.calculator.cs63;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class Controller {

    @FXML
    private Label res ;
    Model model = new Model();

    @FXML
    public void press (ActionEvent actionEvent)
    {
        String experssion = ((Button)actionEvent.getSource()).getText() ;
        res.setText(res.getText()+experssion) ;
    }

    @FXML
    public void equal(ActionEvent event)
    {
        String experssion = res.getText();
        String ans;
        String Equal = ((Button)event.getSource()).getText();
        model.input(experssion);
        ans = model.getResult();
        if(ans=="")
            res.setText("");
        else if(ans == "Wrong Mathematical Expression")
            res.setText("Wrong Mathematical Expression");
        else
        {
            res.setText(" "+ans);
        }
    }

    @FXML
    public void Curr(ActionEvent event)
    {
        res.setText("");
        String s = model.current();
        res.setText(s);
    }

    public void prev(ActionEvent event)
    {
        res.setText("");
        String s= model.prev();
        res.setText(s);
    }

    public void next (ActionEvent event)
    {
        res.setText("");
        String s= model.next();
        res.setText(s);
    }

    @FXML
    public void Save(ActionEvent event) throws IOException {
        model.save();
    }

    @FXML
    public void load(ActionEvent event) throws IOException, ClassNotFoundException {
        model.load();
    }

    @FXML
    public void AC()
    {
        res.setText("");
        model.setNum1(0);
        model.setNum2(0);
        model.setOperator("");
        model.setErorr1(false);
        model.setErorr2(false);
    }


}
