package Netflix;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	Button searchButton = new Button("Search");
	TextArea ta1 = new TextArea();
	Label resultLabel = new Label("Results");
	double resultWidth = 400;
	double resultHeight = 400;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			manager = buildGui();
			Scene scene = new Scene(manager, 614, 600);
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
		up.setMinHeight(35);//styling for height
		up.setMaxWidth(Double.MAX_VALUE);//styling for width
		cat.setTop(up);
		
		Button down = buildDown();
		down.setMinHeight(35);//styling for height
		down.setMaxWidth(Double.MAX_VALUE);//styling for width
		cat.setBottom(down);
		
		Button left = buildLeft();
		left.setMaxHeight(Double.MAX_VALUE);//styling for height
		left.setMinWidth(56);
		left.setMaxWidth(56);//styling for width
		cat.setLeft(left);
		
		Button right = buildRight();
		right.setMaxHeight(Double.MAX_VALUE);//styling for height
		right.setMinWidth(56);
		right.setMaxWidth(56);//styling for width
		cat.setRight(right);
		
		VBox disp = buildDisp();
		cat.setCenter(disp);
		
		return cat;
	}
	
	private Button buildUp() {
		Button up = new Button("Up");
		upEventHandler up1 = new upEventHandler();
		up.setOnAction(up1);
		return up;
	}

	private Button buildDown() {
		Button down = new Button("Down");
		downEventHandler down1 = new downEventHandler();
		down.setOnAction(down1);
		return down;
	}

	private Button buildLeft() {
		Button left = new Button("Left");
		leftEventHandler left1 = new leftEventHandler();
		left.setOnAction(left1);
		return left;
	}

	private Button buildRight() {
		Button right = new Button("Right");
		rightEventHandler right1 = new rightEventHandler();
		right.setOnAction(right1);
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
		
		row1T1.setMinWidth(100);
		row1T1.setMaxWidth(100);
		row1T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T1);
		
		row1T2.setMinWidth(100);
		row1T2.setMaxWidth(100);
		row1T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T2);
		temp = temp.getNext();
		
		row1T3.setMinWidth(100);
		row1T3.setMaxWidth(100);
		row1T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T3);
		temp = temp.getNext();
		
		row1T4.setMinWidth(100);
		row1T4.setMaxWidth(100);
		row1T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T4);
		temp = temp.getNext();
		
		row1T5.setMinWidth(100);
		row1T5.setMaxWidth(100);
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
		
		row2T1.setMinWidth(100);
		row2T1.setMaxWidth(100);
		row2T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T1);
		temp = temp.getNext();
		
		row2T2.setMinWidth(100);
		row2T2.setMaxWidth(100);
		row2T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T2);
		temp = temp.getNext();
		
		row2T3.setMinWidth(100);
		row2T3.setMaxWidth(100);
		row2T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T3);
		temp = temp.getNext();
		
		row2T4.setMinWidth(100);
		row2T4.setMaxWidth(100);
		row2T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T4);
		temp = temp.getNext();
		
		row2T5.setMinWidth(100);
		row2T5.setMaxWidth(100);
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
		
		row3T1.setMinWidth(100);
		row3T1.setMaxWidth(100);
		row3T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T1);
		temp = temp.getNext();
		
		row3T2.setMinWidth(100);
		row3T2.setMaxWidth(100);
		row3T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T2);
		temp = temp.getNext();
		
		row3T3.setMinWidth(100);
		row3T3.setMaxWidth(100);
		row3T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T3);
		temp = temp.getNext();
		
		row3T4.setMinWidth(100);
		row3T4.setMaxWidth(100);
		row3T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T4);
		temp = temp.getNext();
		
		row3T5.setMinWidth(100);
		row3T5.setMaxWidth(100);
		row3T5.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T5);
		
		return list;
	}
	
	private Pane buildTab2Content() {
		GridPane search = new GridPane();
		search.setVgap(5);
		search.add(searchLabel, 4, 0);
		search.add(tb1, 4,1);
		searchEventHandler seh1 = new searchEventHandler();
		searchButton.setOnAction(seh1);
		search.add(searchButton, 4,3);
		search.add(resultLabel, 4, 5);
		search.add(ta1, 4, 7);
		searchButton.setDefaultButton(true);
		ta1.setPrefWidth(resultWidth);
		ta1.setEditable(false);
		return search;
	}
	//Event handler for search button
	private class searchEventHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent e) {
			if (ta1.getText() != "") {
				ta1.clear();
			}
			ArrayList<Movie> results = new ArrayList<Movie>();
			if (tb1.getText().equals("")) {
				ta1.appendText("No movie input. \n");
				tb1.clear();
			}
			else {
				String movieSearch = tb1.getText();
				results = netflix.searchAll(movieSearch);
				if (results.isEmpty() == true){
					ta1.appendText("Movie not found");
				}
				else {
					for (Movie m: results) {
						String title = m.getTitle();
						String rating = m.getRating();
						String genre = m.getGenre();
						int year = m.getYear();
						int score = m.getScore();
						
						ta1.appendText(title + " " + rating + " " + genre + " " +  year + " " + score + "\n");
					}
				}
				tb1.clear();
			}
		}
	}
	private class upEventHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
		}
	}
	
	private class downEventHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			
		}
	}
	
	private class leftEventHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			
		}
	}
	private class rightEventHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
