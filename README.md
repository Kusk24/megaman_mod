# Megaman Sprite Rendering

## Description

This project demonstrates how to render a Megaman sprite by clipping the image from a source image. It focuses on sprite rendering techniques and does not include gameplay mechanics.

## Features

- Clipping a specific sprite from a source image
- Rendering the clipped sprite on a graphical interface
- Basic setup for sprite-based rendering in Java

## Project Structure

```
src/
├── edu/au/gdd/
│   ├── Global.java         # Game constants and configuration
│   ├── Main.java           # Application entry point
│   ├── SpriteRenderer.java # Handles sprite rendering logic
│   └── assets/
│       └── megaman.png     # Source image containing Megaman sprites
```

## Technical Details

- Built with Java and Swing
- Uses sprite-based graphics
- Demonstrates image clipping and rendering techniques

## Running the Project

1. Ensure you have Java installed on your system
2. Compile the source files
3. Run the application using:
   ```
   java gdd.Main
   ```

## Development Environment Setup

### Installing Java with SDKMan

1. Install SDKMan
   ```
   curl -s "https://get.sdkman.io" | bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"
   ```

2. Install Java using SDKMan
   ```
   sdk list java              # List available Java versions
   sdk install java 17.0.9-tem  # Install latest LTS version (recommended)
   sdk default java 17.0.9-tem  # Set as default
   ```

3. Verify installation
   ```
   java -version
   javac -version
   ```

### Setting up Visual Studio Code

1. Install Visual Studio Code
   - Download from [VS Code website](https://code.visualstudio.com/)
   - Install the downloaded package

2. Install Required Extensions
   - Open VS Code
   - Go to Extensions view (Cmd+Shift+X on macOS, Ctrl+Shift+X on Windows/Linux)
   - Install the following extensions:
     - Extension Pack for Java (includes):
       - Language Support for Java by Red Hat
       - Debugger for Java
       - Test Runner for Java
       - Maven for Java
       - Project Manager for Java
     - Java Code Generators

3. Configure VS Code Java Settings
   - Open Command Palette (Cmd+Shift+P on macOS, Ctrl+Shift+P on Windows/Linux)
   - Type "Java: Configure Java Runtime"
   - Select the installed JDK from SDKMan

4. Open Project
   - File -> Open Folder
   - Select the sprite-control project folder
   - Wait for VS Code to load and index the Java project

Now you're ready to develop and run the Megaman sprite rendering project!

## Requirements

- Java Runtime Environment (JRE)
- Java Development Kit (JDK) for compilation