package ru.job4j.ood.lsp;

public class Square extends Rectangle {
    public Square(int width, int height) {
        super(width, height);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    /**
     * Для расчёта площади используется только одно поле родительского класса.
     * Второе в это время никак не используется.
     * Принцип LSP нарушен!
     *
     * @return — возвращает перемноженную ширину, потому что у квадрата равные стороны
     */
    @Override
    public int getArea() {
        return width * width;
    }
}
