Feature: As a user
    I want to do register IMDB account

    @smoke
    Scenario: Check new account SignUp
        Given user is on IMDB homepage
        When I click SignIn on menu header
        Then I should redirected to "Sign in with IMDb - IMDb" page
        And I should see "Benefits of your free IMDb account" text displayed
        When I SignUp new account 
        Then I should see navigate to account page
        And I Logout as user
        
    @smoke  
    Scenario: Check login with newly created account
        Given user is on IMDB homepage
        And I click SignIn on menu header
        When I login as user
        Then I should see navigate to account page
        And I Logout as user