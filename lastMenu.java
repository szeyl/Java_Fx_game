package newest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class lastMenu extends Application {				
	
	public static void main(String[] args) {
		launch(args);

	}
	
	static int whichLv=1;
	static String allLvs[]=new String[5];		//array which includes lv input files
	static Pane root=new Pane();
	
	static Pane levels=new Pane();		//to use in another function we need to make those static
	
	static ImageView lv1=new ImageView(new Image("file:images/lvs/level1.png"));
	static ImageView lv2=new ImageView(new Image("file:images/lvs/level2.png"));
	static ImageView lv3=new ImageView(new Image("file:images/lvs/level3.png"));
	static ImageView lv4=new ImageView(new Image("file:images/lvs/level4.png"));
	static ImageView lv5=new ImageView(new Image("file:images/lvs/level5.png"));
	static ImageView lv6=new ImageView(new Image("file:images/lvs/level6.png"));
	static ImageView lv2l=new ImageView(new Image("file:images/lvs/level2lock.png"));
	static ImageView lv3l=new ImageView(new Image("file:images/lvs/level3lock.png"));
	static ImageView lv4l=new ImageView(new Image("file:images/lvs/level4lock.png"));
	static ImageView lv5l=new ImageView(new Image("file:images/lvs/level5lock.png"));
	static ImageView lv6l=new ImageView(new Image("file:images/lvs/level6lock.png"));
	
	@Override
	public void start(Stage arg0) throws Exception {

		allLvs[0]= "levels/level1.txt";
		allLvs[1]= "levels/level2.txt";
		allLvs[2]= "levels/level3.txt";
		allLvs[3]= "levels/level4.txt";
		allLvs[4]= "levels/level5.txt";
		
		Image pl=new Image("file:images/playButton.jpg");		//declaring pictures xd
		Image st=new Image("file:images/settingsButton.jpg");
		Image ex=new Image("file:images/exitButton.jpg");
		ImageView play=new ImageView(pl);
		ImageView settings=new ImageView(st);
		ImageView exit=new ImageView(ex);	
		Image pl2=new Image("file:images/greenPlayButton.jpg");
		Image st2=new Image("file:images/greenSettingsButton.jpg");
		Image ex2=new Image("file:images/greenExitButton.jpg");
		ImageView play2=new ImageView(pl2);
		ImageView settings2=new ImageView(st2);
		ImageView exit2=new ImageView(ex2);
		Image back=new Image("file:images/backButton.png");
		Image x=new Image("file:images/x/buttonsBackground.jpg");	
		Image y=new Image("file:images/x/vintage.jpg");
		Image lighty=new Image("file:images/x/lighty.jpg");
		Image darky=new Image("file:images/x/darky.jpg");
		Image z=new Image("file:images/x/menu.jpg");
		Image stay=new Image("file:images/stay.png");
		Image leave=new Image("file:images/leave.png");
		
		InputStream is= Files.newInputStream(Paths.get("images/menuBackground.png"));		//more images
		Image pic =new Image(is);
		is.close();
		System.out.println("height is :"+Screen.getPrimary().getBounds().getHeight()+", width is:"+Screen.getPrimary().getBounds().getWidth());
		
		double hRatioOfScreen=Screen.getPrimary().getBounds().getHeight()/1080;	//gonna use it to adjust the height measures
		double wRatioOfScreen=Screen.getPrimary().getBounds().getWidth()/1920;	//gonna use it to adjust the width measures
				
		ImageView view=new ImageView(pic);
		view.setFitHeight(Screen.getPrimary().getBounds().getHeight());		//getting measures of screen and fitting that pic full screen
		view.setFitWidth(Screen.getPrimary().getBounds().getWidth());
		root.getChildren().add(view);

		Pane menu=new Pane();		//the pane which includes all buttons;play,settings,exit
		VBox buttons=new VBox(20);
		buttons.setPrefSize(50, 100);
		
		InputStream is1= Files.newInputStream(Paths.get("images/buttonBackground.jpg"));	//we were trying those kind of things because we were desperate to adding picture
		Image imgback =new Image(is1);
		is1.close();
		ImageView picback=new ImageView(imgback);	//menu background part
		picback.setFitWidth(600*wRatioOfScreen);
		picback.setFitHeight(740*hRatioOfScreen);
		
	//	Rectangle rectb=new Rectangle(600,740);
	//	rectb.setFill(Color.AQUA);
		
		//menu buttons
		setup1(play);
		setup1(settings);
		setup1(exit);
		setup1(play2);
		setup1(settings2);
		setup1(exit2);		//actually useless
		
		
		
		
		ImageView levelbackgrounds=new ImageView(x);		//adding background
		levelbackgrounds.setFitHeight(400*hRatioOfScreen);
		levelbackgrounds.setFitWidth(450*wRatioOfScreen);
		levels.setTranslateX(350*hRatioOfScreen);		//base poisiton of movable rect second position is 799
		levels.setTranslateY(205*wRatioOfScreen);
		
		
		
		levels.getChildren().add(levelbackgrounds);
		
		lv1.setFitHeight(100*hRatioOfScreen);		//adding lvs and making them seem in a good shape by hand xd
		lv1.setFitWidth(200*wRatioOfScreen);
		lv2.setFitHeight(100*hRatioOfScreen);
		lv2.setFitWidth(200*wRatioOfScreen);
		lv3.setFitHeight(100*hRatioOfScreen);
		lv3.setFitWidth(200*wRatioOfScreen);
		lv4.setFitHeight(100*hRatioOfScreen);
		lv4.setFitWidth(200*wRatioOfScreen);
		lv5.setFitHeight(100*hRatioOfScreen);
		lv5.setFitWidth(200*wRatioOfScreen);
		lv6.setFitHeight(100*hRatioOfScreen);
		lv6.setFitWidth(200*wRatioOfScreen);
		lv2l.setFitHeight(100*hRatioOfScreen);
		lv2l.setFitWidth(200*wRatioOfScreen);
		lv3l.setFitHeight(100*hRatioOfScreen);
		lv3l.setFitWidth(200*wRatioOfScreen);
		lv4l.setFitHeight(100*hRatioOfScreen);
		lv4l.setFitWidth(200*wRatioOfScreen);
		lv5l.setFitHeight(100*hRatioOfScreen);
		lv5l.setFitWidth(200*wRatioOfScreen);
		lv6l.setFitHeight(100*hRatioOfScreen);
		lv6l.setFitWidth(200*wRatioOfScreen);
		lv1.setTranslateX(20*wRatioOfScreen);
		lv1.setTranslateY(20*hRatioOfScreen);
		lv2.setTranslateX(230*wRatioOfScreen);
		lv2.setTranslateY(20*hRatioOfScreen);
		lv3.setTranslateX(20*wRatioOfScreen);
		lv3.setTranslateY(150*hRatioOfScreen);
		lv4.setTranslateX(230*wRatioOfScreen);
		lv4.setTranslateY(150*hRatioOfScreen);
		lv5.setTranslateX(20*wRatioOfScreen);
		lv5.setTranslateY(280*hRatioOfScreen);
		lv6.setTranslateX(230*wRatioOfScreen);
		lv6.setTranslateY(280*hRatioOfScreen);
		lv2l.setTranslateX(230*wRatioOfScreen);
		lv2l.setTranslateY(20*hRatioOfScreen);
		lv3l.setTranslateX(20*wRatioOfScreen);
		lv3l.setTranslateY(150*hRatioOfScreen);
		lv4l.setTranslateX(230*wRatioOfScreen);
		lv4l.setTranslateY(150*hRatioOfScreen);
		lv5l.setTranslateX(20*wRatioOfScreen);
		lv5l.setTranslateY(280*hRatioOfScreen);
		lv6l.setTranslateX(230*wRatioOfScreen);
		lv6l.setTranslateY(280*hRatioOfScreen);
		
		if(whichLv==6)		//lv is imaginary lv
			levels.getChildren().addAll(lv1,lv2,lv3,lv4,lv5,lv6);		//according to which lv open some lv and lock the others
		if(whichLv==5)
			levels.getChildren().addAll(lv1,lv2,lv3,lv4,lv5,lv6l);
		if(whichLv==4)
			levels.getChildren().addAll(lv1,lv2,lv3,lv4,lv5l,lv6l);
		if(whichLv==3)
			levels.getChildren().addAll(lv1,lv2,lv3,lv4l,lv5l,lv6l);
		if(whichLv==2)
			levels.getChildren().addAll(lv1,lv2,lv3l,lv4l,lv5l,lv6l);
		if(whichLv==1)
			levels.getChildren().addAll(lv1,lv2l,lv3l,lv4l,lv5l,lv6l);
			
		root.getChildren().add(levels);
		
		
		
		
		
		Pane settingsPane=new Pane();
		ImageView settingsBackground=new ImageView(x);	//giving a background to settings pane
		settingsBackground.setFitHeight(300*hRatioOfScreen);
		settingsBackground.setFitWidth(400*wRatioOfScreen);
		settingsPane.getChildren().add(settingsBackground);
		
		Image ksff=new Image("file:images/sett/volumeOn.png");		//adding volume on and off buttons to settings pane
		Image ksdd=new Image("file:images/sett/volumeOff.png");
		ImageView on=new ImageView(ksff);
		ImageView off=new ImageView(ksdd);
		on.setFitHeight(100*hRatioOfScreen);				//positioning
		on.setFitWidth(300*wRatioOfScreen);
		on.setTranslateX(30*wRatioOfScreen);
		on.setTranslateY(50*hRatioOfScreen);
		off.setTranslateX(30*wRatioOfScreen);
		off.setTranslateY(50*hRatioOfScreen);
		off.setFitHeight(100*hRatioOfScreen);
		off.setFitWidth(300*wRatioOfScreen);
		settingsPane.getChildren().addAll(on);
		on.setOnMouseClicked(e->{					//when clicked changes the current status
			settingsPane.getChildren().remove(on);
			settingsPane.getChildren().add(off);
			
		});		
		off.setOnMouseClicked(e->{
			settingsPane.getChildren().remove(off);
			settingsPane.getChildren().add(on);
		});
		
		settingsPane.setTranslateY(400*hRatioOfScreen);
		settingsPane.setTranslateX(350*wRatioOfScreen);
		
		root.getChildren().add(settingsPane);
		
		// set on menu button clicked:
		exit.setOnMouseClicked(e->{
			playClick();
			
			Rectangle black=new Rectangle(Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
			black.setFill(Color.BLACK);
			black.setOpacity(0.5);						//darkers the screen
			ImageView exitpic=new ImageView(x);
			exitpic.setFitHeight(300*hRatioOfScreen);
			exitpic.setFitWidth(500*wRatioOfScreen);
			int f=(int) ((Screen.getPrimary().getBounds().getWidth()/2-250)*wRatioOfScreen);	//middle points
			int k=(int) ((Screen.getPrimary().getBounds().getHeight()/2-150)*hRatioOfScreen);
			exitpic.setTranslateX(f);
			exitpic.setTranslateY(k);
			ImageView cont=new ImageView(stay);		//adding buttons
			ImageView quit=new ImageView(leave);
			cont.setFitHeight(120*hRatioOfScreen);
			cont.setFitWidth(200*wRatioOfScreen);			//sizing the quit and cont image 
			quit.setFitHeight(120*hRatioOfScreen);
			quit.setFitWidth(200*wRatioOfScreen);
			cont.setTranslateX(f+30*wRatioOfScreen);
			quit.setTranslateX(f+270*wRatioOfScreen);		//placing them into their position close to middle
			cont.setTranslateY(k+150*hRatioOfScreen);
			quit.setTranslateY(k+150*hRatioOfScreen);
			Text sure=new Text("Are you sure to leave?");		// :)
			sure.setFont(Font.font(50));
			sure.setTranslateX(f+10*wRatioOfScreen);
			sure.setTranslateY(k+100*hRatioOfScreen);
			quit.setOnMouseClicked(ev->arg0.close());
			cont.setOnMouseClicked(eve->{
				root.getChildren().removeAll(black,exitpic,cont,quit,sure);		//removing all when 
			});
			
			
			root.getChildren().addAll(black,exitpic,cont,quit,sure);	//adding 
		});
		
		settings.setOnMouseClicked(e->{
			TranslateTransition tt=new TranslateTransition(Duration.seconds(1), levels);		//moves the levels pane which include all levels
			TranslateTransition tt2=new TranslateTransition(Duration.seconds(1), settingsPane);	//moves the settings pane
			
			buttons.getChildren().removeAll(play,play2,settings,settings,exit);		//removes all buttons inside of menu	
			buttons.getChildren().addAll(play,settings2,exit);						//and adding the buttons we need again
				tt.setToX(350*wRatioOfScreen);		//moves that to back of menu pane so we wont see it
				tt.play();
				tt2.setToX(799*wRatioOfScreen);	//moves till it seems
				tt2.play();
				playClick();
			
		});
		settings2.setOnMouseClicked(e->{
			TranslateTransition tt=new TranslateTransition(Duration.seconds(1), levels);
			TranslateTransition tt2=new TranslateTransition(Duration.seconds(1), settingsPane);
			
			buttons.getChildren().removeAll(play,play2,settings,settings2,exit);
			buttons.getChildren().addAll(play,settings,exit);
				tt.setToX(350*wRatioOfScreen);			//moves that to back of menu pane so we wont see it
				tt.play();
				tt2.setToX(350*wRatioOfScreen);		//moves that to back of menu pane so we wont see it
				tt2.play();
				playClick();
		});
		
		play.setOnMouseClicked(e->{		//open levels pane when play button clicked
			TranslateTransition tt=new TranslateTransition(Duration.seconds(1), levels);
			TranslateTransition tt2=new TranslateTransition(Duration.seconds(1), settingsPane);
			
			buttons.getChildren().removeAll(play,play2,settings,settings2,exit);	//removing all again
			buttons.getChildren().addAll(play2,settings,exit);						//and adding the ones we need
				tt2.setToX(350*wRatioOfScreen);	
				tt2.play();
				tt.setToX(799*wRatioOfScreen);		//same as before but this time we move levels pane in order to make it possible to click
				tt.play();
				playClick();
			
		});
		play2.setOnMouseClicked(e->{
			TranslateTransition tt=new TranslateTransition(Duration.seconds(1), levels);
			TranslateTransition tt2=new TranslateTransition(Duration.seconds(1), settingsPane);
		
			buttons.getChildren().removeAll(play,play2,settings,settings2,exit);
			buttons.getChildren().addAll(play,settings,exit);
			tt2.setToX(350*wRatioOfScreen);		//hiding buttons
			tt2.play();
			tt.setToX(350*wRatioOfScreen);			//hiding buttons
			tt.play();
			playClick();
			
		});
		
		
		//end of button clicks
		//buraya kadar yaptýk çarpma iþlemini
		
		
		lv1.setOnMouseClicked(e->{		//open the lv1 when lv1 image is clicked
			if(whichLv>=1) {
				TranslateTransition tt=new TranslateTransition(Duration.seconds(3), buttons);	//moves all panes on screen such as buttons pane,settinsPane,levels
				tt.setToX(-800);
				tt.play();
				
				
				System.out.println("yapman lazýmsa yap burda da");
				
				TranslateTransition tt2=new TranslateTransition(Duration.seconds(3), settingsPane);		//and background picture which is picback
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt3=new TranslateTransition(Duration.seconds(3), levels);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt4=new TranslateTransition(Duration.seconds(3), picback);
				tt.setToX(-800);
				tt.play();
				tt2.setToX(-800);
				tt2.play();
				tt3.setToX(-800);
				tt3.play();
				tt4.setToX(-800);
				tt4.play();
				
				tt4.setOnFinished(event->{			//when those all completed their moves new panes from button will start to move
					
					Primary.input(allLvs[0],300,150);		//allLvs is pane  which includes all lvs and 0th object is url of lv1
					tile.bigPane.setTranslateX(300);
					ImageView secondlayer=new ImageView(pic);		//another layer of background
					root.getChildren().add(secondlayer);
					ImageView backw=new ImageView(back);		//and positioning it
					backw.setFitHeight(75);
					backw.setFitWidth(90);
					
					backw.setOnMouseClicked(ev->{
						buttons.getChildren().removeAll(play,play2,settings,settings2,exit);	//removing all buttons in menu again
						buttons.getChildren().addAll(play,settings,exit);						//and adding them again
						TranslateTransition tt6=new TranslateTransition(Duration.seconds(1),buttons);		//moves panes to their original position
						TranslateTransition tt7=new TranslateTransition(Duration.seconds(1),settingsPane);	//when we clicked back button
						TranslateTransition tt8=new TranslateTransition(Duration.seconds(1),levels);
						TranslateTransition tt9=new TranslateTransition(Duration.seconds(1),picback);
						tt6.setToX(0);
						tt7.setToX(350);		//their original positions
						tt8.setToX(350);
						tt9.setToX(0);
						tt6.play();
						tt7.play();
						tt8.play();
						tt9.play();
						
						TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
						t10.setToX(2000);
						t10.setToY(1000);
						t10.play();
						
						root.getChildren().removeAll(secondlayer,backw,tile.bigPane,newPane.bigPane3);	//bigpane3 is pane which contains counter
						tile.deletePane();	//make it all tiles 0
					});
					tile.bigPane.setTranslateY(Screen.getPrimary().getBounds().getHeight());	//places it from bottom of screen
					root.getChildren().add(tile.bigPane);
					TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);	//and moves it to its place
					root.getChildren().add(backw);

					newPane.bigPane3.setTranslateX(800);
					root.getChildren().add(newPane.bigPane3);		//adding moves counter
					
					t10.setToX(300);
					t10.setToY(150);
					t10.play();
					
				});
				
			}
		});
		lv4.setOnMouseClicked(e->{		//same as before 
			if(whichLv>=4) {
				TranslateTransition tt=new TranslateTransition(Duration.seconds(3), buttons);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt2=new TranslateTransition(Duration.seconds(3), settingsPane);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt3=new TranslateTransition(Duration.seconds(3), levels);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt4=new TranslateTransition(Duration.seconds(3), picback);
				tt.setToX(-800);
				tt.play();
				tt2.setToX(-800);
				tt2.play();
				tt3.setToX(-800);
				tt3.play();
				tt4.setToX(-800);
				tt4.play();
				
				tt4.setOnFinished(event->{
					
					Primary.input("levels/level4.txt",300,150);
					tile.bigPane.setTranslateX(300);
					ImageView secondlayer=new ImageView(pic);
					root.getChildren().add(secondlayer);
					ImageView backw=new ImageView(back);	
					backw.setFitHeight(75);
					backw.setFitWidth(90);
					
					backw.setOnMouseClicked(ev->{
						buttons.getChildren().removeAll(play,play2,settings,settings2,exit);
						buttons.getChildren().addAll(play,settings,exit);
						TranslateTransition tt6=new TranslateTransition(Duration.seconds(1),buttons);
						TranslateTransition tt7=new TranslateTransition(Duration.seconds(1),settingsPane);
						TranslateTransition tt8=new TranslateTransition(Duration.seconds(1),levels);
						TranslateTransition tt9=new TranslateTransition(Duration.seconds(1),picback);
						tt6.setToX(0);
						tt7.setToX(350);
						tt8.setToX(350);
						tt9.setToX(0);
						tt6.play();
						tt7.play();
						tt8.play();
						tt9.play();
						
						TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
						t10.setToX(2000);
						t10.setToY(1000);
						t10.play();
						
						root.getChildren().removeAll(secondlayer,backw,tile.bigPane,newPane.bigPane3);
						tile.deletePane();
					});
					tile.bigPane.setTranslateY(Screen.getPrimary().getBounds().getHeight());
					root.getChildren().add(tile.bigPane);
					TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
					root.getChildren().add(backw);

					newPane.bigPane3.setTranslateX(800);
					root.getChildren().add(newPane.bigPane3);
					
					t10.setToX(300);
					t10.setToY(150);
					t10.play();
					
				});
				
			}
		});
		lv3.setOnMouseClicked(e->{		//just dont to such things finish it before deadline
			if(whichLv>=3) {
				TranslateTransition tt=new TranslateTransition(Duration.seconds(3), buttons);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt2=new TranslateTransition(Duration.seconds(3), settingsPane);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt3=new TranslateTransition(Duration.seconds(3), levels);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt4=new TranslateTransition(Duration.seconds(3), picback);
				tt.setToX(-800);
				tt.play();
				tt2.setToX(-800);
				tt2.play();
				tt3.setToX(-800);
				tt3.play();
				tt4.setToX(-800);
				tt4.play();
				
				tt4.setOnFinished(event->{
					
					Primary.input("levels/level3.txt",300,150);
					tile.bigPane.setTranslateX(300);
					ImageView secondlayer=new ImageView(pic);
					root.getChildren().add(secondlayer);
					ImageView backw=new ImageView(back);	
					backw.setFitHeight(75);
					backw.setFitWidth(90);
					
					backw.setOnMouseClicked(ev->{
						buttons.getChildren().removeAll(play,play2,settings,settings2,exit);
						buttons.getChildren().addAll(play,settings,exit);
						TranslateTransition tt6=new TranslateTransition(Duration.seconds(1),buttons);
						TranslateTransition tt7=new TranslateTransition(Duration.seconds(1),settingsPane);
						TranslateTransition tt8=new TranslateTransition(Duration.seconds(1),levels);
						TranslateTransition tt9=new TranslateTransition(Duration.seconds(1),picback);
						tt6.setToX(0);
						tt7.setToX(350);
						tt8.setToX(350);
						tt9.setToX(0);
						tt6.play();
						tt7.play();
						tt8.play();
						tt9.play();
						
						TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
						t10.setToX(2000);
						t10.setToY(1000);
						t10.play();
						
						root.getChildren().removeAll(secondlayer,backw,tile.bigPane,newPane.bigPane3);
						tile.deletePane();
					});
					tile.bigPane.setTranslateY(Screen.getPrimary().getBounds().getHeight());
					root.getChildren().add(tile.bigPane);
					TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
					root.getChildren().add(backw);

					newPane.bigPane3.setTranslateX(800);
					root.getChildren().add(newPane.bigPane3);
					
					t10.setToX(300);
					t10.setToY(150);
					t10.play();
					
				});
				
			}
		});
		lv5.setOnMouseClicked(e->{		//just dont to such things finish it before deadline
			if(whichLv>=5) {
				TranslateTransition tt=new TranslateTransition(Duration.seconds(3), buttons);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt2=new TranslateTransition(Duration.seconds(3), settingsPane);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt3=new TranslateTransition(Duration.seconds(3), levels);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt4=new TranslateTransition(Duration.seconds(3), picback);
				tt.setToX(-800);
				tt.play();
				tt2.setToX(-800);
				tt2.play();
				tt3.setToX(-800);
				tt3.play();
				tt4.setToX(-800);
				tt4.play();
				
				tt4.setOnFinished(event->{
					
					Primary.input("levels/level5.txt",300,150);
					tile.bigPane.setTranslateX(300);
					ImageView secondlayer=new ImageView(pic);
					root.getChildren().add(secondlayer);
					ImageView backw=new ImageView(back);	
					backw.setFitHeight(75);
					backw.setFitWidth(90);
					
					backw.setOnMouseClicked(ev->{
						buttons.getChildren().removeAll(play,play2,settings,settings2,exit);
						buttons.getChildren().addAll(play,settings,exit);
						TranslateTransition tt6=new TranslateTransition(Duration.seconds(1),buttons);
						TranslateTransition tt7=new TranslateTransition(Duration.seconds(1),settingsPane);
						TranslateTransition tt8=new TranslateTransition(Duration.seconds(1),levels);
						TranslateTransition tt9=new TranslateTransition(Duration.seconds(1),picback);
						tt6.setToX(0);
						tt7.setToX(350);
						tt8.setToX(350);
						tt9.setToX(0);
						tt6.play();
						tt7.play();
						tt8.play();
						tt9.play();
						
						TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
						t10.setToX(2000);
						t10.setToY(1000);
						t10.play();
						
						root.getChildren().removeAll(secondlayer,backw,tile.bigPane,newPane.bigPane3);
						tile.deletePane();
					});
					tile.bigPane.setTranslateY(Screen.getPrimary().getBounds().getHeight());
					root.getChildren().add(tile.bigPane);
					TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
					root.getChildren().add(backw);

					newPane.bigPane3.setTranslateX(800);
					root.getChildren().add(newPane.bigPane3);
					
					t10.setToX(300);
					t10.setToY(150);
					t10.play();
					
				});
				
			}
		});
		lv6.setOnMouseClicked(e->{		//nothing before no lv6 butt soon we will add it
			if(whichLv>=6) {
				System.out.println("Coming soon");
			}
		});
		
		
		
		lv2.setOnMouseClicked(e->{		//doing same but different input/position
			System.out.println("is isinde");
			if(whichLv>=2) {

				TranslateTransition tt=new TranslateTransition(Duration.seconds(3), buttons);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt2=new TranslateTransition(Duration.seconds(3), settingsPane);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt3=new TranslateTransition(Duration.seconds(3), levels);
				tt.setToX(-800);
				tt.play();
				TranslateTransition tt4=new TranslateTransition(Duration.seconds(3), picback);
				tt.setToX(-800);
				tt.play();
				tt2.setToX(-800);
				tt2.play();
				tt3.setToX(-800);
				tt3.play();
				tt4.setToX(-800);
				tt4.play();
				
				tt4.setOnFinished(event->{
					
					Primary.input("levels/level2.txt",300,150);
					tile.bigPane.setTranslateX(300);
					ImageView secondlayer=new ImageView(pic);
					root.getChildren().add(secondlayer);
					ImageView backw=new ImageView(back);	
					backw.setFitHeight(75);
					backw.setFitWidth(90);
					
					backw.setOnMouseClicked(ev->{
						buttons.getChildren().removeAll(play,play2,settings,settings2,exit);
						buttons.getChildren().addAll(play,settings,exit);
						TranslateTransition tt6=new TranslateTransition(Duration.seconds(1),buttons);
						TranslateTransition tt7=new TranslateTransition(Duration.seconds(1),settingsPane);
						TranslateTransition tt8=new TranslateTransition(Duration.seconds(1),levels);
						TranslateTransition tt9=new TranslateTransition(Duration.seconds(1),picback);
						tt6.setToX(0);
						tt7.setToX(350);
						tt8.setToX(350);
						tt9.setToX(0);
						tt6.play();
						tt7.play();
						tt8.play();
						tt9.play();
						
						TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
						t10.setToX(2000);
						t10.setToY(1000);
						t10.play();
						
						root.getChildren().removeAll(secondlayer,backw,tile.bigPane,newPane.bigPane3);
						tile.deletePane();
					});
					tile.bigPane.setTranslateY(Screen.getPrimary().getBounds().getHeight());
					root.getChildren().add(tile.bigPane);
					TranslateTransition t10=new TranslateTransition(Duration.seconds(1),tile.bigPane);
					root.getChildren().add(backw);

					newPane.bigPane3.setTranslateX(800);
					root.getChildren().add(newPane.bigPane3);
					
					t10.setToX(300);
					t10.setToY(150);
					t10.play();
					
				});
				
			}
		});
		
		//adding menu buttons and etc
		menu.getChildren().add(picback);			//background picture
		buttons.getChildren().addAll(play,settings,exit);
		menu.getChildren().add(buttons);
		root.getChildren().add(menu);
		menu.setTranslateX(200);		//moves a little after adding panes where they belong
		menu.setTranslateY(150);
		
		
		Scene sc=new Scene(root);
		
		arg0.setScene(sc);
	//	arg0.initStyle(StageStyle.UNDECORATED);
		arg0.setFullScreen(true);
		arg0.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);	//since our background picture is pretty awesome we suggest playing in full screen
		arg0.show();
	}

	void setup1(ImageView hmm) {	//give them a shape
		hmm.setFitWidth(500);
		hmm.setFitHeight(200);
		hmm.setTranslateX(50);
		hmm.setTranslateY(50);
	}

	static void checkWhichLv(String lm) {		//checking position input to learn which lv it is
		for(int f=0;f<5;f++) {
			if(allLvs[f].equals(lm)) {
				setLvs(f);
				System.out.println(f);
			}
		}
	}

	private static void setLvs(int f) {
		f+=2;	//since f is array position 
		
		if(f>whichLv) {		//if current lv is higher than that do nothing
			levels.getChildren().removeAll(lv1,lv2l,lv3l,lv4l,lv5l,lv6l,lv2,lv3,lv4,lv5,lv6);	//deleting lvs from pane
			if(f==6)
				levels.getChildren().addAll(lv1,lv2,lv3,lv4,lv5,lv6);		//adding buttons according to which lv
			if(f==5)
				levels.getChildren().addAll(lv1,lv2,lv3,lv4,lv5,lv6l);
			if(f==4)
				levels.getChildren().addAll(lv1,lv2,lv3,lv4,lv5l,lv6l);
			if(f==3)
				levels.getChildren().addAll(lv1,lv2,lv3,lv4l,lv5l,lv6l);
			if(f==2) 
				levels.getChildren().addAll(lv1,lv2,lv3l,lv4l,lv5l,lv6l);
			if(f==1)
				levels.getChildren().addAll(lv1,lv2l,lv3l,lv4l,lv5l,lv6l);
			
			whichLv=f;
		}
		
	}
	public void playClick(){
		MediaPlayer mediaPlayer;
		String path = "Click.mp3";

		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.play();
	}
}






