FROM mcr.microsoft.com/devcontainers/base:bookworm

RUN apt-get update && \
    apt-get install -y curl gnupg lsb-release ca-certificates

RUN curl -fsSL https://ollama.com/install.sh | sh

EXPOSE 11434
