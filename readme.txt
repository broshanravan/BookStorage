This application is implemented for managment of the checkout
till for a book store.

The books details are saved inside a json file "library.json" which is maintain inside the folder resources.
within the inventory class functions have been implemented to dd, update and delete the records in this file.
However due to lack of time and also due to the fact that this was in within the scope of our user requirement, the admin frontend for using these functions have not been implemented and hence the maintenance of "library.json" file needs to be done manually

Finally for the unit tests, due to lack of time only the ones essential to the application have been implemented.
The number of tests can be increased in future for more coverage.
There are also a few functions within the project that currently are not in use, but they will be brought to use when the nnext phase of implementation for improving the application starts

#################################### Manual:

The entry point of this application is the class "CustomerCheckout that contains the "viod main" function that starts running the application.
upon starting the application the user will be presented with a commandline screen where he/she will be asked to input the barcode of the book to be added to the list of purchased books or type the word "End" in order to complete the shopping.
upon completion the system will then displays the:

"Total price of all items purchased"
"Total Discount applied to the purchased"
"Total price after discount"

Also to run the code independently from the IDE, the goal "fatJar"  in gradle can be run to create an executable jar file.