package newest;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class newPane {
	static Pane bigPane3=new Pane();
	static int counter=tile.moveCounter;
	static Image g=new Image("file:images/gray.png");
	static ImageView back=new ImageView(g);
	static Rectangle r1=new Rectangle(300,500);
	static Label t=new Label("You have moved "+counter+" times.");
	static boolean a=false;
	
	
	static void set() {
		bigPane3.getChildren().removeAll(back,t);
		
		if(a)
			counter++;
		else
			a=true;
		back.setFitHeight(100);
		back.setFitWidth(500);
		t=new Label("You have moved "+counter+" times.");
		t.setFont(Font.font(40));
		bigPane3.getChildren().addAll(back,t);
	}
	
}
