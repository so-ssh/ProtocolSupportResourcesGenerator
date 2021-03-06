package protocolsupportresourcesgenerator.generators.minecraftdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import net.minecraft.server.v1_16_R2.IRegistry;
import net.minecraft.server.v1_16_R2.Item;

public class ItemDataGenerator {

	public static void writeData() throws IOException {
		JsonObject rootObject = new JsonObject();
		for (Item type : IRegistry.ITEM) {
			rootObject.addProperty(IRegistry.ITEM.getKey(type).getKey(), IRegistry.ITEM.a(type));
		}
		try (FileWriter writer = new FileWriter(new File(DataGeneratorConstants.targetFolder, "item.json"))) {
			new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(rootObject, writer);
		}
	}

}
