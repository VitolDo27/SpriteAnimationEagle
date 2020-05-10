import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class SpriteAnimation  extends Transition{
    /*создаём константы*/
    private final ImageView imageView; //константа картинки
    private final int count; // количество кадров
    private final int columns; // количество стоблцов
    private int offsetX; // смещение кадра по X
    private int offsetY; // смещение кадра по Y
    private final int width; // ширина
    private final int height; // длина

    public SpriteAnimation(
            ImageView imageView,
            Duration duration, // продолжительность анимации
            int count, int columns,
            int offsetX, int offsetY,
            int width, int height
    ){
        /*Присваивание значений константам*/
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration); // устанавливаем продолжительность анимации
        setCycleCount(Animation.INDEFINITE); // Длительность цикла анимации
        setInterpolator(Interpolator.LINEAR); // Линейная анимация
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));

    }
   public void setOffsetX(int x){
       this.offsetX = x;
    }
    public void setOffsetY(int y){
        this.offsetY = y;
    }
    /* Метод для определния позиции спрайта*/
    protected void interpolate(double frac) {
        final int index = Math.min((int)Math.floor(count*frac), count-1);
        final int x = (index%columns)*width+offsetX;
        final int y = (index/columns)*height+offsetY;
        imageView.setViewport(new Rectangle2D(x, y, width, height));

    }
}
