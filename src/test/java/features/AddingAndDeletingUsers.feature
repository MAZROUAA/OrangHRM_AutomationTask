Feature: Addinf and deleting users
  I want to check that i can add users and delete them successfully.

  Scenario Outline: User addition then deletion
    Given  the user in the login page
    When   the user Enter "<username>" and "<password>" in Log in Form and Click on the login button
    And    the user Click on Admin tab on the left side menu
    Then   the user can Get the number of records
    When   the user add new user
    Then   the number of records will increase by one and user will be found by search
    When   the user Delete the new user
    Then   the number of records will decrease by one
    Examples:
      | username | password |
      | Admin    | admin123 |
