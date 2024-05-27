import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {

    private TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        
        String htmlContent = generateHTMLContent();

        webEngine.loadContent(htmlContent);

        Scene scene = new Scene(webView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Task Manager");
        primaryStage.show();
    }

    private String generateHTMLContent() {
        StringBuilder html = new StringBuilder();
        html.append("<html><head>")
            .append("<style>")
            .append("body { font-family: Arial, sans-serif; }")
            .append(".task { margin: 5px 0; padding: 5px; border: 1px solid #ccc; }")
            .append(".completed { text-decoration: line-through; }")
            .append("</style>")
            .append("</head><body>")
            .append("<h1>Task Manager</h1>")
            .append("<ul>");

        for (Task task : taskManager.listTasks()) {
            html.append("<li class='task").append(task.isCompleted() ? " completed" : "").append("'>")
                .append(task.getDescription())
                .append("</li>");
        }

        html.append("</ul>")
            .append("</body></html>");

        return html.toString();
    }
}