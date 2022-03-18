Feature: Ingresar
  As cliente registrado en la plataforma
  I want to ingresar al aplicativo
  So that yo pueda consultar el estado de mis productos financieros

  Scenario: Ingresar al aplicativo con credenciales validas
    When ingrese mis credenciales de login validas
      | username | Mr.Dentist |
      | password | Nemo |
    Then podre consultar el estado de mis poductos

  Scenario: Intentar ingresar al aplicativo sin password
    When ingrese credenciales omitiendo el password
      | username | Mr.Dentist |
      | password |  |
    Then se mostrara un mensaje de error y no podre ingrear al aplicativo


