// Create an example of how to test for correctly formed URLs
verex expr = verex()
            .search_one_line()
            .start_of_line()
            .then( "http" )
            .maybe( "s" )
            .then( "://" )
            .maybe( "www." )
            .anything_but( " " )
            .end_of_line();

// Use verex's test() function to find if it matches
std::cout << expr.test("https://www.google.com") << std::endl;

// Ouputs the actual expression used: ^(?:http)(?:s)?(?:://)(?:www.)?(?:[^ ]*)$
std::cout << expr << std::endl;