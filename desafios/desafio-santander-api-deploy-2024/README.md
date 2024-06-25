# Desafio-santanderapi-deploy-2024
Java RESTful API criada para o desafio.

## Diagrama de Classes

```mermaid
classDiagram
  class User {
    - String nome
    - Account account
    - List<Feature> features
    - Card card
    - List<News> news
  }
  
  class Account {
    - String number
    - String agency
    - double balance
    - double limit
  }
  
  class Feature {
    - String icon
    - String description
  }
  
  class Card {
    - String number
    - double limit
  }
  
  class News {
    - String icon
    - String description
  }
  
  User "1" *-- "1" Account
  User "1" *-- "N"Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```
