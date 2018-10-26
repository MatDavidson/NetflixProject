package Netflix;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
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
	int height = 100;
	int width = 100;
	
	@SuppressWarnings("rawtypes")
	Node<CircularDoublyLinkedList> currentCat = netflix.getCategories().getHead();
	@SuppressWarnings("unchecked")
	Node<Movie> currentMovie = currentCat.getElement().getHead();
	
	Tab tab1 = new Tab();
		Label infoLbl = new Label("");
	
		VBox row1 = new VBox();
		Label r1Lbl = new Label("");
		HBox row1List = new HBox();
		Button row1T1 = new Button("");
		Button row1T2 = new Button("");
		Button row1T3 = new Button("");
		Button row1T4 = new Button("");
		Button row1T5 = new Button("");
	
		VBox row2 = new VBox();
		Label r2Lbl = new Label("");
		HBox row2List = new HBox();
		Button row2T1 = new Button("");
		Button row2T2 = new Button("");
		Button row2T3 = new Button("");
		Button row2T4 = new Button("");
		Button row2T5 = new Button("");
	
		VBox row3 = new VBox();
		Label r3Lbl = new Label("");
		HBox row3List = new HBox();
		Button row3T1 = new Button("");
		Button row3T2 = new Button("");
		Button row3T3 = new Button("");
		Button row3T4 = new Button("");
		Button row3T5 = new Button("");

	Tab tab2 = new Tab();
		TextField tb1 = new TextField();
		Label searchLabel = new Label("Search for movies");
	
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
		
		infoLbl.setText(currentMovie.getElement().toString());
		info.getChildren().add(infoLbl);
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
		disp.getChildren().add(row1);
		
		row2 = buildRow2();
		disp.getChildren().add(row2);
		
		row3 = buildRow3();
		disp.getChildren().add(row3);
		
		return disp;
	}
	
	private VBox buildRow1() {
		VBox row = new VBox();
		
		r1Lbl.setText(currentCat.getElement().getName());
		row.getChildren().add(r1Lbl);
		
		row1List = buildRow1List();
		row.getChildren().add(row1List);
		
		return row;
	}
	
	private HBox buildRow1List() {
		HBox list = new HBox();
		
		Node<Movie> temp = currentMovie.getNext();
		
		row1T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T1);
		
		row1T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T2);
		temp = temp.getNext();
		
		row1T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T3);
		temp = temp.getNext();
		
		row1T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T4);
		temp = temp.getNext();
		
		row1T5.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T5);
		
		return list;
	}
	
	private VBox buildRow2() {
		VBox row = new VBox();
		
		r2Lbl.setText(currentCat.getNext().getElement().getName());
		row.getChildren().add(r2Lbl);
		
		row2List = buildRow2List();
		row.getChildren().add(row2List);
		
		return row;
	}
	
	private HBox buildRow2List() {
		HBox list = new HBox();
		
		@SuppressWarnings("unchecked")
		Node<Movie> temp = currentCat.getNext().getElement().getHead();
		
		row2T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T1);
		temp = temp.getNext();
		
		row2T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T2);
		temp = temp.getNext();
		
		row2T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T3);
		temp = temp.getNext();
		
		row2T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T4);
		temp = temp.getNext();
		
		row2T5.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T5);
		
		return list;
	}
	
	private VBox buildRow3() {
		VBox row = new VBox();
		
		r3Lbl.setText(currentCat.getNext().getNext().getElement().getName());
		row.getChildren().add(r3Lbl);
		
		row3List = buildRow3List();
		row.getChildren().add(row3List);
		
		return row;
	}
	
	private HBox buildRow3List() {
		HBox list = new HBox();
		
		@SuppressWarnings("unchecked")
		Node<Movie> temp = currentCat.getNext().getNext().getElement().getHead();
		
		row3T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T1);
		temp = temp.getNext();
		
		row3T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T2);
		temp = temp.getNext();
		
		row3T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T3);
		temp = temp.getNext();
		
		row3T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T4);
		temp = temp.getNext();
		
		row3T5.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T5);
		
		return list;
	}
	
	private Pane buildTab2Content() {
		GridPane search = new GridPane();
		search.add(searchLabel, 0, 0);
		search.add(tb1, 0,1);
		return search;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
