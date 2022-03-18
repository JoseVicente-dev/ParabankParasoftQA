Feature: Registrarse en la plataforma
  As cliente del banco Parabank
  I want to registrarme en la plataforma
  So that yo pueda administrar mis productos financieros en línea

  Background: Ingresar al módulo de registro
    Given que estoy en la página de registro de la plataforma
    When diligencie mi información personal necesaria con los siguientes datos
      | firstName | Philip |
      | lastName | Sherman |
      | address | 42 Wallaby Way |
      | city | Sidney |
      | state | New South Wales |
      | zipCode | 2000 |
      | phoneNumber| 1234567890 |
      | ssn | 111-22-3333 |
      | username | Mr.Dentist |
      | password | Nemo |
      | confirm | Nemo |

  Scenario: Crear un nuevo usuario
    Then se mostrará un mensaje que confrima mi registro en la plataforma

  Scenario: Usar un Username ya existente para crear un nuevo usuario
    When incluya un Username de un usuario ya existente
    Then se mostrará un mensaje de error indicando que el Username diligenciado ya existe y no se podrá crear el usuario