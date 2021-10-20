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
    - Considere os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplos:

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

- Faça um clone do repositório ou baixe os arquivos e abra em uma IDE;
- Rode a aplicação a partir da classe *ValidadorDeSenhaApplication.kt*
- Crie uma requisição do tipo Post *(usando Postman, Insomnia ou swagger)* para localhost:8080/api/v1/valida-senha
- Envie um json conforme o exemplo:
  - { "senha"= "insira_a_senha" }

### Exemplo de senha inválida:
- Input: 
```c#
  {
    "senha": "AbTpaLlfo"
  }
```

- Output:
```c#
  Status: 400 bad request
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
  Status: 200 ok
  
  {
    "isValid": true
  }
```

### Consultando o Swagger
- Essa aplicação conta com a documentação do swagger.
- Para usar:
  - Suba a aplicação; 
  - Acesse através do link http://localhost:8080/swagger-ui.html

-------------------------------

# Caminho cognitivo

## Sobre o código
- Vejo que é mais fácil entender o código quando as classes são organizadas por feature.
- Optei por usar Regex para validar os dados. Vejo que assim o código fica mais escalável e de fácil entendimento.
- Decidi organizar as variáveis *(Regex e as mensagens de erro)* em uma classe separada, pois caso as regras de negócio mudem, podemos alterar somente essa classe.

## Sobre o retorno
- Optei por devolver a resposta em um json, usando um data class do Kotlin.  
  - Além do boolean que foi pedido, inseri também um atributo com uma String *(mensagem)* de erro, se houver falha.
  - Se não houver falha, devolvo somente um json com isValid=true *(sem mensagem de erro para não ter redundância)*.
  - Preferi dessa forma, pois como existem diversas regras para validação da senha fica mais fácil para quem for consumir a API, e caso receba algum erro, saber em tempo real o que precisa ser corrigido na requisição.
  - Outro benefício por usar este DTO é o de não devolver dados sensíveis ao cliente.

## Sobre os testes
- Optei por fazer testes unitários e testes de integração para poder cobrir a maior quantidade de falhas possível.

