/*
 * Copyright (c) 2024 ModCore Inc. All rights reserved.
 *
 * This code is part of ModCore Inc.'s Essential Mod repository and is protected
 * under copyright registration # TX0009138511. For the full license, see:
 * https://github.com/EssentialGG/Essential/blob/main/LICENSE
 *
 * You may not use, copy, reproduce, modify, sell, license, distribute,
 * commercialize, or otherwise exploit, or create derivative works based
 * upon, this file or any other in this repository, all of which is reserved by Essential.
 */
package gg.essential.mixins.transformers.client.gui;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gg.essential.gui.multiplayer.DividerServerListEntry;
import net.minecraft.client.gui.screen.ServerSelectionList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;

@Mixin(ServerSelectionList.class)
public class Mixin_SelectionListDividers_GuiMultiplayer {

    @WrapOperation(
        method = {"lambda$func_241219_a_$0", "func_241612_b_", "m_169972_", "method_30016"},
        constant = @Constant(classValue = ServerSelectionList.LanScanEntry.class),
        remap = false
    )
    private static boolean skipDividerEntries(Object object, Operation<Boolean> original) {
        return object instanceof DividerServerListEntry || original.call(object);
    }

}
