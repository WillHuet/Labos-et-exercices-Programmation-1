public class Rectangle {
    int width;
    int lenght;
    int perimetre;
    int aire;

    public Rectangle() {
        this.width = 1;
        this.lenght = 1;
    }

    public Rectangle(int width, int lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    public int getWidth() {
        return width;
    }

    public int getLenght() {
        return lenght;
    }

    public boolean numberCheck(float number){
        boolean result = false;
        if (number >= 0.0 && number <= 20.0) {
            result = true;
            System.out.println("Valeur changée!");
        } else {
            System.out.println("Erreur! Valeur non comprise entre 0.0 et 20.0");
        }
        return result;
    }

    public void setWidth(float newWidth) {
        if (numberCheck(newWidth)) {
            this.width = (int)newWidth;
        }
    }

    public void setLenght(float newLenght) {
        if (numberCheck(newLenght)) {
            this.lenght = (int)newLenght;
        }
    }

    public int calculerPerimetre() {
        int result = (2*lenght) + (2*width);
        return result;
    }

    public int calculerAire() {
        int result = lenght * width;
        return result;
    }

    static void main() {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(3,6);
        Rectangle rectangle3 = new Rectangle(8,10);
        Rectangle rectangle4 = new Rectangle(10,10);

        System.out.println("Perimètre du rectangle 1 : " + rectangle1.calculerPerimetre());
        System.out.println("Aire du rectangle 1 : " + rectangle1.calculerAire());

        rectangle1.setWidth(20.0F);
    }
}
