Feature: Employee Confirmation

  Scenario: Invalid FirstName
    Given User is on 'hotelBooking' Page
    When user enters invalid FirstName
    Then display 'Please fill the FirstName'

  Scenario: Invalid LastName
    Given User is on 'hotelBooking' Page
    When user enters invalid LastName
    Then display 'Please fill the LastName'

  Scenario: Invalid Email
    Given User is on 'hotelBooking' Page
    When user enters invalid Email
    Then display 'Please fill the Email'

  Scenario: Invalid MobileNo
    Given User is on 'hotelBooking' Page
    When user enters invalid MobileNo
    Then display 'Please fill the MobileNo'
    
     Scenario: Invalid Salary
    Given User is on 'hotelBooking' Page
    When user enters invalid Salary
    Then display 'Please fill the Salary'
    
     Scenario: Invalid PayBand
    Given User is on 'hotelBooking' Page
    When user enters invalid PayBand
    Then display 'Please fill the Payband'
    
   Scenario: Invalid City
    Given User is on 'hotelBooking' Page
    When user enters invalid City
    Then display 'Please fill the City'

  Scenario: Invalid State
    Given User is on 'hotelBooking' Page
    When user enters invalid State
    Then display 'Please fill the State'