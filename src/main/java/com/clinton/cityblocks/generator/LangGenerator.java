package com.clinton.cityblocks.generator;

import java.io.File;
import java.io.FileWriter;
import java.util.Locale;

public class LangGenerator {
    public static void main(String[] args) {
        File textureFolder = new File("src/main/resources/assets/cityblocks/textures/block");

        if (!textureFolder.exists() || !textureFolder.isDirectory()) {
            System.out.println("纹理目录无效");
            return;
        }

        File[] files = textureFolder.listFiles((dir, name) -> name.endsWith(".png"));
        if (files == null || files.length == 0) {
            System.out.println("没有找到 PNG 文件");
            return;
        }

        StringBuilder langJson = new StringBuilder();
        langJson.append("{\n");

        for (int i = 0; i < files.length; i++) {
            String baseName = files[i].getName().replace(".png", "");
            String key = "block.cityblocks.city_" + baseName.toLowerCase(Locale.ROOT);
            String value = toTitleCase(baseName.replace("_", " ")); // 美化显示名
            langJson.append(String.format("  \"%s\": \"City %s\"", key, value));

            if (i != files.length - 1) langJson.append(",");
            langJson.append("\n");
        }

        langJson.append("}");

        try (FileWriter writer = new FileWriter("src/main/resources/assets/cityblocks/lang/en_us.json")) {
            writer.write(langJson.toString());
            System.out.println("语言文件生成完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 将字符串每个单词首字母大写
    public static String toTitleCase(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0)
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }
}
