- ### Iniciar o projeto
  - Instale em sua máquina o `Maven` e o `JDK8`.
  - `$ cd backend-cabal-challenge`
  - `$ mvn spring-boot:run`
  - Ou utilizando *IDE* de sua escolha.
  
  Depois de iniciado, o projeto estará diponível no endereço: `http://localhost:8080/`

- ### API
- Deve-se utilizar o endpoint `api/commerces` executando uma requisição via `POST` com os seguintes parâmetros de body para o cadastro do comércio:
  ```
  {
    "name": "seu comércio",
    "cnpj": "cpnj do comércio",
  }
  ```
  - Requisição `GET` para visualização dos comércios cadastrados e `PUT` com `api/commerces/{id}` para alterá-los, seguido do body.
  
  - O mesmo pode ser feito para os outros endpoints `api/commerceAddress`, `api/commercePhones` e `api/commerceEmails`.
  
  ```
  {
    "number": "9999999999",
    "typeNumber": "1"
  }
   ```
  ``` 
  {
    "cep": "77777777",
    "publicPlace": "logradouro",
    "district": "distrito",
    "city": "cidade",
    "uf": "uf",
    "additionalAddress": "comércio"
  }
  ``` 
