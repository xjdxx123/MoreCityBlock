package com.clinton.cityblocks.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BlockJsonGenerator {

    // 替换成你项目资源文件夹路径
    static final String BASE_PATH = "/Users/clintongao/Github_project/MoreCityBlock/src/main/resources/assets/cityblocks";
    static final String TEXTURE_FOLDER = BASE_PATH + "/textures/block";

    static final String[] EXCLUDE_KEYWORDS = {
            "top", "bottom", "side", "front", "back", "end", "face", "left", "right"
    };

    public static void main(String[] args) {
        File textureDir = new File(TEXTURE_FOLDER);

        if (!textureDir.exists() || !textureDir.isDirectory()) {
            System.out.println("贴图路径无效");
            return;
        }

        File[] pngs = textureDir.listFiles((dir, name) -> {
            if (!name.endsWith(".png")) return false;
            String lower = name.toLowerCase();
            for (String keyword : EXCLUDE_KEYWORDS) {
                if (lower.contains(keyword)) return false;
            }
            return true;
        });

        if (pngs == null || pngs.length == 0) {
            System.out.println("无符合条件的贴图");
            return;
        }

        for (File png : pngs) {
            String blockName = png.getName().replace(".png", "").toLowerCase();
            generateBlockstate(blockName);
            generateBlockModel(blockName);
            generateItemModel(blockName);
        }

        System.out.println("所有 JSON 文件生成完毕！");
    }

    private static void generateBlockstate(String blockName) {
        String content = String.format("""
        {
          "variants": {
            "": { "model": "cityblocks:block/%s" }
          }
        }
        """, blockName);
        writeToFile(BASE_PATH + "/blockstates/" + blockName + ".json", content);
    }

    private static void generateBlockModel(String blockName) {
        String content = String.format("""
        {
          "parent": "block/cube_all",
          "textures": {
            "all": "cityblocks:block/%s"
          }
        }
        """, blockName);
        writeToFile(BASE_PATH + "/models/block/" + blockName + ".json", content);
    }

    private static void generateItemModel(String blockName) {
        String content = String.format("""
        {
          "parent": "cityblocks:block/%s"
        }
        """, blockName);
        writeToFile(BASE_PATH + "/models/item/" + blockName + ".json", content);
    }

    private static void writeToFile(String filePath, String content) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // 确保目录存在
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
            }
        } catch (IOException e) {
            System.err.println("写入失败：" + filePath);
            e.printStackTrace();
        }
    }
}
