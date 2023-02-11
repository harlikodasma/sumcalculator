### Sum calculation endpoint
* Performs a summation of two integers and returns an object that contains both integers with their sum.
* Both request parameters (firstTerm, secondTerm) must be present and their values must be between 0 and 100 (included).
* Each calculation is temporarily stored on the server until it is shut down, which clears all data.
* Example:
  * Request: ```GET /api/sum/calculate?firstTerm=2&secondTerm=5```
  * Response: ```{ "firstTerm": 2, "secondTerm": 5, "result": 7 }```
### Past calculations query endpoint
* If any of the three previous calculation fields matches the given "number" parameter, they are returned as a list.
* The value of the given "number" parameter must be between 0 and 100 (included). However, it is not a required parameter. Its absence causes the endpoint to always return an empty list.
* Additionally, it is required to provide the order of the returned list as a boolean parameter "ascending". This will sort the returned list by each object's "result" field accordingly.
* Example:
  * Request: ```GET /api/sum/query?number=5&ascending=true```
  * Response: ```[ { "firstTerm": 2, "secondTerm": 5, "result": 7 } ]```
