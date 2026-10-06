# 🤖 Batalha dos Robôs

Projeto desenvolvido em **Java** com o objetivo de criar uma competição entre robôs por meio de um sistema executado no terminal.

O sistema permite cadastrar robôs, consultar informações, visualizar os competidores e realizar combates entre eles.

---

## 🎮 Funcionalidades

### 🤖 Cadastro de Robôs

É possível cadastrar novos robôs informando seus principais atributos:

- Código do robô
- Nome
- Ataque
- Defesa

Além disso, cada robô inicia com:

- ⚡ Energia: `100`
- 🏆 Vitórias: `0`
- ❌ Derrotas: `0`
- ⭐ Pontos: `0`

O sistema também realiza validações para evitar dados inválidos.

<div align="center">

<img src="https://github.com/user-attachments/assets/c8a7d5f7-e5dc-4501-b688-911e0584c1f3" width="650">

</div>

---

### 🔎 Pesquisa de Robô pelo Código

O sistema permite pesquisar um robô utilizando seu código.

Quando encontrado, são exibidas informações como:

- Nome
- Código
- Ataque
- Defesa
- Energia
- Vitórias
- Derrotas
- Pontos
- Situação atual

<div align="center">

<img src="https://github.com/user-attachments/assets/b270c73a-09f7-454c-8ed1-a523c801a3a2" width="500">

</div>

---

### 📋 Lista de Competidores

Também é possível visualizar todos os robôs cadastrados e seus respectivos atributos.

Essa funcionalidade facilita a visualização dos participantes antes dos combates.

<div align="center">

<img src="https://github.com/user-attachments/assets/1f249b92-226f-4534-935f-c8343595606c" width="550">

</div>

---

### ⚔️ Combate entre Robôs

Os competidores podem ser selecionados pelo código para iniciar um combate.

Antes da batalha, o sistema verifica se:

- Os dois códigos são diferentes;
- Os robôs existem;
- Os robôs possuem energia suficiente para lutar.

Durante o combate, os robôs realizam ataques e suas energias são atualizadas de acordo com o resultado da batalha.

<div align="center">

<img src="https://github.com/user-attachments/assets/b3aef323-aeda-4157-91bf-5cf75fa85481" width="700">

</div>

---

## 🧠 Regras dos Robôs

Cada robô possui atributos que influenciam diretamente na competição.

| Atributo | Regra |
|---|---|
| 🔢 Código | Deve ser positivo e único |
| 🤖 Nome | Não pode estar vazio |
| ⚔️ Ataque | Entre `10` e `30` |
| 🛡️ Defesa | Entre `0` e `20` |
| ⚡ Energia | Inicia em `100` |
| 🏆 Vitórias | Inicia em `0` |
| ❌ Derrotas | Inicia em `0` |
| ⭐ Pontos | Inicia em `0` |

### Situação do Robô

Um robô é considerado:

**🟢 Disponível**  
Quando possui energia igual ou superior a `30`.

**🟡 Em recuperação**  
Quando possui energia abaixo de `30`.

---

## 🖥️ Menu do Sistema

O projeto possui um menu interativo executado diretamente pelo terminal.

```text
===== BATALHA DOS ROBÔS =====

0. Sair
1. Cadastrar Robô
2. Buscar Robô pelo código
3. Lista dos competidores
4. Combate individual
5. Rodada individual
6. Classificação
7. Estatísticas
8. Recuperar participante
9. Excluir participante
