# 🌆 CityBlocks Mod for Minecraft 1.20.1

> 一个为 Minecraft 添加城市主题方块的 Forge 模组，适合喜欢城市建造风格的玩家。

---

## 简介

**CityBlocks** 是一个专注于城市美学的 Minecraft 模组，添加了大量实用与装饰性的城市元素，例如砖块、路灯、道路、植物等，支持 Forge 1.20.1。

---

## 特性

- 多种城市风格方块：`city_brick`、`city_lamp`、`city_road` 等
- 支持方向属性的方块：如 `city_bee_nest`
- 可治疗的花朵方块：如 `city_orange_tulip`（带有治疗效果）
- 自动注册对应物品（BlockItem）
- 支持透明纹理方块的渲染设置（使用 `cutout()`）

---

## 安装方法

1. 安装 Minecraft **1.20.1**
2. 安装对应版本的 **Forge**（推荐 **47.4.0+**）
3. 下载并放置 `cityblocks-xxx.jar` 到：
4. 启动游戏！

---

## 开发信息

- 所有方块通过 `DeferredRegister` 批量注册，见 `ModBlocks.java`
- 所有需要透明渲染的方块（如花）在 `ClientModEvents.java` 中通过 `setRenderLayer()` 设置为 `RenderType.cutout()`
- 资源路径：
- 目前使用 **JSON** 文件管理模型与方块状态，无需代码生成器

---

## 🧪 开发环境

- IntelliJ IDEA / Eclipse
- Java 17+
- Minecraft Forge MDK 1.20.1
- Gradle 7.6+

---

## 🙏 鸣谢

- Forge 官方文档和教程社区
- Minecraft 资源包作者提供的贴图灵感
- 所有参与测试和提出建议的朋友

---

## 📄 许可证

[MIT License](https://opensource.org/licenses/MIT)

---

## 👤 作者

**Clinton Gao**  
GitHub: [@xjdxx123](https://github.com/xjdxx123)

---

🧱 *“Build the city you dream of — one block at a time.”*

