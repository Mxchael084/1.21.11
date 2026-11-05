package dev.rupture.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.AddGuiOverlayLayersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = RuptureReborn.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ClientModEvents {
    public static final KeyMapping MENU_KEY = new KeyMapping(
            "key.rupture_reborn.menu",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "key.categories.rupture_reborn"
    );

    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(MENU_KEY);
    }

    @SubscribeEvent
    public static void registerHud(AddGuiOverlayLayersEvent event) {
        event.getLayeredDraw().add(
                ResourceLocation.fromNamespaceAndPath(RuptureReborn.MOD_ID, "status_hud"),
                (graphics, deltaTracker) -> drawHud(graphics)
        );
    }

    private static void drawHud(GuiGraphics graphics) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) return;

        int y = 8;
        if (ClientFeatures.fps) {
            graphics.drawString(mc.font, Component.literal("FPS " + mc.getFps()), 8, y, 0xFF8BE9FD, true);
            y += 11;
        }
        if (ClientFeatures.coordinates) {
            var player = mc.player;
            String text = String.format(java.util.Locale.ROOT,
                    "XYZ %.1f / %.1f / %.1f", player.getX(), player.getY(), player.getZ());
            graphics.drawString(mc.font, Component.literal(text), 8, y, 0xFFFFFFFF, true);
        }
    }
}
