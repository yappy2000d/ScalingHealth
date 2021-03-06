package net.silentchaos512.scalinghealth.loot.conditions;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.JSONUtils;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.silentchaos512.scalinghealth.ScalingHealth;
import net.silentchaos512.scalinghealth.capability.IDifficultyAffected;
import net.silentchaos512.scalinghealth.utils.SHDifficulty;

public class SHMobProperties implements ILootCondition {
    public static final Serializer SERIALIZER = new Serializer();

    private final LootContext.EntityTarget target;
    private final boolean isBlight;
    private final float minDifficulty;
    private final float maxDifficulty;

    public SHMobProperties(LootContext.EntityTarget target, boolean isBlight, float minDifficulty, float maxDifficulty) {
        this.target = target;
        this.isBlight = isBlight;
        this.minDifficulty = minDifficulty;
        this.maxDifficulty = maxDifficulty;
    }

    public static ILootCondition.IBuilder builder(LootContext.EntityTarget target, boolean isBlight, float minDifficulty, float maxDifficulty){
        return () -> new SHMobProperties(target, isBlight, minDifficulty, maxDifficulty);
    }

    @Override
    public boolean test(LootContext lootContext) {
        Entity entity = lootContext.get(this.target.getParameter());
        if (entity instanceof MobEntity) {
            IDifficultyAffected affected = SHDifficulty.affected(entity);
            //rare case where its prob better to get the non-blight difficulty
            float difficulty = affected.getDifficulty();
            return difficulty >= this.minDifficulty &&
                    difficulty <= this.maxDifficulty &&
                    (!this.isBlight || affected.isBlight());
        }
        return false;
    }

    public static class Serializer extends ILootCondition.AbstractSerializer<SHMobProperties> {
        Serializer() {
            super(ScalingHealth.getId("mob_properties"), SHMobProperties.class);
        }

        @Override
        public void serialize(JsonObject json, SHMobProperties value, JsonSerializationContext context) {
            json.add("entity", context.serialize(value.target));
            json.addProperty("is_blight", value.isBlight);
            JsonObject difficultyObj = new JsonObject();
            difficultyObj.addProperty("min", value.minDifficulty);
            difficultyObj.addProperty("max", value.maxDifficulty);
            json.add("difficulty", difficultyObj);
        }

        @Override
        public SHMobProperties deserialize(JsonObject json, JsonDeserializationContext context) {
            LootContext.EntityTarget target = JSONUtils.deserializeClass(json, "entity", context, LootContext.EntityTarget.class);
            boolean isBlight = JSONUtils.getBoolean(json, "is_blight", false);
            float minDifficulty = 0;
            float maxDifficulty = Float.MAX_VALUE;
            if (json.has("difficulty")) {
                JsonElement difficulty = json.get("difficulty");
                if (difficulty.isJsonObject()) {
                    JsonObject jsonObject = difficulty.getAsJsonObject();
                    minDifficulty = JSONUtils.getFloat(jsonObject, "min", minDifficulty);
                    maxDifficulty = JSONUtils.getFloat(jsonObject, "max", maxDifficulty);
                } else {
                    minDifficulty = maxDifficulty = difficulty.getAsFloat();
                }
            }
            return new SHMobProperties(target, isBlight, minDifficulty, maxDifficulty);
        }
    }
}
