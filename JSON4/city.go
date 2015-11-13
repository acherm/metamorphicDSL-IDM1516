/**
 * TP IDM
 * Maxime Lebastard
 */
package main

import "encoding/json"
import "fmt"

type City struct {
	Name string `json:"name"`
	Mayor Mayor `json:"mayor"`
	PostalCodes []string `json:"postalCodes"`
	Inhabitants int `json:"inhabitants"`
}

type Mayor struct {
	LastName string `json:"lastName"`
	FirstName string `json:"firstName"`
}

func main() {
	
	// Instanciate classes
	nathalieAppere := Mayor{"APPERE","Nathalie"}
	rennes := &City{
		Name: "Rennes",
		Mayor: nathalieAppere,
		PostalCodes: []string{"35000","35200","35700"},
		Inhabitants: 207178,
	}
	
	// Encode to json
	jsonCity, err := json.Marshal(rennes)
    if err != nil {
        fmt.Println(err)
        return
    }
    fmt.Println(string(jsonCity))
}
