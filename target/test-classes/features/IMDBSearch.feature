Feature: As a user
    I want to check TV Shows page IMDB rating


    @search 
    Scenario: Check search IMDB keyword
        Given user is on IMDB homepage
        When I enter "Avengers" in search field
        Then I should see "Results for " text displayed
        And The URL should contain "/find?q=Avengers&ref_=nv_sr_sm"
        Then I should see "Avengers" text displayed

    @search 
    Scenario Outline: Check search IMDB multiple keyword
        Given user is on IMDB homepage
        When I enter "<searchKeyword>" in search field
        Then I should see "Results for " text displayed
        And The URL should contain "<URL>"
        Then I should see "<searchKeyword>" text displayed
        
     Examples:
       |searchKeyword|URL|
       |Titanic|/find?q=Titanic&ref_=nv_sr_sm|
       |Batman|/find?q=Batman&ref_=nv_sr_sm|
      
        
    @search 
    Scenario: Check TV Shows page IMDB rating
        Given user is on IMDB homepage
        When I mousehover on Menu and click on "Top Rated Shows"
        Then I should redirected to "IMDb Top 250 TV - IMDb" page
        And The header should contain "Top Rated TV Shows"
        And get the results which is rated as "9.5" in the test result
        
        
        