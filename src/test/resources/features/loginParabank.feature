Feature: Ingresar
  As cliente registrado en la plataforma
  I want to ingresar al aplicativo
  So that yo pueda consultar el estado de mis productos financieros

  Scenario: Ingresar al aplicativo con credenciales validas
    Given que me he registrado correctamente en el aplicativo
    When ingrese mis credenciales de login validas
      | Username | Mr.Dentist |
      | Password | Nemo |
    Then podre consultar el estado de mis poductos

  Scenario: Intentar ingresar al aplicativo sin password
    When ingrese credenciales omitiendo el password
      | Username | Mr.Dentist |
      | Password |  |
    Then se mostrara un mensaje de error y no podre ingrear al aplicativo


