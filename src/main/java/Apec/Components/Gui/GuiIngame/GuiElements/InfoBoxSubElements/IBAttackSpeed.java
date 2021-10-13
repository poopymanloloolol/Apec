package Apec.Components.Gui.GuiIngame.GuiElements.InfoBoxSubElements;

import Apec.ApecMain;
import Apec.Components.Gui.GuiIngame.GUIComponent;
import Apec.Components.Gui.GuiIngame.GUIComponentID;
import Apec.DataInterpretation.DataExtractor;
import Apec.Settings.SettingID;
import Apec.Utils.ApecUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.util.vector.Vector2f;

public class IBAttackSpeed extends GUIComponent {

    private int AttackSpeedStringWidth = 0;

    public IBAttackSpeed() {
        super(GUIComponentID.IB_ATK_SPEED);
    }

    @Override
    public void drawTex(DataExtractor.PlayerStats ps, DataExtractor.ScoreBoardData sd, DataExtractor.OtherData od, DataExtractor.TabStats ts, ScaledResolution sr, boolean editingMode) {
        super.drawTex(ps, sd, od, ts, sr, editingMode);
        mc.renderEngine.bindTexture(new ResourceLocation(ApecMain.modId, "gui/statBars.png"));
        boolean UseIcons = ApecMain.Instance.settingsManager.getSettingState(SettingID.INFO_BOX_ICONS);
        if (!UseIcons) return;
        Vector2f pos = getCurrentAnchorPoint();
        GuiIngame gi = Minecraft.getMinecraft().ingameGUI;
        if (ApecMain.Instance.settingsManager.getSettingState(SettingID.SHOW_ATTACK_SPEED) || editingMode) {
            gi.drawTexturedModalRect((int) (pos.x * oneOverScale),  pos.y * oneOverScale - 1, 80, 216, 9, 9);
        }
    }

    @Override
    public void draw(DataExtractor.PlayerStats ps, DataExtractor.ScoreBoardData sd, DataExtractor.OtherData od, DataExtractor.TabStats ts, ScaledResolution sr, boolean editingMode) {
        super.draw(ps, sd, od, ts, sr, editingMode);
        boolean UseIcons = ApecMain.Instance.settingsManager.getSettingState(SettingID.INFO_BOX_ICONS);
        String attackSpeedText = (UseIcons ? ts.AttackSpeed : "\u2694" + ts.AttackSpeed);
        Vector2f pos = getCurrentAnchorPoint();
        if (ApecMain.Instance.settingsManager.getSettingState(SettingID.SHOW_ATTACK_SPEED) || editingMode) {
            ApecUtils.drawStylizedString(
                    attackSpeedText,
                    (int) ((pos.x + (UseIcons ? 11 : 0)) * oneOverScale),
                    (int) (pos.y * oneOverScale),
                    0xFFFF55
            );
        }
        AttackSpeedStringWidth = mc.fontRendererObj.getStringWidth(attackSpeedText);
    }

    @Override
    public Vector2f getAnchorPointPosition() {
        return new Vector2f(560*scale + 20 * scale, 6*scale);
    }

    @Override
    public Vector2f getBoundingPoint() {
        boolean UseIcons = ApecMain.Instance.settingsManager.getSettingState(SettingID.INFO_BOX_ICONS);
        return new Vector2f(AttackSpeedStringWidth + (UseIcons ? 11 : 0), 10*scale);
    }

}
