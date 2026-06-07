# Trabalho 3 - Componentes, Web Services (WS) e API

## Sistemas Distribuídos

**Universidade Federal do Ceará (UFC) - Campus Quixadá**  
**Curso:** Redes de Computadores  
**Disciplina:** Sistemas Distribuídos  
**Professor:** Rafael Braga  
**Aluno:** Carlos Eduardo Adão Piancó  

---

## Descrição

Este projeto é uma reimplementação do Trabalho 2 utilizando uma API REST com Spring Boot, substituindo a comunicação via RMI por comunicação HTTP.

O sistema representa uma loja chamada **Brilho & Aroma**, permitindo consulta de produtos, cálculo de compras, realização de pedidos e visualização administrativa dos dados.

---

## Arquitetura

O projeto possui os seguintes componentes:

```text
PROJETO_VENDAS_3
├── loja-api              # Servidor Spring Boot
├── cliente-python        # Cliente em Python
├── cliente-javascript    # Cliente em JavaScript
└── cliente-web           # Interface Web