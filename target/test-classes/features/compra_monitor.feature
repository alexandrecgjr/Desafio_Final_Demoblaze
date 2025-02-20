Feature: Fluxo de compra de um monitor no DemoBlaze

  Scenario: Comprar um monitor no site DemoBlaze
    Given Eu abro o site DemoBlaze
    When Eu acesso a categoria de monitores
    And Eu adiciono um monitor ao carrinho
    And Eu vou para o carrinho
    And Eu finalizo a compra preenchendo todos os campos
    Then A compra é concluída com sucesso