package Netflix;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
	
	Node<Movie> actLast = netflix.act.getHead();
	Node<Movie> advLast = netflix.adv.getHead();
	Node<Movie> aniLast = netflix.ani.getHead();
	Node<Movie> bioLast = netflix.bio.getHead();
	Node<Movie> comLast = netflix.com.getHead();
	Node<Movie> criLast = netflix.cri.getHead();
	Node<Movie> draLast = netflix.dra.getHead();
	Node<Movie> famLast = netflix.fam.getHead();
	Node<Movie> fanLast = netflix.fan.getHead();
	Node<Movie> hisLast = netflix.his.getHead();
	Node<Movie> horLast = netflix.hor.getHead();
	Node<Movie> musLast = netflix.mus.getHead();
	Node<Movie> mysLast = netflix.mys.getHead();
	Node<Movie> romLast = netflix.rom.getHead();
	Node<Movie> sciLast = netflix.sci.getHead();
	Node<Movie> spoLast = netflix.spo.getHead();
	Node<Movie> thrLast = netflix.thr.getHead();
	Node<Movie> warLast = netflix.war.getHead();
	Node<Movie> wesLast = netflix.wes.getHead();
	
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
		double resultWidth = 500;
		double resultHeight = 150;	
		
		Button commonButton = new Button("Go");
		CheckBox actBox = new CheckBox("Action         ");
		CheckBox advBox = new CheckBox("Adventure      ");
		CheckBox aniBox = new CheckBox("Animation      ");
		CheckBox bioBox = new CheckBox("Biography      ");
		CheckBox comBox = new CheckBox("Comedy         ");
		CheckBox criBox = new CheckBox("Crime          ");
		CheckBox draBox = new CheckBox("Drama          ");
		CheckBox famBox = new CheckBox("Family         ");
		CheckBox fanBox = new CheckBox("Fantasy        ");
		CheckBox hisBox = new CheckBox("History        ");
		CheckBox horBox = new CheckBox("Horror         ");
		CheckBox musBox = new CheckBox("Music          ");
		CheckBox mysBox = new CheckBox("Mystery        ");
		CheckBox romBox = new CheckBox("Romance        ");
		CheckBox sciBox = new CheckBox("Science Fiction");
		CheckBox spoBox = new CheckBox("Sports         ");
		CheckBox thrBox = new CheckBox("Thriller       ");
		CheckBox warBox = new CheckBox("War            ");
		CheckBox wesBox = new CheckBox("Western        ");
		
		List<CheckBox> boxes = new ArrayList<CheckBox>();
		
		
	
	@Override
	public void start(Stage primaryStage) {
		try {
			manager = buildGui();
			Scene scene = new Scene(manager, 614, 400);
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
		up.setStyle("-fx-base: black");
		upEventHandler up1 = new upEventHandler();
		up.setOnAction(up1);
		return up;
	}

	private Button buildDown() {
		Button down = new Button("Down");
		down.setStyle("-fx-base: black");
		downEventHandler down1 = new downEventHandler();
		down.setOnAction(down1);
		return down;
	}

	private Button buildLeft() {
		Button left = new Button("Left");
		left.setStyle("-fx-base: black");
		leftEventHandler left1 = new leftEventHandler();
		left.setOnAction(left1);
		return left;
	}

	private Button buildRight() {
		Button right = new Button("Right");
		right.setStyle("-fx-base: black");
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
		
		//for changing color of button
		row1T1.setStyle("-fx-base: red");
		row1T1.setMinWidth(100);
		row1T1.setMaxWidth(100);
		row1T1.setText(currentMovie.getElement().getTitle());
		list.getChildren().add(row1T1);
		
		row1T2.setStyle("-fx-base: red");
		row1T2.setMinWidth(100);
		row1T2.setMaxWidth(100);
		row1T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T2);
		temp = temp.getNext();
		
		row1T3.setStyle("-fx-base: red");
		row1T3.setMinWidth(100);
		row1T3.setMaxWidth(100);
		row1T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T3);
		temp = temp.getNext();
		
		row1T4.setStyle("-fx-base: red");
		row1T4.setMinWidth(100);
		row1T4.setMaxWidth(100);
		row1T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row1T4);
		temp = temp.getNext();
		
		row1T5.setStyle("-fx-base: red");
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
		
		row2T1.setStyle("-fx-base: red");
		row2T1.setMinWidth(100);
		row2T1.setMaxWidth(100);
		row2T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T1);
		temp = temp.getNext();
		
		row2T2.setStyle("-fx-base: red");
		row2T2.setMinWidth(100);
		row2T2.setMaxWidth(100);
		row2T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T2);
		temp = temp.getNext();
		
		row2T3.setStyle("-fx-base: red");
		row2T3.setMinWidth(100);
		row2T3.setMaxWidth(100);
		row2T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T3);
		temp = temp.getNext();
		
		row2T4.setStyle("-fx-base: red");
		row2T4.setMinWidth(100);
		row2T4.setMaxWidth(100);
		row2T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row2T4);
		temp = temp.getNext();
		
		row2T5.setStyle("-fx-base: red");
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
		
		row3T1.setStyle("-fx-base: red");
		row3T1.setMinWidth(100);
		row3T1.setMaxWidth(100);
		row3T1.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T1);
		temp = temp.getNext();
		
		row3T2.setStyle("-fx-base: red");
		row3T2.setMinWidth(100);
		row3T2.setMaxWidth(100);
		row3T2.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T2);
		temp = temp.getNext();
		
		row3T3.setStyle("-fx-base: red");
		row3T3.setMinWidth(100);
		row3T3.setMaxWidth(100);
		row3T3.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T3);
		temp = temp.getNext();
		
		row3T4.setStyle("-fx-base: red");
		row3T4.setMinWidth(100);
		row3T4.setMaxWidth(100);
		row3T4.setText(temp.getElement().getTitle());
		list.getChildren().add(row3T4);
		temp = temp.getNext();
		
		row3T5.setStyle("-fx-base: red");
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
		searchButton.setStyle("-fx-base: red");
		searchButton.setOnAction(seh1);
		search.add(searchButton, 4,3);
		search.add(resultLabel, 4, 5);
		search.add(ta1, 4, 7);
		searchButton.setDefaultButton(true);
		ta1.setPrefWidth(resultWidth);
		ta1.setPrefHeight(resultHeight);
		ta1.setEditable(false);
		
		Label commonLbl = new Label("Movies in common");
		search.add(commonLbl, 6, 0);
		FlowPane common = buildCommon();
		search.add(common, 6, 1);
		search.add(commonButton, 6, 3);
		commonButton.setStyle("-fx-base: red");
		commonButton.setOnAction(new commonEventHandler());
		return search;
	}
	
	private FlowPane buildCommon() {
		FlowPane common = new FlowPane();
				
		common.getChildren().add(actBox);
		common.getChildren().add(advBox);
		common.getChildren().add(aniBox);
		common.getChildren().add(bioBox);
		common.getChildren().add(comBox);
		common.getChildren().add(criBox);
		common.getChildren().add(draBox);
		common.getChildren().add(famBox);
		common.getChildren().add(fanBox);
		common.getChildren().add(hisBox);
		common.getChildren().add(horBox);
		common.getChildren().add(musBox);
		common.getChildren().add(mysBox);
		common.getChildren().add(romBox);
		common.getChildren().add(sciBox);
		common.getChildren().add(spoBox);
		common.getChildren().add(thrBox);
		common.getChildren().add(warBox);
		common.getChildren().add(wesBox);
		
		return common;
	}
		
	public void setLastMov() {
		switch (currentCat.getElement().getName()) {
		case "Action":
			actLast = currentMovie;
			break;
		case "Adventure":
			advLast = currentMovie;
			break;
		case "Animation":
			aniLast = currentMovie;
			break;
		case "Biography":
			bioLast = currentMovie;
			break;
		case "Comedy":
			comLast = currentMovie;
			break;
		case "Crime":
			criLast = currentMovie;
			break;
		case "Drama":
			draLast = currentMovie;
			break;
		case "Family":
			famLast = currentMovie;
			break;
		case "Fantasy":
			fanLast = currentMovie;
			break;
		case "History":
			hisLast = currentMovie;
			break;
		case "Horror":
			horLast = currentMovie;
			break;
		case "Music":
			musLast = currentMovie;
			break;
		case "Mystery":
			mysLast = currentMovie;
			break;
		case "Romance":
			romLast = currentMovie;
			break;
		case "Science Fiction":
			sciLast = currentMovie;
			break;
		case "Sports":
			spoLast = currentMovie;
			break;
		case "Thriller":
			thrLast = currentMovie;
			break;
		case "War":
			warLast = currentMovie;
			break;
		case "Western":
			wesLast = currentMovie;
			break;
		}
	}
	
	public void setCurMov() {
		switch (currentCat.getElement().getName()) {
		case "Action":
			currentMovie = actLast;
			break;
		case "Adventure":
			currentMovie = advLast;
			break;
		case "Animation":
			currentMovie = aniLast;
			break;
		case "Biography":
			currentMovie = bioLast;
			break;
		case "Comedy":
			currentMovie = comLast;
			break;
		case "Crime":
			currentMovie = criLast;
			break;
		case "Drama":
			currentMovie = draLast;
			break;
		case "Family":
			currentMovie = famLast;
			break;
		case "Fantasy":
			currentMovie = fanLast;
			break;
		case "History":
			currentMovie = hisLast;
			break;
		case "Horror":
			currentMovie = horLast;
			break;
		case "Music":
			currentMovie = musLast;
			break;
		case "Mystery":
			currentMovie = mysLast;
			break;
		case "Romance":
			currentMovie = romLast;
			break;
		case "Science Fiction":
			currentMovie = sciLast;
			break;
		case "Sports":
			currentMovie = spoLast;
			break;
		case "Thriller":
			currentMovie = thrLast;
			break;
		case "War":
			currentMovie = warLast;
			break;
		case "Western":
			currentMovie = wesLast;
			break;
		}
	}
	
	public Node<Movie> getLastMov(CircularDoublyLinkedList<Movie> cat){
		switch (cat.getName()) {
		case "Action":
			return actLast;
		case "Adventure":
			return advLast;
		case "Animation":
			return aniLast;
		case "Biography":
			return bioLast;
		case "Comedy":
			return comLast;
		case "Crime":
			return criLast;
		case "Drama":
			return draLast;
		case "Family":
			return famLast;		
		case "Fantasy":
			return fanLast;
		case "History":
			return hisLast;
		case "Horror":
			return horLast;
		case "Music":
			return musLast;
		case "Mystery":
			return mysLast;
		case "Romance":
			return romLast;
		case "Science Fiction":
			return sciLast;
		case "Sports":
			return spoLast;
		case "Thriller":
			return thrLast;
		case "War":
			return warLast;
		case "Western":
			return wesLast;
		default:
			return currentMovie;
		}
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

	private class commonEventHandler implements EventHandler<ActionEvent>{
		@SuppressWarnings("unchecked")
		public void handle(ActionEvent e) {
			ta1.clear();
			@SuppressWarnings("rawtypes")
			ArrayList<CircularDoublyLinkedList> lists = new ArrayList<CircularDoublyLinkedList>();
			String mov = new String("");

			if(actBox.isSelected())
				lists.add(netflix.act);
			if(advBox.isSelected())
				lists.add(netflix.adv);
			if(aniBox.isSelected())
				lists.add(netflix.ani);
			if(bioBox.isSelected())
				lists.add(netflix.bio);
			if(comBox.isSelected())
				lists.add(netflix.com);
			if(criBox.isSelected())
				lists.add(netflix.cri);
			if(draBox.isSelected())
				lists.add(netflix.dra);
			if(famBox.isSelected())
				lists.add(netflix.fam);
			if(fanBox.isSelected())
				lists.add(netflix.fan);
			if(hisBox.isSelected())
				lists.add(netflix.his);
			if(musBox.isSelected())
				lists.add(netflix.mus);
			if(mysBox.isSelected())
				lists.add(netflix.mys);
			if(romBox.isSelected())
				lists.add(netflix.rom);
			if(sciBox.isSelected())
				lists.add(netflix.sci);
			if(spoBox.isSelected())
				lists.add(netflix.spo);
			if(thrBox.isSelected())
				lists.add(netflix.thr);
			if(warBox.isSelected())
				lists.add(netflix.war);
			if(wesBox.isSelected())
				lists.add(netflix.wes);
			if(horBox.isSelected())
				lists.add(netflix.hor);					

			if(lists.size() == 1){
				CircularDoublyLinkedList<Movie> result = lists.get(0);
				Node<Movie> m = result.getHead();
				for(int i = 0; i < result.getSize();i++) {
					mov = m.getElement().getTitle() + " " + m.getElement().getRating() + " " + m.getElement().getGenre() + " " +  m.getElement().getYear() + " " + m.getElement().getScore() + "\n";
					ta1.appendText(mov);
					m = m.getNext();
				}
			}

			if(lists.size() == 2) {
				CircularDoublyLinkedList<Movie> result = netflix.commonMovies(lists.get(0), lists.get(1));
				
				if(result.getSize() == 0)
					ta1.appendText("No common Movies");
				
				Node<Movie> m = result.getHead();
				for(int i = 0; i < result.getSize();i++) {
					mov = m.getElement().getTitle() + " " + m.getElement().getRating() + " " + m.getElement().getGenre() + " " +  m.getElement().getYear() + " " + m.getElement().getScore() + "\n";
					ta1.appendText(mov);
					m = m.getNext();
				}
			}
			if(lists.size() > 2) {
				CircularDoublyLinkedList<Movie> result = netflix.commonMovies(lists.get(0), lists.get(1));
				
				for(int i = 2; i < lists.size(); i++) {
					result = netflix.commonMovies(result, lists.get(i));
				}
				if(result.getSize() == 0)
					ta1.appendText("No common Movies");
				
				Node<Movie> m = result.getHead();
				for(int i = 0; i < result.getSize();i++) {
					mov = m.getElement().getTitle() + " " + m.getElement().getRating() + " " + m.getElement().getGenre() + " " +  m.getElement().getYear() + " " + m.getElement().getScore() + "\n";
					ta1.appendText(mov);
					m = m.getNext();
				}
			}
		}
	}		
	
	private class upEventHandler implements EventHandler<ActionEvent>{
		@SuppressWarnings("unchecked")
		public void handle (ActionEvent e) {
			setLastMov();
			
			currentCat = currentCat.getPrev();
			
			setCurMov();
			
			r1Lbl.setText(currentCat.getElement().getName());
			infoLbl.setText(currentMovie.getElement().toString());
			Node<Movie> temp = currentMovie.getNext();
			row1T1.setText(currentMovie.getElement().getTitle());
			row1T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T5.setText(temp.getElement().getTitle());
			
			@SuppressWarnings("rawtypes")
			Node<CircularDoublyLinkedList> tempCat = currentCat.getNext();
			temp = getLastMov(tempCat.getElement());
			
			r2Lbl.setText(tempCat.getElement().getName());
			row2T1.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T5.setText(temp.getElement().getTitle());
			
			tempCat = tempCat.getNext();
			temp = getLastMov(tempCat.getElement());
			
			r3Lbl.setText(tempCat.getElement().getName());
			row3T1.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T5.setText(temp.getElement().getTitle());
		}
	}
	
	private class downEventHandler implements EventHandler<ActionEvent>{
		@SuppressWarnings("unchecked")
		public void handle (ActionEvent e) {
			setLastMov();
			
			currentCat = currentCat.getNext();
			
			setCurMov();
			
			r1Lbl.setText(currentCat.getElement().getName());
			infoLbl.setText(currentMovie.getElement().toString());
			Node<Movie> temp = currentMovie.getNext();
			row1T1.setText(currentMovie.getElement().getTitle());
			row1T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T5.setText(temp.getElement().getTitle());
			
			@SuppressWarnings("rawtypes")
			Node<CircularDoublyLinkedList> tempCat = currentCat.getNext();
			temp = getLastMov(tempCat.getElement());
			
			r2Lbl.setText(tempCat.getElement().getName());
			row2T1.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row2T5.setText(temp.getElement().getTitle());
			
			tempCat = tempCat.getNext();
			temp = getLastMov(tempCat.getElement());
			
			r3Lbl.setText(tempCat.getElement().getName());
			row3T1.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row3T5.setText(temp.getElement().getTitle());

		}
	}
	
	private class leftEventHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			currentMovie = currentMovie.getPrev();
			infoLbl.setText(currentMovie.getElement().toString());
			
			Node<Movie> temp = currentMovie.getNext();
			row1T1.setText(currentMovie.getElement().getTitle());
			row1T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T5.setText(temp.getElement().getTitle());
		}
	}
	
	private class rightEventHandler implements EventHandler<ActionEvent>{
		public void handle (ActionEvent e) {
			currentMovie = currentMovie.getNext();
			infoLbl.setText(currentMovie.getElement().toString());
			
			Node<Movie> temp = currentMovie.getNext();
			row1T1.setText(currentMovie.getElement().getTitle());
			row1T2.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T3.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T4.setText(temp.getElement().getTitle());
			temp = temp.getNext();
			row1T5.setText(temp.getElement().getTitle());

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
