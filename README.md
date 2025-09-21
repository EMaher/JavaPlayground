# JavaPlayground

A ready-to-use Java development environment with GitHub Codespaces support.

## Features

- **Microsoft OpenJDK 21** pre-installed and configured
- **VS Code Java Extension Pack** with essential Java development tools
- **Maven and Gradle** support for project management
- **Debugging capabilities** with launch configurations
- **Auto-formatting and code organization** on save
- **Sample Hello World application** to get started quickly

## Getting Started

### Using GitHub Codespaces

1. Click the **Code** button on the GitHub repository page
2. Select **Codespaces** tab
3. Click **Create codespace on main**
4. Wait for the environment to be set up (this may take a few minutes)
5. Once ready, you'll have a fully configured Java development environment

### Local Development

If you prefer to work locally, ensure you have:
- Java 21 or later installed
- VS Code with the Java Extension Pack

### Running the Sample Application

1. Open the integrated terminal in VS Code
2. Navigate to the repository root
3. Compile and run the Hello World example:

```bash
# Compile the Java file
javac src/HelloWorld.java -d bin

# Run the compiled class
java -cp bin HelloWorld
```

Or use the VS Code debugging features:
- Open `src/HelloWorld.java`
- Press `F5` to run with debugging
- Or use the "Run" code lens that appears above the main method

## Project Structure

```
JavaPlayground/
├── .devcontainer/
│   └── devcontainer.json     # GitHub Codespaces configuration
├── .vscode/
│   ├── settings.json         # VS Code workspace settings
│   └── launch.json          # Debug configurations
├── src/
│   └── HelloWorld.java      # Sample Java application
├── .gitignore               # Git ignore patterns for Java projects
├── LICENSE                  # MIT License
└── README.md               # This file
```

## Development Features

- **IntelliSense**: Smart code completion and error detection
- **Debugging**: Full debugging support with breakpoints
- **Testing**: Built-in support for JUnit and other testing frameworks
- **Refactoring**: Advanced refactoring tools
- **Code Formatting**: Automatic code formatting on save
- **Import Management**: Automatic import organization

## Contributing

This is a playground repository for learning and experimenting with Java. Feel free to:
- Add your own Java examples
- Experiment with different Java features
- Practice coding exercises
- Test new libraries and frameworks

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.