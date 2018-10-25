package Netflix;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NetflixApp extends Application {
	TabPane tab = new TabPane();
	Pane manager = new Pane();
	Netflix netflix = new Netflix();
	
	@SuppressWarnings("rawtypes")
	Node<CircularDoublyLinkedList> currentCat = netflix.getCategories().getHead();
	@SuppressWarnings("unchecked")
	Node<Movie> currentMovie = currentCat.getElement().getHead();
	
	Tab tab1 = new Tab();
	Label infoTxt = new Label("");
	HBox row1 = new HBox();
	HBox row2 = new HBox();
	HBox row3 = new HBox();
	
	Tab tab2 = new Tab();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			manager = buildGui();
			Scene scene = new Scene(manager, 600, 500);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Data-flix");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Pane buildGui() {
		Pane manager = buildTabs();
		return manager;
	}
	
	private Pane buildTabs() {
		BorderPane brdPane = new BorderPane();
		tab.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
		tab1.setText("Home");
		tab1.setContent(buildTab1Content());
		
		tab2.setText("Search");
		tab2.setContent(buildTab2Content());
		
		tab.getTabs().addAll(tab1, tab2);
		
		brdPane.setCenter(tab);
		return brdPane;
	}
	
	private Pane buildTab1Content() {
		VBox home = new VBox();
		home.setSpacing(5);
		
		VBox info = buildInfo();
		home.getChildren().add(info);
		
		BorderPane categories = buildCatPane();
		home.getChildren().add(categories);
		
		return home;
	}
	
	private VBox buildInfo() {
		VBox info = new VBox();
		
		Label curMov = new Label("Current Movie: ");
		info.getChildren().add(curMov);
		
		infoTxt.setText("\t\t" + currentMovie.getElement().toString());
		info.getChildren().add(infoTxt);
		return info;
	}
	
	private BorderPane buildCatPane() {
		BorderPane cat = new BorderPane();
		
		Button up = buildUp();
		cat.setTop(up);
		Button down = buildDown();
		cat.setBottom(down);
		Button left = buildLeft();
		cat.setLeft(left);
		Button right = buildRight();
		cat.setRight(right);
		
		VBox disp = buildDisp();
		cat.setCenter(disp);
		
		return cat;
	}
	
	private Button buildUp() {
		Button up = new Button("Up");
		return up;
	}

	private Button buildDown() {
		Button down = new Button("Down");
		return down;
	}

	private Button buildLeft() {
		Button left = new Button("Left");
		return left;
	}

	private Button buildRight() {
		Button right = new Button("Right");
		return right;
	}
	
	private VBox buildDisp() {
		VBox disp = new VBox();
		
		row1 = buildRow1();
		row2 = buildRow2();
		row3 = buildRow3();
		
		return disp;
	}
	
	private HBox buildRow1() {
		HBox row = new HBox();
		
		
		return row;
	}
	
	private HBox buildRow2() {
		HBox row = new HBox();
		
		return row;
	}
	
	private HBox buildRow3() {
		HBox row = new HBox();
		
		return row;
	}
	
	private Pane buildTab2Content() {
		GridPane search = new GridPane();
		
		return search;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
