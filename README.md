# Rupture Reborn — Forge 1.21.11

A clean Forge 1.21.11 client-side mod project. This is an original rebuild; the uploaded legacy Rupture JAR is a Minecraft 1.8-era client package and is not a Forge 1.21.11 mod that can simply be renamed or dropped into `mods`.

## Included

- Forge mod metadata (`META-INF/mods.toml`) with mod ID `rupture_reborn`
- Right Shift opens the Rupture Reborn menu
- Toggleable FPS and coordinates HUD
- Java 21 toolchain
- GitHub Actions build using Gradle 9.3.0

This starter intentionally does not include automated combat modules. The menu and HUD are local client utilities.

## Build on GitHub

1. Create a new GitHub repository.
2. Upload the **contents of this folder** to the repository root. `.github/workflows/build.yml` must be at that exact path.
3. Open the **Actions** tab. A push starts `Build Rupture Reborn` automatically.
4. Open the successful run and download the artifact `rupture-reborn-forge-1.21.11`.
5. Extract the artifact ZIP and put the `.jar` into the `mods` folder of the Forge 1.21.11 game instance.

## Important

The build workflow is configured for Minecraft 1.21.11, Forge 61.2.5, Java 21 and Gradle 9.3.0. A successful CI build is not a substitute for testing in the exact launcher instance. The mod is client-side and intended for local single-player use.
