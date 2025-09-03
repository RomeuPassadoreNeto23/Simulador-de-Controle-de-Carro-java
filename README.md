# Simulador de Controle de Carro

Este projeto é um simulador simples de controle de carro em Java, operado via terminal. O usuário pode interagir com o carro através de um menu de opções, realizando ações como ligar, desligar, acelerar, frear, virar, verificar velocidade e trocar marchas.

## Como funciona

- O programa exibe um menu com opções numeradas.
- O usuário escolhe a ação digitando o número correspondente.
- O carro só pode ser acelerado se estiver ligado e fora do ponto morto.
- A troca de marchas é sequencial e depende da velocidade atual.
- O carro só pode ser desligado se estiver parado e em ponto morto.

## Como usar

1. Compile o projeto:
2. javac src/Main.java
3. java -cp src Main
4. 3. Siga as instruções do menu no terminal, digitando o número da opção desejada e pressionando Enter.

## Opções do Menu

- **1**: Ligar o carro
- **2**: Desligar o carro
- **3**: Acelerar o carro
- **4**: Frear o carro
- **5**: Virar para esquerda/direita
- **6**: Verificar velocidade
- **7**: Trocar marcha
- **0**: Sair

## Requisitos

- Java 11 ou superior

---

Desenvolvido para fins didáticos.
