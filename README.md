# API para validação de senhas

Esta **API Rest** é usada para validar as senhas *(String)* que são passadas através de um método Post.

Feita por [Alison A. Mota](https://github.com/alison-mota)

-------------------------------

# Regras de negócio

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito *(número)*
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:

```c#
IsValid("") -> false  
IsValid("aa") -> false  
IsValid("ab") -> false  
IsValid("AAAbbbCc") -> false  
IsValid("AbTp9!foo") -> false  
IsValid("AbTp9!foA") -> false
IsValid("AbTp9 fok") -> false
IsValid("AbTp9!fok") -> true
```

> **_Nota:_**  Espaços em branco não são considerados como caracteres válidos.

-------------------------------

# Rodando a aplicação

- Baixe o código e rode a aplicação a partir da classe *ValidadorDeSenhaApplication.kt*
- Crie uma requisição do tipo Post *(usando Postman ou Insomnia)* para localhost:8080/api/v1/valida-senha
- Envie um json conforme o exemplo:
  - { "senha"= "insira_a_senha" }

### Input:
- Método: Post
- Um json com uma senha válida (string).

### Output:
- Um json com as informações:
  - Um boolean indicando se a senha é válida.
  - Uma mensagem indicando o problema *(se houver)*

### Exemplo de senha inválida:
- Input: 
```c#
  {
    "senha": "AbTpaLlfo"
  }
```

- Output:
```c#
  {
  "isValid": false,
  "mensagem": "É preciso ter um caractere numérico"
  }
```

### Exemplo de senha válida:
- Input:
```c#
  {
      "senha": "AbTp9!fok"
  }
```

- Output:
```c#
  {
    "isValid": true
  }
```

-------------------------------

# Caminho cognitivo
## Sobre o retorno
Optei por devolver a resposta em um json, usando um data class do Kotlin.  
Preferi dessa forma, pois como existem diversas regras para validação da senha fica mais fácil para quem for consumir a API, e caso receba algum erro, saber em tempo real o que precisa ser corrigido na requisição.   
Outro benefício por usar este DTO é o de não devolver dados sensíveis ao cliente.

## Sobre a organização do código
Vejo que é mais fácil entender o código quando as classes são organizadas por feature












### Sobre a documentação

Nesta etapa do processo seletivo queremos entender as decisões por trás do código, portanto é fundamental que o *README* tenha algumas informações referentes a sua solução.

Algumas dicas do que esperamos ver são:

- Instruções básicas de como executar o projeto;
- Detalhes sobre a sua solução, gostariamos de saber qual foi seu racional nas decisões;
- Caso algo não esteja claro e você precisou assumir alguma premissa, quais foram e o que te motivou a tomar essas decisões.

## Como esperamos receber sua solução

Esta etapa é eliminatória, e por isso esperamos que o código reflita essa importância.

Se tiver algum imprevisto, dúvida ou problema, por favor entre em contato com a gente, estamos aqui para ajudar.

Nos envie o link de um repo público com a sua solução.