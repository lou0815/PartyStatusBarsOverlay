package com.lou0815.PartyStatusBarsOverlay;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class PartyStatusBarsComponent extends ProgressBarComponent {

    private final BarType type;
    private Integer currValue;
    private Integer maxValue;
    private boolean drawBorder = false;
    private Color borderColor;

    private final PartyStatusBarsOverlayConfig config;

    @Inject
    public PartyStatusBarsComponent(PartyStatusBarsOverlayConfig config, BarType type, Integer currValue, Integer maxValue) {
        this.config = config;
        this.type = type;
        this.currValue = currValue;
        this.maxValue = maxValue;

        initializeProgressBar();
    }

    public PartyStatusBarsComponent(PartyStatusBarsOverlayConfig config, BarType type, Integer currValue) {
        this(config, type, currValue, 100); // Defaults maxValue to 100 if not specified
    }

    private void initializeProgressBar() {
        setLabelDisplayMode(LabelDisplayMode.TEXT_ONLY);
        switch (type) {
            case HP:
                setBackgroundColor(config.backgroundHpColor());
                if (currValue > maxValue) {
                    setForegroundColor(config.overHpColor());
                } else if(currValue <= config.thresholdHp() && config.showHpThresholdWarning()){
                    setForegroundColor(config.thresholdHpColor());
                } else {
                    setForegroundColor(config.hpColor());
                }
                if(currValue <= config.thresholdHp() && config.showHpThresholdWarningBorder()){
                    borderColor = config.thresholdHpColorBorder();
                    drawBorder = true;
                }
                break;
            case PRAY:
                setBackgroundColor(config.backgroundPrayColor());
                if (currValue > maxValue) {
                    setForegroundColor(config.overPrayColor());
                } else if(currValue <= config.thresholdPray() && config.showPrayThresholdWarning()){
                    setForegroundColor(config.thresholdPrayColor());
                } else {
                    setForegroundColor(config.prayColor());
                }
                if(currValue <= config.thresholdPray() && config.showPrayThresholdWarningBorder()){
                    borderColor = config.thresholdPrayColorBorder();
                    drawBorder = true;
                }
                break;
            case SPEC:
                // if we are on the spec Bar, we reverse the if statement since spec makes more sense to Warn when above a value
                setBackgroundColor(config.backgroundSpecColor());
                if (currValue >= config.thresholdSpec() && config.showSpecThresholdWarning()) {
                    setForegroundColor(config.thresholdSpecColor());
                } else {
                    setForegroundColor(config.specColor());
                }
                if(currValue >= config.thresholdSpec() && config.showSpecThresholdWarningBorder()){
                    borderColor = config.thresholdSpecColorBorder();
                    drawBorder = true;
                }
                break;
            case RUN:
                setBackgroundColor(config.backgroundRunColor());
                if (currValue <= config.thresholdRun() && config.showRunThresholdWarning()) {
                    setForegroundColor(config.thresholdRunColor());
                } else {
                    setForegroundColor(config.runColor());
                }
                if(currValue <= config.thresholdRun() && config.showRunThresholdWarningBorder()){
                    borderColor = config.thresholdRunColorBorder();
                    drawBorder = true;
                }
                break;
        }
        updateProgress();  // Call update to set the initial label and progress
    }

    private void updateProgress() {
        double progress = (double) currValue / maxValue * 100;
        setCenterLabel(currValue + "/" + maxValue);
        setValue(progress);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        Dimension dimension = super.render(graphics); // Draws the main progress bar

        // Draw a border if below threshold
        if (drawBorder) {
            drawThresholdBorder(graphics);
        }
        return dimension;
    }

    private void drawThresholdBorder(Graphics2D graphics) {
        graphics.setColor(borderColor); // Define this color in config
        graphics.setStroke(new BasicStroke(config.borderThickness())); // Set border thickness
        graphics.drawRect(getBounds().x, getBounds().y , getBounds().width, getBounds().height); // Draw border around bar
    }
}
