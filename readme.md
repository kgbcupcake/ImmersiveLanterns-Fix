# Immersive Lanterns — Unofficial 1.21.1 Fix


An unofficial NeoForge 1.21.1 build of [Toni's Immersive Lanterns](https://modrinth.com/mod/immersive-lanterns). This fork strips the Stonecutter multi-platform setup and **txnilib** dependency, making Curios, Accessories, LambDynamicLights, and Sodium Dynamic Lights fully optional.

> ⚠️ Please report bugs for this version **only** in [this repository's issue tracker](https://github.com/kgbcupcake/ImmersiveLanterns-Fix/issues). Do not contact Toni about issues specific to this fork.

---

## What's Different

- **NeoForge-only** — No Fabric, no old Forge, no Stonecutter preprocessor.
- **No txnilib** — Config uses native NeoForge `ModConfigSpec`; mod detection uses `ModList.get().isLoaded()`.
- **Optional integrations** — Curios, Accessories, LambDynamicLights, and Sodium Dynamic Lights are compile-only and not required at runtime.
- **Iris mixin** — Applied only when Iris (or Oculus) is present.

---

## Features

- Wear **Lanterns** and **Soul Lanterns** on your belt via **Curios** or **Accessories**.
- **Swinging physics** on equipped lanterns (configurable bounciness, left/back placement).
- **Dynamic lighting** when **LambDynamicLights** or **Sodium Dynamic Lights** is installed.
- **Iris** shader compatibility for held-item light mapping when Iris is present.

---

## Technical Info

|           |          |
| --------- | -------- |
| Loader    | NeoForge |
| Minecraft | 1.21.1   |
| Java      | 21       |

---

## Installation

1. Install [NeoForge](https://neoforged.net/) for Minecraft 1.21.1.

2. (Optional) Install at least one belt-slot mod: [Curios](https://modrinth.com/mod/curios) **or** [Accessories](https://modrinth.com/mod/accessories).
3. (Optional) Install [LambDynamicLights](https://modrinth.com/mod/lambdynamiclights) for dynamic light emission.
4. Drop the mod `.jar` into your `mods/` folder.
5. Launch the game.

---

## Credits

| Role         | Author                                                     |
| ------------ | ---------------------------------------------------------- |
| Original mod | [Toni (Txni)](https://modrinth.com/mod/immersive-lanterns) |
| 1.21.1 fix   | [Marie (kgbcupcake)](https://github.com/kgbcupcake)        |

---

## References

- [Original mod on Modrinth](https://modrinth.com/mod/immersive-lanterns)
- [Original source (multi-platform)](https://github.com/txnimc/ImmersiveLanterns)
- [LambDynamicLights](https://github.com/LambdAurora/LambDynamicLights)

---

## License

See the [`LICENSE`](./LICENSE) file for details. Original mod is licensed under [Toni's MMC License](https://license.txni.dev/).
