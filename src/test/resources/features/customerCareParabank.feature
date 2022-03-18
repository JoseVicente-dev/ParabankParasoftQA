Feature: Soporte al cliente
  As visitante de la pagina
  I want to realizar una peticion
  So that sea atendida por el area de servicio al cliente

  Scenario: Contactar con servicio al cliente
    Given que estoy en la seccion Custom Care
    When diligencie mi PQRS y la envie
      | name | Phillip Sherman |
      | email | p.sherman@pixar.com |
      | phone | 1234567890 |
      | message | ALL THE ANIMALS HAVE GONE MAD! |
    Then se confirmara el envio de la misma

  Scenario: Intentar enviar una PQRS sin datos de contacto
    Given que estoy en Custom Care
    When diligencie el mensaje de la PQRS y no suministre datos de contacto
      | name | Phillip Sherman |
      | message | ALL THE ANIMALS HAVE GONE MAD! |
    Then no se podra enviar la PQRS