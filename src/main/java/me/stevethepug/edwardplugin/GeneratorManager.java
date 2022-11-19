package me.stevethepug.edwardplugin;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class GeneratorManager
{
    ItemStack item;
    public GeneratorManager()
    {
        item = new ItemStack(Material.GOLD_INGOT, 1);
    }


    public void CreateHoverItem(Player player)
    {
        ArmorStand stand = player.getLocation().getWorld().spawn(player.getLocation(), ArmorStand.class);
        stand.getEquipment().setItemInMainHand(item);
        stand.setVisible(false);

        EulerAngle angle =  new EulerAngle(63.754, 71.222, -81.590);
        stand.setRightArmPose(angle);
    }
}
