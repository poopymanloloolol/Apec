package Apec.Components.Gui.GuiElements;

import Apec.ApecUtils;
import Apec.Components.Gui.ApecGuiIngame;
import Apec.Components.Gui.GUIModifier;
import Apec.Components.Gui.GuiElements.GUIComponent;
import Apec.DataExtractor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.util.vector.Vector2f;

public class InfoBox extends GUIComponent {

    public InfoBox() {
        super(GUIModifier.GUiComponentID.BOTTOM_BAR);
    }

    @Override
    public void draw(DataExtractor.PlayerStats ps, DataExtractor.ScoreBoardData sd, ScaledResolution sr) {
        ApecGuiIngame agi = (ApecGuiIngame) Minecraft.getMinecraft().ingameGUI;
        agi.drawRect(0 + (int)delta_position.x, sr.getScaledHeight() - 20 + (int)delta_position.y, sr.getScaledWidth() + (int)delta_position.x, sr.getScaledHeight() + (int)delta_position.y, 0xca0a0a0a);
        Vector2f GuiPos = new Vector2f(20, sr.getScaledHeight() - 14);

        GuiPos = ApecUtils.addVec(GuiPos,delta_position);

        mc.fontRendererObj.drawString(sd.Purse, (int) GuiPos.x, (int) GuiPos.y, 0xffffff, false);
        mc.fontRendererObj.drawString(sd.Zone, (int) GuiPos.x + 160, (int) GuiPos.y, 0xffffff, false);
        mc.fontRendererObj.drawString(sd.Date+" " +sd.Hour, (int) sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(sd.Date+" " +sd.Hour) - 15 + delta_position.x, (int) GuiPos.y + delta_position.y, 0xffffff, false);
        String DFString = "\u00a7a"+ps.Defence + " Defence";
        agi.drawThiccBorderString(DFString, (int) GuiPos.x + 320 , (int) GuiPos.y, 0xffffff);
    }
}
