package dk.sdu.se4.common.entity.part;

import dk.sdu.se4.common.entity.Entity;

public class TextPart implements EntityPart {
    private String id;
    private String text;
    private float scaleX;
    private float scaleY;
    private int colorRed;
    private int colorGreen;
    private int colorBlue;
    private int colorAlpha;

    public TextPart(String id) {
        this.id = id;
        this.text = "Not loaded.";
        this.scaleX = 1.25f;
        this.scaleY = 1.25f;
        this.colorRed = 151;
        this.colorGreen = 26;
        this.colorBlue = 26;
        this.colorAlpha = 255;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public int getColorRed() {
        return colorRed;
    }

    public void setColorRed(int colorRed) {
        this.colorRed = colorRed;
    }

    public int getColorGreen() {
        return colorGreen;
    }

    public void setColorGreen(int colorGreen) {
        this.colorGreen = colorGreen;
    }

    public int getColorBlue() {
        return colorBlue;
    }

    public void setColorBlue(int colorBlue) {
        this.colorBlue = colorBlue;
    }

    public int getColorAlpha() {
        return colorAlpha;
    }

    public void setColorAlpha(int colorAlpha) {
        this.colorAlpha = colorAlpha;
    }

    @Override
    public void process(Entity entity) {

    }
}
