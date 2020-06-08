package labb5;

import java.awt.geom.Rectangle2D;

/**
 * Этот класс предоставляет общий интерфейс и операции для генераторов фракталов, 
 * которые можно просматривать в Fractal Explorer.
 */
public abstract class FractalGenerator {

    /**
     * Эта статическая вспомогательная функция принимает целочисленную координату 
	 * и преобразует ее в значение двойной точности, соответствующее определенному диапазону. 
	 * Он используется для преобразования координат пикселей в значения 
	 * двойной точности для вычисления фракталов и т. Д.
     *
     * @param rangeMin минимальное значение диапазона с плавающей запятой
     * @param rangeMax максимальное значение диапазона с плавающей запятой
     *
     * @param size размер измерения, из которого берется пиксельная координата.
     *        Например, это может быть ширина изображения или высота изображения.
     *
     * @param coord координата, чтобы вычислить значение двойной точности
     *        Координата должна находиться в диапазоне [0, размер].
     */
    public double getCoord(double rangeMin, double rangeMax,
        int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }

    /**
     * Устанавливает указанный прямоугольник, чтобы содержать начальный диапазон, подходящий
     * для генерируемого фрактала.
     */
    public void getInitialRange(Rectangle2D.Double range) {};
    public int numIterations(double x, double y) { return 0; };

    /**
     * Обновляет текущий диапазон с центром в указанных координатах, 
     * а также для увеличения или уменьшения с помощью указанного коэффициента масштабирования.
     */
    public static void recenterAndZoomRange(Rectangle2D.Double range,
        double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }
}
