package lib;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Handling images and image sizes
 */
public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    /**
     * Initialize visable Sprite with position (x, y)
     * 
     * @param x position x
     * @param y positon y
     */
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    /**
     * @return Image of sprite
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return position X of Sprite
     */
    public int getX() {
        return x;
    }

    /**
     * @return Position Y of Sprite
     */
    public int getY() {
        return y;
    }

    /**
     * @return Boolean whether Sprite is visable
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets Sprite's visability
     * 
     * @param visible boolean if sprite is visable
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * Loads image from file
     * 
     * @param imageName String with file name
     */
    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    /**
     * Sets image width and height
     */
    protected void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
}