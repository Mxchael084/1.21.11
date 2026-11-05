package dev.rupture.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class RuptureMenuScreen extends Screen {
    public RuptureMenuScreen() {
        super(Component.literal("RUPTURE REBORN"));
    }

    @Override
    protected void init() {
        int width = 210;
        int x = (this.width - width) / 2;
        int y = this.height / 2 - 42;

        addRenderableWidget(toggle("Coordinates HUD", () -> ClientFeatures.coordinates,
                value -> ClientFeatures.coordinates = value, x, y));
        addRenderableWidget(toggle("FPS Counter", () -> ClientFeatures.fps,
                value -> ClientFeatures.fps = value, x, y + 28));
        addRenderableWidget(Button.builder(Component.literal("Done"), button -> onClose())
                .bounds(x, y + 66, width, 20).build());
    }

    private Button toggle(String label, java.util.function.BooleanSupplier getter,
                          java.util.function.Consumer<Boolean> setter, int x, int y) {
        return Button.builder(toggleText(label, getter.getAsBoolean()), button -> {
            boolean next = !getter.getAsBoolean();
            setter.accept(next);
            button.setMessage(toggleText(label, next));
        }).bounds(x, y, 210, 20).build();
    }

    private Component toggleText(String label, boolean enabled) {
        return Component.literal(label + "  [" + (enabled ? "ON" : "OFF") + "]");
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(font, title, width / 2, height / 2 - 70, 0xFF8BE9FD);
        graphics.drawCenteredString(font, "Client-side single-player utilities", width / 2,
                height / 2 - 56, 0xFFAAAAAA);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
