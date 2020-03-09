package newest;

//here we import lots of things
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.font.CreatedFontTracker;

public class Primary extends Application {
	static Stage arg0=new Stage();
	//String


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg1) throws Exception {		//ka ka ka kawaii

		//here we split input from text file in method
		input("levels/level3.txt",400,200);
		int lvOrdered=0;

		//useless but just in case of future changes
		//here we declared and load properties to pane
		Pane rootpane=new Pane();
		rootpane.getChildren().addAll(tile.bigPane);
		//System.out.println("height is :"+tile.bigPane.getHeight()+", width is:"+tile.bigPane.getWidth()); //didnt work
		tile.bigPane.setTranslateX(400);
		tile.bigPane.setTranslateY(200);

		//here we creating scene
		Scene scene=new Scene(rootpane);

		//here we set scene and show it in full screen
		arg0.setScene(scene);
		arg0.setFullScreen(true);
		arg0.show();

	}

	//In this method we create file according to input from text file
	private static Pane[][] createTile(String[][] input) {

		int number;
		String name, direction;
		//in input method we created 16-3 array
		for (int i = 0; i < 16; i++) {
			//first value in array is number
			String a = input[i][0];
			number = Integer.parseInt(a);
			//second value in array is name of tile
			name = input[i][1];
			//third value in array is direction of tile for instance vertical horizontal etc.
			direction = input[i][2];
			tile til=new tile(number, name, direction);

		}
		//here returning
		return tile.Array;

	}


	//here there is a method input which takes 3 input value work for splitting input from text file
	static Pane input(String position,int initialX, int initialY){		//inputu düzenliyor
		tile.currentLv=position;
		//takes the input and work on it
		String[] rows = new String[16];
		String[][] input = new String[16][3];
		InputStream is = null;
		try {
			is = Files.newInputStream(Paths.get(position));
		} catch (IOException e1) {
			System.out.println("error in file positions, please contact with creators to get files or get sure position is true");
			e1.printStackTrace();
		}
		//here we splitting input for comma "," and load values into array
		try (Scanner scanner = new Scanner(is)) {

			for (int i = 0; i < 16; i++) {
				rows[i] = scanner.nextLine();

				for (int j = 0; j < 3; j++) {
					String s = rows[i];
					String[] b = s.split(",");
					input[i][j] = b[j];
				}
			}
		}
		createTile(input);
		tile.initialX=initialX;
		tile.initialY=initialY;
		return tile.bigPane;
	}

}class tile extends Pane{
	//here we declaring some variables
	static tile Array[][]=new tile[4][4];		//neden olmuyor bu
	static Pane Panes[][]=new Pane[4][4];	//mini arraylerin payni, bunu kopyal?can ve set etcen i?te
	private Pane pane=new Pane();			//instance pane
	public static Pane bigPane=new Pane();	//ana pane
	private ImageView image;				//tile in instance image i
	boolean canMove=true;					//kutu static mi
	public static boolean noAction=true;	//hareket ger?ekle?iyor mu
	static boolean bigPaneFilled=false;
	int i;
	int j;
	static int initialX=0;
	static int initialY=0;
	static int moveCounter;
	String name1 ="";
	static String currentLv="";

	//here setter getter method
	public Pane getPane() {
		return pane;
	}
	public void setPane(Pane pane) {
		this.pane=pane;
	}
	//here there is deletePane method
	public static void deletePane(){
		Pane p=new Pane();
		bigPane=p;


	}

	//here there is constructor with three input value
	tile(int number,String name,String direction) {
		//in this if case we construct background of pane
		if(bigPaneFilled==false) {	//pane in arka plan?n? gri yap?yor
			bigPaneFilled=true;
			newPane.set();
			bigPane.setMinSize(800, 800);


		}
		//here we splitting value from text file and convert it into 4x4 values
		i = (number-1) / 4;
		j = (number-1) % 4;


		//here we are declaring tiles according to text file if it's name is starter
		//this if case work and some properties load into them such as name, image,
		if (name.equals("Starter")) {
			canMove = false;
			if (direction.equals("Vertical")) {
				name1 = "SV";
				ImageView img = new ImageView(new Image("file:images/StarterV.png"));
				img.setRotate(270);
				image = img;
			} else {
				name1 = "SH";
				ImageView img = new ImageView(new Image("file:images/StarterV.png"));
				img.setRotate(180);
				image = img;
			}
		}
		//here we are declaring tiles according to text file if it's name is End
		//this if case work and some properties load into them such as name, image,
		else if (name.equals("End")) {
			canMove=false;
			if(direction.equals("Vertical")) {
				name1 = "EndV";
				ImageView img=new ImageView(new Image("file:images/EndH.png"));
				img.setRotate(270);
				image=img;
			}
			else {
				name1 = "EndH";
				image=new ImageView(new Image("file:images/EndH.png"));
			}
		}
		//here we are declaring tiles according to text file if it's name is Empty
		//this if case work and some properties load into them such as name, image,

		else if (name.equals("Empty")) {
			if(direction.equals("none")) {
				name1 = "Empty";
				image=new ImageView(new Image("file:images/Empty.png"));
			}else {
				name1 = "Free";
				canMove=false;

				image=null;
			}


		}
		//here we are declaring tiles according to text file if it's name is Pipe
		//this if case work and some properties load into them such as name, image,

		else if (name.equals("Pipe")) {
			if(direction.equals("Vertical")){
				name1="PipeV";
				image= new ImageView(new Image("file:images/PipeV.png"));

			}else if(direction.equals("Horizontal")){
				name1="PipeH";
				image= new ImageView(new Image("file:images/PipeH.png"));
			}else if(direction.equals("00")){
				name1 = "00";
				image= new ImageView(new Image("file:images/CurvedPipe00.png"));
			}else if(direction.equals("01")){
				name1="01";
				image= new ImageView(new Image("file:images/CurvedPipe01.png"));
			}else if(direction.equals("10")){
				name1="10";
				image= new ImageView(new Image("file:images/CurvedPipe10.png"));
			}else if(direction.equals("11")){
				name1="11";
				image= new ImageView(new Image("file:images/CurvedPipe11.png"));
			}//end of pipe lol
		}
		//here we are declaring tiles according to text file if it's name is PipeStatic
		//this if case work and some properties load into them such as name, image,
		else if (name.equals("PipeStatic")) {
			canMove=false;
			if(direction.equals("Vertical")) {
				name1="PipeSV";
				image=new ImageView(new Image("file:images/PipeStaticV.png"));
			}else if(direction.equals("00")){
				name1 = "00";
				image= new ImageView(new Image("file:images/PipeStatic01.png"));
				image.setRotate(270);
			}else if(direction.equals("01")){
				name1="01";
				image= new ImageView(new Image("file:images/PipeStatic01.png"));
			}else if(direction.equals("10")){
				name1="10";
				image= new ImageView(new Image("file:images/PipeStatic01.png"));
				image.setRotate(180);
			}else if(direction.equals("11")){
				name1="11";
				image= new ImageView(new Image("file:images/PipeStatic01.png"));
				image.setRotate(90);
			}else {
				name1 = "PipeSH";
				image=new ImageView(new Image("file:images/PipeStaticH.png"));
			}
		}


		//here we constructing pane with tiles put them correct position
		if(image!=null) {
			setSize();

			pane.getChildren().add(image);
			pane.setTranslateX(j*200);
			pane.setTranslateY(i*200);
			bigPane.getChildren().add(pane);

			Panes[i][j]=pane;
			Array[i][j]=this;
			Array[i][j].name1 =name1;

			//here provide us to show it at front of screen, not back
			pane.setOnMousePressed(e->{
				pane.toFront();
			});
			//here we setting some values while tile is dragging
			image.setOnMouseDragged(e->{
				//here we check if position is correct
				if((Array[i][j].canMove&&tile.noAction)&&((i<3&&Array[i+1][j]==null)||(i>0&&Array[i-1][j]==null)||(j<3&&Array[i][j+1]==null)||(j>0&&Array[i][j-1]==null))) {

					double k,l;
					k=e.getSceneX()-initialX;
					l=e.getSceneY()-initialY;
					pane.setTranslateX(k-100);
					pane.setTranslateY(l-100);
					setScaleX(800);
					setScaleY(800);
				}


			});
			//here we setting some values while tile is released
			pane.setOnMouseReleased(event->{
				//here we check if position is correct
				if((Array[i][j].canMove&&tile.noAction)&&((i<3&&Array[i+1][j]==null)||(i>0&&Array[i-1][j]==null)||(j<3&&Array[i][j+1]==null)||(j>0&&Array[i][j-1]==null))) {


					double lfinal=event.getSceneX()-initialX;
					double kfinal=event.getSceneY()-initialY;
					System.out.println("its cordinates are :"+lfinal+","+kfinal);
					int l=(int)lfinal/200;
					int k=(int)kfinal/200;		//gives final cordinates


					if(lfinal>800||kfinal>800||lfinal<0||kfinal<0) {
						pane.setTranslateX(j*200);
						pane.setTranslateY(i*200);

					}else {
						//here we check if user play correct order and if this case is true tiles are move and voice is heard by user
						if(Panes[k][l]==null&&((k==i+1)&&(l==j))^((k==i-1)&&(l==j))^((k==i)&&(l==j+1))^((k==i)&&(l==j-1))) {		//checks if that position is free
							tile temptile=Array[i][j];
							Pane temppane=Panes[i][j];
							Array[i][j]=null;
							Panes[i][j]=null;
							pane.setTranslateX(l*200);
							pane.setTranslateY(k*200);
							Panes[k][l]=temppane;
							Array[k][l]=temptile;
							setArray(k, l);
							//here we increments the counter which will be on game screen and show you play played tile how many times
							moveCounter++;
							newPane.set();
							//here we play switch audio while tiles swithing
							playSwitch();
						}
						else {
							//here we played error audio when incorrent move is occured
							playError();
							pane.setTranslateX(j*200);
							pane.setTranslateY(i*200);
						}
					}
				}
				int a = 1;
				//here we find the starter tile in input text file and at the bottom we write them console
				String[][] inputArray = input();
				int starter= findStarter(inputArray);
				int sti = starter / 4;
				int stj = starter % 4;
				System.out.println("Sti : "+ sti + " Stj : " + stj);

				//here we constructing path which will be path for our ball
				Path path = new Path();
				path.getElements().add(new MoveTo(100,100) );
				int[] coord= new int[2];
				coord[0]=sti*200+100;
				coord[1]=stj*200+100;
				int i = sti*200+100;
				int j = stj*200+100;

				//if starter tile is vertical some variables is changed
				if(inputArray[starter][2].equals("Vertical")){
					sti++;
					coord[1]+=100;

					path.getElements().add(new VLineTo(coord[1]));

					//if starter tile is not vertical some variables is changed
				}else{
					stj++;
					coord[0]+=100;

					path.getElements().add(new VLineTo(coord[0]));
				}
				System.out.println("Sti2 : "+ sti + " Stj2 : " + stj);
				//here our check method which take lost of input check whether game is finished or not
				boolean b = check(sti,stj,Array[0][1].name1,Array,a,path,i,j,coord,0,0);
				System.out.println(b);


				//here if game is finished correctly this if case works
				if(b){
					//here win audio is played
					playWin();
					try {
						Thread.sleep(00);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Path: " + i + "," + j);
					System.out.println("Coord: " + coord[0] + "," + coord[1]);
					//here path trasition is created
					PathTransition pt = new PathTransition();
					//here ball is created with 20 radius it is shown in front at its color is yellow
					Circle circle= new Circle(100,100,20);
					circle.toFront();
					circle.setFill(Color.YELLOW);
					//here we declare time for path
					pt.setDuration(Duration.millis(4000));
					//here we are setting the path for ball
					pt.setPath(path);
					//here we are setting the ball
					pt.setNode(circle);
					//here we play the path trasition animation
					pt.play();
					//here we creating the pane
					Pane pane = new Pane();
					//here we adding ball to pane
					pane.getChildren().addAll(circle);
					//here we adding pane to main pane
					tile.bigPane.getChildren().addAll(pane);
				}



			});




		}else {
			Panes[i][j]=null;
			Array[i][j]=null;
		}


	}




	private void setArray(int i2,int j2){	//change the array's i and j values to new ones
		i=i2;
		j=j2;
	}

	private static void refill(int o,int p) {
		Pane bigPane2 = null;
		for(int n=0;n<4;n++) {
			for(int m=0;m<4;m++) {
				if(n!=o||m!=p)
					bigPane2.getChildren().add(Panes[n][m]);
			}
		}
		bigPane=bigPane2;
	}

	private void setSize() {	//imagelerin size?n? ayarl?yor gelende instancelerin xd
		image.setFitHeight(200);
		image.setFitWidth(200);
	}

	//here our check method which take lost of input check whether game is finished or not
	public static boolean check(int nextX, int nextY, String name, tile[][] array,int a,Path path,int i,int j,int[] coord,int prevX,int prevY){
		i=coord[0];
		j=coord[1];
		a++;
		boolean correct=false;
		boolean okey=false;

		//here a checks the if this method in infinite loop it returns false and finish the game
		if(a>50) {
			return false;}

		//here we checkk if next tile in path is empty free tile it return false
		if(array[nextX][nextY]==null) {
			System.out.println("Null");

			return false;	}
		//here we checkk if next tile in path is empty none tile it return false
		if(array[nextX][nextY].name1.equals("Empty")) {
			System.out.println("Empty");

			return false;	}
		//here we checkk if next tile in path is empty free tile it return false
		if(array[nextX][nextY].name1.equals("Free")) {
			System.out.println("Free");

			return false;	}

		System.out.println("_");
		System.out.println("Previous :"+prevX +","+ prevY);
		System.out.println("Current :"+nextX +","+ nextY);
		//here we change some values to check if previous and current tile are compatible with each other or not
		int previousX = prevX;
		int previousY = prevY;
		int followingX = nextX;
		int followingY = nextY;

		//if next element's value is null return false
		if(array[nextX][nextY].name1 == null){
			System.out.println("Lose");

			return false;
		}
		//here we change some values which will be use later on
		int x= prevX;
		int y= prevY;
		prevX=nextX;
		prevY=nextY;
		//if next tile in path is 00 this if case is works
		if(array[nextX][nextY].name1.equals("00")){
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY-1) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX && previousY==followingY-1){
				System.out.println("good");
			}else{
				System.out.println("else false");
				return false;
			}

			//here we creating path for 00 which is arc and set some values
			ArcTo arc = new ArcTo();
			i+=100;
			arc.setX(i);
			j-=100;
			arc.setY(j);
			arc.setRadiusX(200);
			arc.setRadiusY(200);
			path.getElements().add(arc);
			System.out.println(i + "" + j);
			nextX--;
			System.out.println("00");

			//if next tile in pathh is 01 this if case is works
		}else if(array[nextX][nextY].name1.equals("01")){
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX-1){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");
			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX-1 && previousY== followingY){
				System.out.println("good");
			}else{
				System.out.println("else false");
				return false;
			}


			ArcTo arc = new ArcTo();
			i+=100;
			arc.setX(i);
			j+=100;
			arc.setY(j);
			arc.setRadiusX(200);
			arc.setRadiusY(200);
			System.out.println(i + "" + j);
			path.getElements().add(arc);
			nextY++;

			//if next tile in pathh is 10 this if case is works
		}else if(array[nextX][nextY].name1.equals("10")){
			System.out.println("10");
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY-1) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");
			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX && previousY== followingY-1){
				System.out.println("GUZEL");
			}else{
				System.out.println("else false");
				return false;
			}


			ArcTo arc = new ArcTo();
			i+=100;
			arc.setX(i);
			j+=100;
			arc.setY(j);
			arc.setRadiusX(200);
			arc.setRadiusY(200);
			System.out.println(i + "" + j);
			path.getElements().add(arc);
			nextX++;
			//if next tile in pathh is 11 this if case is works
		}else if(array[nextX][nextY].name1.equals("11")) {
			System.out.println("11");
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX+1){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX+1 && previousY== followingY){
				System.out.println("good");
			}else{
				System.out.println("else false");
				return false;
			}


			ArcTo arc = new ArcTo();
			i+=100;
			j-=100;
			arc.setX(i);
			arc.setY(j);
			arc.setRadiusX(200);
			arc.setRadiusY(200);
			System.out.println(i + "" + j);
			path.getElements().add(arc);
			nextY++;
			//if next tile in pathh is empty this if case is works
		}else if(array[nextX][nextY].name1.equals("Empty")) {
			System.out.println("Empty");
			System.out.println(i + "" + j);
			i=100;
			j=100;
			System.out.println("false");
			correct=false;

			return false;

			//if next tile in pathh is free this if case is works
		}else if(array[nextX][nextY].name1.equals("Free")) {
			System.out.println("Free");
			System.out.println(i + "" + j);
			i=100;
			j=100;
			System.out.println("false");
			correct=false;

			return false;

			//if next tile in pathh is endH this if case is works
		}else if(array[nextX][nextY].name1.equals("EndH")) {
			System.out.println("EndH'da");
			System.out.println(i + "" + j);
			i+=100;
			System.out.println(i + "" + j);
			HLineTo hline = new HLineTo(i);
			path.getElements().add(hline);
			System.out.println("KAZANDIN endh");
			createAPopUpMessage();
			correct=true;
			System.out.println("returning trueee");
			System.out.println(i + "," + j);
			return true;

			//if next tile in pathh is endV this if case is works
		}else if(array[nextX][nextY].name1.equals("EndV")) {
			System.out.println("EndV'de");
			System.out.println(i + "" + j);
			j-=100;
			System.out.println(i + "" + j);
			path.getElements().add(new VLineTo(j));
			System.out.println("KAZANDIN endv");
			createAPopUpMessage();
			correct=true;
			System.out.println("returning trueee");
			System.out.println(i + "," + j);
			coord[0]=i;
			coord[1]=j;
			return true;

		//if next tile in pathh is pipeH this if case is works
		}else if(array[nextX][nextY].name1.equals("PipeH")) {
			System.out.println("pipeH");
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY-1) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX && previousY== followingY-1){
				System.out.println("good");
			}else{
				System.out.println("else false");
				return false;
			}


			i+=200;
			System.out.println(i + "" + j);



			path.getElements().add(new HLineTo(i));
			nextY++;

			//if next tile in pathh is pipeV this if case is works
		}else if(array[nextX][nextY].name1.equals("PipeV")) {
			System.out.println("pipeV");
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX-1){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX-1 && previousY== followingY){
				System.out.println("GUZEL");
			}else{
				System.out.println("else false");
				return false;
			}


			j+=200;
			System.out.println(i + "" + j);
			path.getElements().add(new VLineTo(j));
			nextX++;

			//if next tile in pathh is pipeSV this if case is works
		}else if(array[nextX][nextY].name1.equals("PipeSV")) {
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX-1){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX-1 && previousY== followingY){
				System.out.println("GUZEL");
			}else{
				System.out.println("else false");
				return false;
			}

			j+=200;
			System.out.println(i + "" + j);
			path.getElements().add(new VLineTo(j));
			nextX++;

			//if next tile in pathh is pipeSH this if case is works
		}else if(array[nextX][nextY].name1.equals("PipeSH")) {
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY-1) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX && previousY== followingY-1){
				System.out.println("GUZEL");
			}else{
				System.out.println("else false");
				return false;
			}


			i+=200;
			System.out.println(i + "" + j);
			path.getElements().add(new HLineTo(i));
			nextY++;

			//if next tile in pathh is pipeSV this if case is works
		}else if(array[nextX][nextY].name1.equals("SV")) {
			System.out.println("SV");
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX-1){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX-1 && previousY== followingY){
				System.out.println("good");
			}else{
				System.out.println("else false");
				return false;
			}


			i+=100;
			System.out.println(i + "" + j);
			path.getElements().add(new VLineTo(i));
			nextX++;

			//if next tile in pathh is SH this if case is works
		}else if(array[nextX][nextY].name1.equals("SH")) {
			System.out.println("SH");
			System.out.println(i + "" + j);

			System.out.println("Previous x,y : " + previousX + "," + previousY);
			System.out.println("Following x,y : " + followingX + "," + followingY);

			if(previousX==followingX){
				System.out.println("Ok1");
			}else
				System.out.println("no1");
			if (previousY== followingY-1) {
				System.out.println("Ok2");
			}else
				System.out.println("no2");

			//here we check if previous and current tile are compatible with each other or not
			if(previousX==followingX && previousY== followingY-1){
				System.out.println("GUZEL");
			}else{
				System.out.println("else false");
				return false;
			}


			j+=200;
			System.out.println(i + "" + j);
			path.getElements().add(new HLineTo(j));
			nextY++;
		}else{
			System.out.println("FALSE NAMEEE");
			i=100;
			j=100;
			System.out.println("false");
			correct=false;

			return false;
		}






		//
		if(array[nextX][nextY] == null){
			System.out.println("You lose");
			return false;
		}
		coord[0]=i;
		coord[1]=j;
		//here we returning to find following path
		return check(nextX,nextY,Array[nextX][nextY].name1,array,a,path,i,j,coord,prevX,prevY);
		//System.out.println("Son statement false dönüyor");
		//return false;

	}
	//here we show screen to Congratulations popup message
	private static void createAPopUpMessage() {
		Rectangle covery=new Rectangle();
		covery.setHeight(Screen.getPrimary().getBounds().getHeight());
		covery.setWidth(Screen.getPrimary().getBounds().getWidth());
		covery.setOpacity(0.3);
		StackPane sp=new StackPane();

		Rectangle panel=new Rectangle(400,600);
		panel.setFill(Color.PALEGOLDENROD);
		Rectangle mainmenu=new Rectangle(300,100);
		Rectangle mainmenuCover=new Rectangle(300,100);		//just to cover rect with text
		mainmenu.setFill(Color.ALICEBLUE);
		mainmenu.setTranslateY(100);
		mainmenuCover.setTranslateY(100);
		mainmenuCover.setOpacity(0);
		Text back=new Text("Return");
		back.setFont(Font.font(30));
		back.setTranslateY(100);
		Text t1=new Text("Congratulations!");
		t1.setFont(Font.font(50));
		t1.setTranslateY(-50);
		sp.getChildren().addAll(covery,panel,t1,mainmenu,back,mainmenuCover);
		lastMenu.root.getChildren().add(sp);
		mainmenuCover.setOnMouseClicked(e->{
			lastMenu.checkWhichLv(currentLv);
			lastMenu.root.getChildren().remove(sp);
		});



	}
	//here we splitting input according to text file
	public String[][] input(){
		//takes the input and work on it
		String[] rows = new String[16];
		String[][] input = new String[16][3];
		try (Scanner scanner = new Scanner(new FileReader("levels/level5.txt"))) {


			for (int i = 0; i < 16; i++) {
				rows[i] = scanner.nextLine();

				for (int j = 0; j < 3; j++) {
					String s ;
					s=rows[i];
					String[] b = s.split(",");
					input[i][j] = b[j];
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IOException");
		}

		return input;
	}

	//here we find the starter tile position
	public int findStarter(String[][] input){
		for(int i = 0;i<16;i++) {
			if (input[i][1].equals("Starter")){
				return i;
			}
		}
		return -1;
	}
	//here there is play win voice to play
	public void playWin(){
		MediaPlayer mediaPlayer;
		String path = "Win.mp3";

		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();

	}


	//here there is play switch voice to play
	public void playSwitch(){
		MediaPlayer mediaPlayer;
		String path = "Switch.mp3";

		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();
	}

	//here there is play error voice to play
	public void playError(){
		MediaPlayer mediaPlayer;
		String path = "Error.mp3";

		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();
	}

	//here there is play click voice to play
	public void playClick(){
		MediaPlayer mediaPlayer;
		String path = "Click.mp3";

		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();
	}

}