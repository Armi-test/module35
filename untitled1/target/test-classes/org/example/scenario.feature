Feature: Find restaurant
  Scenario: choose restaurant city and try to find unexisiting dish
    Given url of restaurant 'https://dostaevsky.ru'
    When website is open confirm city
    Then assert chosen city is 'Санкт-Петербург'
  Scenario:  try to find unexisiting dish
    Given url of restaurant 'https://dostaevsky.ru'
    Then search for 'Осетр'
    Then make sure user is notified 'Такого блюда у нас нет :('
