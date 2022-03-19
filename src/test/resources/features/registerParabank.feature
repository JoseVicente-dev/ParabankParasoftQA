Feature: Registrarse en la plataforma
  As cliente del banco Parabank
  I want to registrarme en la plataforma
  So that yo pueda administrar mis productos financieros en linea

  Scenario: Crear un nuevo usuario
    Given que estoy en la pagina de registro de la plataforma
    When diligencie mi informacion personal necesaria
      | firstName | Philip |
      | lastName | Sherman |
      | address | 42 Wallaby Way |
      | city | Sidney |
      | state | New South Wales |
      | zipCode | 2000 |
      | phoneNumber| 1234567890 |
      | ssn | 111-22-3333 |
      | username | r.Dentist |
      | password | Nemo |
      | confirmPassword | Nemo |
    Then se mostrara un mensaje que confirma mi registro en la plataforma

  Scenario: Usar un Username ya existente para crear un nuevo usuario
    Given que estoy en la pagina de registro
    When diligencie la informacion personal necesaria
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
      | confirmPassword | Nemo |
    And incluya un Username de un usuario ya existente
    Then se mostrara un mensaje de error indicando que el Username diligenciado ya existe y no se podra crear el usuario