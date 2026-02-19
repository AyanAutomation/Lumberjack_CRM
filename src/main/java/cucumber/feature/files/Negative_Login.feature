Feature: Testcase of of negaticve login scenarios

Scenario Outline: Testing negative login scenario with a combination of incorrect Credentials
Given Logging in with username <user id> and password <pass>

Examples:
  |   user id         | pass    |
  | Login_id          | 22355   |
  | aknnnb202@bm.com  | Pass    |
  | aknnnb202@bm.com  | 4455m235|
