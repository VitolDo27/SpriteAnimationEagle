import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.HashMap;



public class Main extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>(); // принимает значение нажатой кнопки
    Image image = new Image(getClass().getResourceAsStream("sprite-eagle.png")); // загружаем картинку
    ImageView imageView = new ImageView(image); // отображаем картинку
    Character player = new Character(imageView); // Создаём класс персонажа
    static Pane root = new Pane();

/*метод передвижения спрайта*/
    public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(-3);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(3);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.setScaleX(1);// поворот вправо
            player.animation.setOffsetY(2);
            player.moveX(3);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.setScaleX(-1 ); // поворот влево
           player.animation.setOffsetY(2);
            player.moveX(-3);
        }
       //else{
        //    player.animation.stop();
      //  }
    }
    public boolean isPressed(KeyCode key) {

        return keys.getOrDefault(key, false);
    }
    @Override
    public void start(Stage primaryStage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // получаем размер экрана
        double width = screenSize.getWidth(); // ширина
        double height = screenSize.getHeight(); // высота
        root.setPrefSize(width,height); // Размеры сцены
        root.getChildren().addAll(player);
        Scene scene = new Scene(root); // Создаём сцену

       scene.setFill(null);/* цвет сцены */
    //   scene.setFill(Color.rgb(0,0, 255)); // цвет сцены
        scene.setOnKeyPressed(event->keys.put(event.getCode(),true)); //передаётся код кнопки
        scene.setOnKeyReleased(event-> {
            keys.put(event.getCode(), false);
        });
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) { update();
            }
        };
        timer.start();
      //  primaryStage.setTitle("Eagle"); // название сцены

        primaryStage.initStyle(StageStyle.TRANSPARENT); // прозрачность сцены
        primaryStage.setAlwaysOnTop(true); // работа поверх других окон
    //  primaryStage.setOpacity(0.5); // прозрачность
        primaryStage.setScene(scene);
        primaryStage.show(); // отображаем окна

}
    public static void main(String[] args) {
        launch(args);
    }


}
