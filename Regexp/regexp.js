// JAVASCRIPT //
// Plugin : VerbalExpressions

// Create an example of how to test for correctly formed URLs
var tester = VerEx()
            .startOfLine()
            .then( "http" )
            .maybe( "s" )
            .then( "://" )
            .maybe( "www." )
            .anythingBut( " " )
            .endOfLine();

// Create an example URL
var testMe = "https://www.google.com";

// Use RegExp object's native test() function
if( tester.test( testMe ) ) alert( "We have a correct URL "); // This output will fire
else alert( "The URL is incorrect" );

console.log( tester ); // Ouputs the actual expression used: /^(http)(s)?(\:\/\/)(www\.)?([^\ ]*)$/