# ⚽ Futebol MVC

> Sistema de gerenciamento de futebol reestruturado com o padrão arquitetural **MVC** — em Java puro.

---

## 🗂️ Sobre

O **Futebol MVC** é uma evolução do projeto de futebol, agora aplicando o padrão de arquitetura **Model-View-Controller (MVC)** sem o uso de frameworks — somente **Java puro**. A separação em camadas torna o código mais organizado, legível e fácil de manter.

---

## 🏗️ O que é MVC?

O **MVC** divide a aplicação em três camadas:

| Camada | Responsabilidade |
|---|---|
| 📦 **Model** | Representa os dados e as regras de negócio |
| 🖥️ **View** | Camada de apresentação — o que o usuário vê |
| 🎮 **Controller** | Intermediário entre Model e View — processa as ações |

> Com o MVC, cada parte do sistema tem uma responsabilidade clara, evitando código misturado e difícil de manter.

---

## ✨ Funcionalidades

- 👟 Gerenciamento de jogadores
- 🏟️ Gerenciamento de times
- 👔 Gerenciamento de técnicos
- 🏛️ Gerenciamento de estádios
- 🆚 Gerenciamento de partidas

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Função |
|---|---|
| ☕ Java | Linguagem principal |
| 🐬 MySQL | Banco de dados |
| 📦 Maven | Gerenciador de dependências |

> Sem frameworks — arquitetura MVC implementada manualmente em Java puro.

---

## 🚀 Como executar

```bash
# Clone o repositório
git clone https://github.com/Vinizapella/Futebol-MVC.git

# Acesse a pasta
cd Futebol-MVC

# Compile e execute
javac src/main/java/*.java
java -cp src/main/java Main
```

---

## 📁 Estrutura MVC

```
📦 Futebol-MVC
 ┣ 📂 src
 ┃ ┗ 📂 main
 ┃   ┗ 📂 java
 ┃     ┣ 📂 controller   
 ┃     ┣ 📂 model        
 ┃     ┣ 📂 view         
 ┃     ┗ 📄 Main.java
 ┗ 📄 README.md
```

---

## 👤 Autor

Feito com 🖤 por **Vinizapella** — projeto concluído para fins acadêmicos.

---

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/padrão-MVC-6a0dad?style=flat-square" />
  <img src="https://img.shields.io/badge/framework-nenhum-gray?style=flat-square" />
  <img src="https://img.shields.io/badge/status-concluído-brightgreen?style=flat-square" />
</p>
