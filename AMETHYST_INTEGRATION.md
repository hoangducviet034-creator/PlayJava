# PlayJava runtime integration plan

PlayJava targets a real Minecraft: Java Edition experience on Android, with Snapdragon/Adreno as the first optimization target.

## Runtime base

The Android Java launcher/runtime layer should be based on the current Amethyst Android project rather than implementing a JVM + LWJGL stack from scratch. Amethyst is the maintained successor to the archived PojavLauncher project and provides the Android-side launcher, mobile JREs, LWJGL integration, rendering/input layers, and support for Minecraft versions from old releases through current snapshots.

Reference: https://github.com/AngelAuraMC/Amethyst-Android

## PlayJava milestones

1. Replace the demo-only PlayJava launcher with a real launcher runtime base.
2. Package ARM64 Java runtimes required by supported Minecraft versions.
3. Add Microsoft account authentication and profile storage without bundling Minecraft game files.
4. Add version metadata/download management and `.minecraft` directory management.
5. Launch Minecraft 1.20.1 first.
6. Add Snapdragon/Adreno device profile and conservative defaults for RAM, renderer, resolution and chunk distance.
7. Add Fabric/Sodium support after vanilla 1.20.1 is stable.
8. Add shader/Iris support after renderer stability is verified.

## Snapdragon/Adreno profile

The first hardware profile is ARM64 Snapdragon + Adreno. The launcher should detect the GPU at runtime rather than assuming a specific Snapdragon model, then select renderer options and defaults appropriate for Adreno. Redmi Note 12 Turbo / Snapdragon 7+ Gen 2 is the primary development target.

## Licensing

Amethyst is LGPLv3. PlayJava must preserve applicable notices and license obligations when incorporating or linking to Amethyst/Pojav-derived components. Minecraft itself is not redistributed by PlayJava; users authenticate with their own legitimate Minecraft/Microsoft account and obtain game assets through the supported launcher flow.
