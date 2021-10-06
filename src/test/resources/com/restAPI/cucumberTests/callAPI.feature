Feature: call via Rest API

  Scenario: Counting visit user
    When User wit id "4" sees greeting "(id=4) Welcome, Tom Ryan!"
    Then Count visit user "Tom" "Ryan" with id "4" were increased
    When User wit id "32" sees greeting "(id=32) Welcome, Clark Morris!"
    Then Count visit user "Clark" "Morris" with id "32" were increased

  Scenario: User sees their name
    When User wit id "20" sees greeting "(id=20) Welcome, Carla Darcy!"

  Scenario: User sees their name and id
    When User wit id "65" sees greeting "(id=65) Welcome, Roberts Miller!"

  Scenario: Call to incorrect defined url
    Then Error 500