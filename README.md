## My implementation of the Fizz Buzz Game on Android 

This apps was made using : 
- Jetpack Compose
- Hilt
- MaterialTheme 
- Repository Pattern
- Usecase Pattern

## How the App works ? 

The Screen class contains the routes available in the app. 
By default, the user starts in the Form Screen.

### Form Screen

In the Form Screen the User can input his options to play the Fizz Buzz game
The inputs handles error and we can only go to the next Screen if they are correctly filled.
When everything is done, press the "Fizz it !" button and enjoy the Fizz Buzz result list.

<img src="https://user-images.githubusercontent.com/7012127/177100957-6e12f5af-2866-4eb6-8e84-e5ec786db86b.png" alt="FormScreen" width="200"/>

### FizzBuzz Screen

Here you'll find your Fizz Buzz based on the inputs you entered.
The list updates each 20 items when we get to the bottom of the list.

<img src="https://user-images.githubusercontent.com/7012127/177100982-8a7f64be-2b4c-4189-8399-0963af3cfc13.png" alt="FizzBuzzScreen" width="200"/>

### Trivia 

- I made the app so that everything can be updated as simple as possible.
- You can rotate the app at any point and your data should be saved and everything should be accessible.
- I did a single test for the UseCase that get the FizzBuzz value

### Enhancement 

- I didn't do Compose UI test, but I'm going to learn them just after the test
- I could have used the Paging library for the list to update, but I went for a more simple solution
- Merge all the mutableState in the FormViewModel in a single parcelable object (I did try at first, but I got problems)
- Make everything more beautiful with the power of compose
