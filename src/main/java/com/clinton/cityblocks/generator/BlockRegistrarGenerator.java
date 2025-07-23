package com.clinton.cityblocks.generator;

import java.io.File;

public class BlockRegistrarGenerator {
    public static void main(String[] args) {
        // 修改成你的资源路径
        File textureFolder = new File("/Users/clintongao/Github_project/MoreCityBlock/src/main/resources/assets/cityblocks/textures/block");

        if (!textureFolder.exists() || !textureFolder.isDirectory()) {
            System.out.println("路径无效或不是文件夹");
            return;
        }

        // 不包含这些关键词的图片被认为是六面相同的方块
        String[] excludedKeywords = {"top", "bottom", "side", "front", "back", "end", "face", "left", "right"};

        File[] files = textureFolder.listFiles((dir, name) -> {
            if (!name.endsWith(".png")) return false;

            String lower = name.toLowerCase();
            for (String keyword : excludedKeywords) {
                if (lower.contains(keyword)) {
                    return false; // 排除含有这些方向关键词的贴图
                }
            }
            return true;
        });

        if (files == null || files.length == 0) {
            System.out.println("没有符合条件的 PNG 文件");
            return;
        }

        for (File file : files) {
            String fileName = file.getName().replace(".png", "");
            String blockName = fileName.toLowerCase();
            System.out.printf("registerBlock(\"%s\", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.STONE)));\n", blockName);
        }
    }
}
