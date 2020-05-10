import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Character extends Pane{

    ImageView imageView;
    int count = 14;
    int columns = 14;
    int offsetX = 0;
    int offsetY = 0;
    int width = 130;
    int height = 200;


    SpriteAnimation animation;
    /* Присваиваем значения картинки*/
    public Character(ImageView imageView) {
        this.imageView = imageView;
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
       /*Присваиваем значение анимации*/
        animation = new SpriteAnimation(imageView, Duration.millis(900), count, columns, offsetX, offsetY, width, height);
        getChildren().addAll(imageView); // Добавляем объект на экран
    }

 /*Параметры для проверки смещения по X*/
    public void moveX(int x){
        boolean right = x>0?true:false;
        for(int i = 0; i < Math.abs(x); i++) {
            if (right) this.setTranslateX(this.getTranslateX() + 1);
            else this.setTranslateX(this.getTranslateX() - 1);
        }
    }
    /*Параметры для проверки смещения по Y*/
    public void moveY(int y) {
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            if (down) this.setTranslateY(this.getTranslateY() + 1);
            else this.setTranslateY(this.getTranslateY() - 1);
        }
    }

    }
