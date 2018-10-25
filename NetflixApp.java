package Netflix;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NetflixApp extends Application {
	TabPane tab = new TabPane();
	Pane manager = new Pane();
	Netflix netflix = new Netflix();
	
	Tab tab1 = new Tab();
	
	Tab tab2 = new Tab();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			manager = buildGui();
			Scene scene = new Scene(manager, 400, 400);
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
		
		FlowPane categories = buildCatPane();
		home.getChildren().add(categories);
		
		return home;
	}
	
	private VBox buildInfo() {
		VBox info = new VBox();
		
		return info;
	}
	
	@SuppressWarnings("rawtypes")
	private FlowPane buildCatPane() {
		FlowPane cat = new FlowPane(Orientation.VERTICAL);
		
		CircularDoublyLinkedList<CircularDoublyLinkedList> categories = netflix.getCategories();
		Node<CircularDoublyLinkedList> catPtr = categories.getTail();
		
		for (int i = 0; i < categories.getSize(); i++) {
			catPtr = catPtr.getNext();
		}
		
		return cat;
	}
	
	private Pane buildTab2Content() {
		GridPane search = new GridPane();
		
		return search;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
