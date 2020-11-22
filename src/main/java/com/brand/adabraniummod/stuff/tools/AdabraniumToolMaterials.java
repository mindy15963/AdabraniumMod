package com.brand.adabraniummod.stuff.tools;

import com.brand.adabraniummod.items.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum AdabraniumToolMaterials implements ToolMaterial {
    VIBRANIUM(4, 2990, 17.0F, 8.0F, 12, () -> {
        return Ingredient.ofItems(ModItems.VIBRANIUM_INGOT);
    }),
    ADAMANTIUM(4, 4280, 25.0F, 13.0F, 10, () -> {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }),
    NETHER_BRICK(2, 381, 8.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(Items.NETHER_BRICK);
    }),
    ONESHOTIUM(3, 1000000, 23.0F, 999999.0F, 100, () -> {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    });
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    AdabraniumToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

