package com.clinton.cityblocks.generator;

import java.io.File;

public class BlockRegistrarGenerator {
    public static void main(String[] args) {
        // 修改成你的资源路径
        File textureFolder = new File("/Users/clintongao/Github_project/MoreCityBlock/src/main/resources/Assets/cityblocks/textures/block");

        if (!textureFolder.exists() || !textureFolder.isDirectory()) {
            System.out.println("路径无效或不是文件夹");
            return;
        }

        File[] files = textureFolder.listFiles((dir, name) -> name.endsWith(".png"));
        if (files == null) {
            System.out.println("没有找到 PNG 文件");
            return;
        }

        for (File file : files) {
            String fileName = file.getName().replace(".png", "");
            String blockName = fileName.toLowerCase();
            System.out.printf("registerBlock(\"%s\", () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.STONE)));\n", blockName);
        }
    }
}
