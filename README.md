# Spring Boot AI with Ollama

---

A lightweight, plug-and-play starter that connects Spring Boot AI to your local Ollama runtime. It can be used to help Java developers to quickly get started and explore Spring Boot AI capabilities (no API key is required).

---

## ✨ Features

- **REST API Endpoints:** Comprehensive endpoints for chat, creative, focused, streaming, and custom AI interactions.
- **Local Ollama Integration:** Seamless integration with Ollama for local AI model inference, eliminating API key dependencies.
- **Modern Web UI:** An intuitive and interactive web interface for real-time chat experiences.
- **Configurable Requests:** Supports per-request configuration of AI models and temperature settings.
- **Streaming & JSON Generation:** Dedicated endpoints for streaming responses and structured JSON output.
- **Extensible Design:** Easily adaptable for developing coding assistants, chatbots, and other AI-powered applications.

## 🚀 Quick Start

Choose your preferred method to get started:

### Option 1: Local Installation

**Prerequisites:** Ensure Java and Maven are installed on your system.

**Install Ollama:**
```sh
curl -fsSL https://ollama.com/install.sh | sh
# Run and pull a model
ollama serve & sleep 2 && ollama pull llama3.3:latest
```

**Clone & Run the App:**
```sh
git clone https://github.com/devtario/spring-ollama-ai.git
cd spring-ollama-ai
mvn spring-boot:run
```

### Option 2: VS Code Dev Container

1. Install Docker.
2. Install VS Code.
3. Install the "Remote Development" extension pack in VS Code.
4. Open the project folder in VS Code.
5. Select **"Reopen in Container"** when prompted. The dev container will automatically set up Java, Maven, and Ollama.
